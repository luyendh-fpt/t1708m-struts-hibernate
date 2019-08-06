package com.t1708m.util;

import com.t1708m.entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.save(Student.Builder.aStudent()
                    .withRollNumber("A0023")
                    .withName("Nhung")
                    .withEmail("nhung@gmail.com")
                    .build());

            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}
