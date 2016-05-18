package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.TripPriceDao;
import cn.edu.tongji.ranger.model.TripPrice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 马二爷 on 2016/5/2.
 */
@Repository("TripPriceDao")
public class TripPriceDaoImpl implements TripPriceDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public double getProductTouristPrice(long productId, long touristTypeId) {
        Session session=sessionFactory.getCurrentSession();
        String hql="FROM TripPrice tp WHERE tp.productId=:pid and tp.touristTypeId=:tid and tp.isExpired !=1";
        Query query=session.createQuery(hql);
        query.setParameter("pid",productId);
        query.setParameter("tid",touristTypeId);
        TripPrice tp=(TripPrice)query.uniqueResult();
        if(tp!=null)
        return tp.getPrice();
        else return 0d;
    }
}