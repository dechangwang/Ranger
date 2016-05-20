package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.ProductDao;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model.Product3;
import cn.edu.tongji.ranger.model2show.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 马二爷 on 2016/4/30.
 */
@Repository("ProductDao")
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product3 getProductById(long pid) {
    Session session=sessionFactory.getCurrentSession();
        return (Product3)session.get(Product3.class,pid);
    }
}
