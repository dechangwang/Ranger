package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.init.HibernateUtil;
import cn.edu.tongji.ranger.model.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.TransactionImpl;
import org.hibernate.ejb.criteria.AbstractNode;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/9/16.
 */
public class SessionPersistenceTestD {
    SessionPersistence sp;

    @Before
    public void before() {
        sp = new SessionPersistence();
        sp.setSessionFactory(HibernateUtil.getSessionFactory());

    }

    //    @Test
    public void testUpdate() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        Transaction trans = session.beginTransaction();
//        Angency angency  = (Angency) session.get(Angency.class,9L);
        //  System.out.println(angency);
        Angency angency1 = new Angency(9L, "LiSi", "身份证",
                "注册人借鉴是什么鬼啊", "123123123131", "2016512@q.com", "同济大学嘉定校区",
                "images\\5f.jpg", 12, "这是公司简介",
                "wang", "八爪鱼分公司", "2323232323233");
        angency1.setBrief("this is brief");
        session.saveOrUpdate(angency1);
        trans.commit();
    }

    @Test
    public void testQuery() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        Product product = (Product) session.get(Product.class, 32L);
        System.out.println(product.getName());
        System.out.println(product.getDuration());
        System.out.println(product.getPostAddress());
        System.out.println(product.getTripAccomodations());
//        Product product1 = new Product();
//        product1.setId(product.getId());
//        product1.setName(product.getName());
//        product1.setSummary(product.getSummary());
//        product1.setPostAddress(product.getPostAddress());
//        product1.setTripSetoffs(product.getTripSetoffs());
//        product1.setClickRate(product.getClickRate());
//        product1.setDuration(product.getDuration());
//        product1.setPostcode(product.getPostcode());
//        product1.setPostPhone(product.getPostPhone());
//        product1.setPostReceiver(product.getPostReceiver());
//        product1.setSearchContent(product.getSearchContent());
////        product1.getSetoffLocation(product.getSetoffLocation());
        product.setName("hjhjhjh");

//        HibernateUtil.getSessionFactory();
//        Session session1 = HibernateUtil.getSession();
        session.close();
        session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        product.setPostAddress("test addresss !!!");
        session.update(product);
        System.out.println(product);
//        session.close();
        transaction.commit();
    }

    //    @Test
    public void queryProduct() {
//        Criteria criteria = HibernateUtil.getSessionFactory().getCurrentSession().
//                createCriteria(Product.class)
//                .createCriteria("angency")
//                .add(Restrictions.eq("id", 7));
//        List<Product> products = criteria.list();
//        System.out.println(products);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        Product product = (Product) session.get(Product.class, 1L);

        System.out.println(product.getName());
//        Query query = session.createQuery("from Product p where p.supplier=:supplier");
//        List list= session.createSQLQuery("select * from product where supplier_id = 7").list();
//        for(Iterator iterator = list.iterator(); iterator.hasNext();){
//            Object[] objects = (Object[]) iterator.next();
//            System.out.println(objects[1]);
//        }
        long id = 7;
        List list = session.createSQLQuery("select * from product where supplier_id = " + id)
                .addScalar("id")
                .addScalar("name")
                .list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object[] objects = (Object[]) iterator.next();
            List listSetoff = session.createSQLQuery("select * from trip_setoff where product_id = " + objects[0])
                    .addScalar("trip_setoff_date")
                    .addScalar("update_time")
                    .list();
            if (listSetoff.iterator().hasNext()) {
                Object[] objectsSetoff = (Object[]) listSetoff.iterator().next();
                for (int i = 0; i < objectsSetoff.length; i++)
                    System.out.print(objectsSetoff[i] + " ");
                System.out.println();
            }

            //query price
            List listPrice = session.createSQLQuery("select * from trip_price where product_id = " + objects[0])
                    .addScalar("tourist_type_id")
                    .addScalar("price")
                    .addScalar("is_expired")
                    .list();
            System.out.println(listPrice);
            Iterator priceIt = listPrice.iterator();
            while (priceIt.hasNext()) {
                Object[] prices = (Object[]) priceIt.next();
                for (int i = 0; i < prices.length; i++)
                    System.out.print(prices[i] + " ");
                System.out.println();
            }
            System.out.println();
        }


    }

    public void testCreate() {
        LocationD ld = new LocationD();
        ld.setName("Henan");
        ld.setFatherId(new Long(2));
        sp.create(ld);
    }


    public void testFindById() {
        LocationD ld = sp.findById(1L, LocationD.class);
        System.out.println(ld);
    }


    public void testFindByExample() {
        LocationD ld = new LocationD();
        List<LocationD> lds = sp.findByExample(ld, LocationD.class);
        System.out.println(lds);

    }

    //    @Test
    public void testListAll() {
        List<TrafficType> results = sp.listAll(TrafficType.class);
        System.out.println(results.size());
        for (TrafficType result : results) {
            System.out.println(result);
        }
    }


//    @Test


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

        Location location = sp.findById(3L, Location.class);
        product.setSetoffLocation(location);
        product.setSupplier(angency);
//        Location location = new Location();
//
//        // change place name when repeate test
//        location.setName("南京");
//
//        location.setFatherId(2);
//
//        product.setSupplier(angency);
//        product.setSetoffLocation(location);

//        TripDestination td = new TripDestination();
//        TripDestination td2 = new TripDestination();
//        Location lt = sp.findById(2L, Location.class);
//        Location lt2 = sp.findById(3L, Location.class);
//        td.setLocation(lt);
//        td.setProduct(product);
//        td.setBrief("test tdd1");
//        td2.setLocation(lt2);
//        td2.setProduct(product);
//        td2.setBrief("test tdd2");
//        Set<TripDestination> locations = new HashSet<TripDestination>();
//        locations.add(td);
//        locations.add(td2);
//        product.setTripDestinations(locations);

        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());

//        TrafficType trafficType = new TrafficType();
//        trafficType.setType("出发");
//        trafficType.setBrief("出发方式");

        TrafficType trafficType = sp.findById(2L, TrafficType.class);

        TrafficType trafficTypeBack = sp.findById(1L, TrafficType.class);


        //TripTraffic
        Set<TripTraffic> tripTrafficSet = new HashSet<TripTraffic>();
        TripTraffic tripTraffic = new TripTraffic();

        tripTraffic.setUpdateTime(timestamp);
        tripTraffic.setIsExpired((byte) 1);
        tripTraffic.setTrafficType(trafficType);
        tripTraffic.setBrief("");
        tripTraffic.setProduct(product);


        TripTraffic tripTrafficBack = new TripTraffic();
        tripTrafficBack.setBrief("");
        tripTrafficBack.setUpdateTime(timestamp);
        tripTrafficBack.setIsExpired((byte) 1);
        tripTrafficBack.setTrafficType(trafficTypeBack);
        tripTrafficBack.setProduct(product);

        tripTrafficSet.add(tripTraffic);
        tripTrafficSet.add(tripTrafficBack);
//        System.out.println(tripTrafficSet);

        product.setTripTraffics(tripTrafficSet);
//        System.out.println(product.getTripTraffics());
        sp.attachDirty(product);
//        System.out.println(product.getTripTraffics());

    }

}