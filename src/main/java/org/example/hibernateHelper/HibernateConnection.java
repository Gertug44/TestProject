package org.example.hibernateHelper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConnection<T> {

    private static final SessionFactory ourSessionFactory;
    public static final Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
        session = ourSessionFactory.openSession();
    }

    public static void killSession(){
        session.close();
    }
}
