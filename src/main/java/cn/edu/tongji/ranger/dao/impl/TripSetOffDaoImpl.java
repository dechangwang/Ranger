package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.TripSetOffDao;
import cn.edu.tongji.ranger.model.TripSetoff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 马二爷 on 2016/4/30.
 */
@Repository("TripSetOffDao")
public class TripSetOffDaoImpl implements TripSetOffDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public TripSetoff getTripSetOffById(long id) {
        Session session=sessionFactory.getCurrentSession();
       return (TripSetoff)session.get(TripSetoff.class,id);
    }
}
