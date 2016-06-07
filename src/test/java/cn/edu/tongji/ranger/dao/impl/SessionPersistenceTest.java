package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.init.HibernateUtil;
import cn.edu.tongji.ranger.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/9/16.
 */
public class SessionPersistenceTest {
    SessionPersistence sp;

    @Before
    public void before() {
        sp = new SessionPersistence();
        sp.setSessionFactory(HibernateUtil.getSessionFactory());

    }

    @Test
    public void testTripPicture() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        TripPicture tripPicture = new TripPicture("images\2.png", "zhehsi biref", Long.parseLong("51"));
        session.persist(tripPicture);
       // session.close();
    }


    // @Test
    public void testBankCard() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Criteria criteria = session
                .createCriteria(BankCard.class)
                .add(Restrictions.eq("cardNumber", "888888888888"));

        List<BankCard> list = criteria.list();
        System.out.println(list);
        System.out.print(list.size());
        transaction.commit();
    }


    //    @Test
    public void testListAll() {
        List<TripSetoff> results = sp.listAll(TripSetoff.class);
        System.out.println(results.size());
        for (TripSetoff result : results) {
            System.out.println(result);
        }
    }


//    @Test

    //@Test

    public void testProductListAll() {
        List<Product> results = sp.listAll(Product.class);
        System.out.println(results.size());
        for (Product result : results) {
//            System.out.println(result);
            System.out.println(result.getTripSetoffs().size());
        }
    }

    //    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("北京三日游");
        product.setSummary("北京三日游");
        product.setDuration(3);
        product.setSearchContent("北京 三日游");
        product.setPostcode("201804");
        product.setPostPhone("12345678");
        product.setPostAddress("SiPing Road");
        product.setPostReceiver("wdchang");
        Angency angency = sp.findById(9L, Angency.class);
        Location location = new Location();

        // change place name when repeate test


        location.setName("南京");

        location.setFatherId(2);

        product.setSupplier(angency);
        product.setSetoffLocation(location);

        TripDestination td = new TripDestination();
        Location lt = sp.findById(2L, Location.class);
        td.setLocation(lt);
        td.setProduct(product);
        td.setBrief("");
        Set<TripDestination> locations = new HashSet<TripDestination>();
        locations.add(td);
        product.setTripDestinations(locations);
        sp.attachDirty(product);

    }

}