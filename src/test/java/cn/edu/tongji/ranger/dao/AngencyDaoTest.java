package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.dao.impl.AngencyDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Sophie on 16/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:/Users/Sophie/Ranger/web/WEB-INF/applicationContext.xml"})
public class AngencyDaoTest {
    @Resource

    @Test
    public void findById() throws Exception {

    }

}