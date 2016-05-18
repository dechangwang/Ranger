package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("BaseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Long create(T t) {
        sessionFactory.getCurrentSession().persist(t);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(t.getClass())
                .setProjection(Projections.projectionList().add(Projections.max("id")));
        return (Long) criteria.list().get(0);
    }

    public void update(T t) {
        sessionFactory.getCurrentSession().merge(t);
    }

    public void remove(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }
}
