package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.init.HibernateUtil;
import cn.edu.tongji.ranger.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/9/16.
 */
public class SessionPersistenceTest {
    SessionPersistence sp;
    @Before
    public void before(){
        sp = new SessionPersistence();
        sp.setSessionFactory(HibernateUtil.getSessionFactory());

    }

    public void testCreate(){
        LocationD ld = new LocationD();
        ld.setName("Henan");
        ld.setFatherId(new Long(2));
        sp.create(ld);
    }


    public void testFindById(){
        LocationD ld = sp.findById(1L,LocationD.class);
        System.out.println(ld);
    }


    public void testFindByExample(){
        LocationD ld = new LocationD();
        List<LocationD> lds = sp.findByExample(ld, LocationD.class);
        System.out.println(lds);

    }

//    @Test
    public void testListAll(){
        List<TripDetail>  results = sp.listAll(TripDetail.class);
        System.out.print(results.size());
        for(TripDetail result : results){
            System.out.println(result);
        }
    }

    @Test
    public void testProductListAll(){
        List<Product> results = sp.listAll(Product.class);
        System.out.print(results.size());
        for(Product result : results){
            System.out.println(result);
        }
    }

//    @Test
    public void testCreateProduct(){
        Product product = new Product();
        product.setName("北京三日游");
        product.setSummary("北京三日游");
        product.setDuration(3);
        product.setSearchContent("北京 三日游");
        product.setPostcode("201804");
        product.setPostPhone("12345678");
        product.setPostAddress("SiPing Road");
        product.setPostReceiver("wdchang");
        Angency angency = sp.findById(7L,Angency.class);
        Location location = new Location();

        // change place name when repeate test
        location.setName("Hunan");
        location.setFatherId(2);

        product.setSupplier(angency);
        product.setSetoffLocation(location);

        TripDestination td = new TripDestination();
        Location lt = sp.findById(2L, Location.class);
        td.setLocation(lt);
//        td.setProduct(product);
        td.setBrief("");
        List<TripDestination> locations = new ArrayList<TripDestination>();
        locations.add(td);

        product.setTripDestinations(locations);

        sp.attachDirty(product);

    }

}