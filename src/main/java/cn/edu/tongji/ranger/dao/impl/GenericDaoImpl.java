package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by daidongyang on 5/14/16.
 */

@Repository("GenericDao")
public class GenericDaoImpl implements GenericDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(obj);
    }

    public <T> List<T> findByExample(T instance, Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(type);
        criteria.add(Example.create(instance));
        List<T> results = criteria.list();
        return results;
    }

    public <T> T findById(Long id, Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        T instance = (T)session.get(type, id);
        return instance;
    }

    @Override
    public <T> void deleteById(Long id, Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        T entity = (T)session.load(type, id);
        session.delete(entity);
        session.flush();
    }

    @Override
    public void persist(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
    }
}
