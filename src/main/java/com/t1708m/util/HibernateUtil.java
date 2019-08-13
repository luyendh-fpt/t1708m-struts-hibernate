package com.t1708m.util;

import com.t1708m.entity.Account;
import com.t1708m.entity.Credential;
import com.t1708m.entity.Role;
import com.t1708m.entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Calendar;
import java.util.HashSet;
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
//            String at = "0f3b7fa8-632f-4339-91d4-758da75ee1d1";
//            Credential credential = session.byId(Credential.class).getReference(at);
//            System.out.println(credential.getAccount().getStudent().getRollNumber());

            Account account = session.byId(Account.class).getReference("xuanhung");

//            Student student = Student.Builder.aStudent()
//                    .withRollNumber("A0023")
//                    .withName("Nhung")
//                    .withEmail("nhung@gmail.com")
//                    .build();

//            account.setStudent(student);
//            student.setAccount(account);

//            Credential credential = new Credential();
//
//            credential.setAccount(account);
//            account.addCredential(credential);

            Role role = new Role();
            role.setId(Calendar.getInstance().getTimeInMillis());
            role.setName("User");
            Role role2 = new Role();
            role.setId(Calendar.getInstance().getTimeInMillis() + 100);
            role.setName("Admin");
            HashSet<Role> roles = new HashSet<>();
            roles.add(role);
            roles.add(role2);
            account.setRoles(roles);

            session.save(account);

            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}
