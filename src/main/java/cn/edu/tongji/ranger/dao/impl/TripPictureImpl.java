package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.TripPictureDao;
import cn.edu.tongji.ranger.model.TripPicture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangdechang on 2016/6/6.
 */

@Repository("TripPictureDao")
public class TripPictureImpl implements TripPictureDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Long create(TripPicture tripPicture) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(tripPicture);
        return 1L;
    }

    @Override
    public void update(TripPicture tripPicture) {

    }

    @Override
    public void remove(TripPicture tripPicture) {

    }
}
