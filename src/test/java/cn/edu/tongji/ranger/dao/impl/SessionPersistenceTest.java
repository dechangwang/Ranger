package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.init.HibernateUtil;
import cn.edu.tongji.ranger.model.LocationD;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testListAll(){
        List<LocationD> lds = sp.listAll(LocationD.class);
        System.out.println(lds);
    }

}