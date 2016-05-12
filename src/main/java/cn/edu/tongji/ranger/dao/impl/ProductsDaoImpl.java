package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.ProductsDao;
import cn.edu.tongji.ranger.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Repository("ProductsDao")
public class ProductsDaoImpl implements ProductsDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
//            Transaction trans = session.beginTransaction();
        session.saveOrUpdate(product);
//            trans.commit();


        //sessionFactory.getCurrentSession().persist(product);
    }

    public <T> T findById(Long id, Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        T result = null;

        T instance = (T) session.get(type, id);
        result = instance;

        return result;
    }

    public void create(TripPicture tripPicture) {
        sessionFactory.getCurrentSession().persist(tripPicture);
    }

    public void create(TripDetail tripDetail) {
        sessionFactory.getCurrentSession().persist(tripDetail);
    }

    public void create(TripAccomodation tripAccomodation) {
        sessionFactory.getCurrentSession().persist(tripAccomodation);
    }

    public void create(TripDestination tripDestination) {
        sessionFactory.getCurrentSession().persist(tripDestination);
    }

    public void create(TripSetoff tripSetoff) {
        sessionFactory.getCurrentSession().persist(tripSetoff);
    }

    public void create(TripTraffic tripTraffic) {
        sessionFactory.getCurrentSession().persist(tripTraffic);
    }

    public void create(TrafficType trafficType) {
        sessionFactory.getCurrentSession().persist(trafficType);
    }

    public void create(Location location) {
        sessionFactory.getCurrentSession().persist(location);
    }
}
