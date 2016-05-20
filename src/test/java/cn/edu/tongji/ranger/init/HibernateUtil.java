package cn.edu.tongji.ranger.init;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by daidongyang on 5/7/16.
 */
public class HibernateUtil {
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {
        // logger.info("Trying to create a sessionFactory");
        try {
            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (HibernateException e) {
            System.err.println("failed to created sessionfactory!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err
                    .println("failed to created sessionfactory after HibernateException");
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}

