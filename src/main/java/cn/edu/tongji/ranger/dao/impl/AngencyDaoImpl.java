package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.AngencyDao;
import cn.edu.tongji.ranger.model.Angency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 马二爷 on 2016/5/2.
 */
@Repository("AngencyDao")
public class AngencyDaoImpl implements AngencyDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Angency getAngencyById(long id) {
        Session session=sessionFactory.getCurrentSession();
        return (Angency)session.get(Angency.class,id);
    }
}
