package com.t1708m.service;

import com.t1708m.entity.Student;
import com.t1708m.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {

    private static Logger LOGGER = Logger.getLogger(StudentService.class.getSimpleName());

    public void save(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            LOGGER.log(Level.INFO, String.format("Save student success with rollnumber %s", student.getRollNumber()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Save student error, stack trace"), e);
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            students = session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Can not findAll student, stack trace"), e);
        }
        return students;
    }

    public Student findById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            transaction.commit();
            return student;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Can not findById %s student, stack trace", id), e);
            return null;
        }
    }

    public void delete(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                LOGGER.log(Level.INFO, String.format("Delete student success with rollnumber %s", id));
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Can not delete student with rollnumber %s, stack trace", id), e);
        }
    }
}
