package cn.edu.tongji.ranger.init;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/7/16.
 */
public class HibernateUtilTest {

    @Test
    public void createSessionFactory() throws Exception {
        System.out.println(HibernateUtil.createSessionFactory());
    }

    @Test
    public void getSessionFactory() throws Exception {
        System.out.println(HibernateUtil.getSessionFactory());
    }
}