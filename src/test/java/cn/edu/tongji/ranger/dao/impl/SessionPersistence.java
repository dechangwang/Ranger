package cn.edu.tongji.ranger.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by daidongyang on 5/7/16.
 */
public class SessionPersistence {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void create(Object obj){
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(obj);
            transaction.commit();
        }catch(RuntimeException e){
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void attachDirty(Object instance) {

        try {
            Session session = sessionFactory.getCurrentSession();
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(instance);
            trans.commit();

        } catch (RuntimeException re) {

            throw re;
        }
    }


    public <T>T findById(Long id, Class<T> type){
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        T result = null;
        try{
            T instance = (T)session.get(type, id);
            trans.commit();
            result = instance;
        }catch(RuntimeException e){
            e.printStackTrace();
            trans.rollback();
        }
        return result;

    }

    public <T> List<T> findByExample(T instance, Class<T> type){
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<T> results = null;
        try{
            results = session.createCriteria(type).add(Example.create(instance)).list();
            trans.commit();
        }catch(RuntimeException e){
            e.printStackTrace();
            trans.rollback();
        }
        return results;
    }

    public <T> List<T> listAll(Class<T> type){
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<T> results = null;
        try{
            results = session.createCriteria(type).list();
            Criteria criteria = session.createCriteria(type);
            trans.commit();
        }catch(RuntimeException e){
            e.printStackTrace();
            trans.rollback();
        }
        return results;
    }

    public <T> void deleteById(Long id, Class<T> type){
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            T entity = (T)session.load(type, id);
            session.delete(entity);
            session.flush();
            transaction.commit();
        }catch(RuntimeException e){
            e.printStackTrace();
            transaction.rollback();
        }
    }


}
