package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.AngencyDao;
import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.model.Angency;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */

@Repository("AngencyDao")
public class AngencyDaoImpl implements AngencyDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Angency angency) {
        sessionFactory.getCurrentSession().persist(angency);
    }

    public List<Angency> findByName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Angency.class).add(Restrictions.eq("cname", name));
        return (List<Angency>) criteria.list();
    }

    public Angency findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Angency angency = (Angency) session.get(Angency.class,id);
        return angency;
    }

    public boolean updateAngency(Angency angency) {
        Session session = sessionFactory.getCurrentSession();
        session.update(angency);
        return true;
    }
}
