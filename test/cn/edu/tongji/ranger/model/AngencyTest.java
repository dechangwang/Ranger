package cn.edu.tongji.ranger.model;

import cn.edu.tongji.ranger.dao.AccountDao;
import cn.edu.tongji.ranger.dao.impl.AccountDaoImpl;
import cn.edu.tongji.ranger.service.AccountService;
import cn.edu.tongji.ranger.service.impl.AccountServiceImpl;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by wangdechang on 2016/4/25.
 */
public class AngencyTest extends TestCase {
    public void testAddAngency(){
//        Configuration cfg = new Configuration().configure();
//        ServiceRegistry registry = new ServiceRegistryBuilder()
//                .applySettings(cfg.getProperties()).buildServiceRegistry();
//        SessionFactory factory = cfg.buildSessionFactory(registry);
//        Session session = factory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Angency angency = new Angency(1,"八爪鱼","认证","125125125125","tongji@126.com",
//                "上海市同济大学曹安公路","D:\\pictruce\\ico.png",12563,"欢迎来到八爪鱼旅游");
//        AccountService accountService = new AccountServiceImpl();
       // a.create(angency);
//        session.save(angency);
//        tx.commit();

    }

}