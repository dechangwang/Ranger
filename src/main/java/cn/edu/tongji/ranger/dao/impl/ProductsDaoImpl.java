package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.ProductsDao;
import cn.edu.tongji.ranger.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Repository("ProductsDao")
public class ProductsDaoImpl implements ProductsDao {
    @Autowired
    private SessionFactory sessionFactory;

    public long create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(product.getClass())
                .setProjection(Projections.projectionList().add(Projections.max("id")));
        return (Long) criteria.list().get(0);
     }

    public <T> T findById(Long id, Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        T result = null;

        T instance = (T) session.get(type, id);
        result = instance;

        return result;
    }

    public List<MyProduct> findBySupplierId(long supplierID) {
        Session session = sessionFactory.getCurrentSession();
        List<MyProduct> productList = new ArrayList<MyProduct>();
        List list = session.createSQLQuery("select * from product where supplier_id = " + supplierID)
                .addScalar("product_id")
                .addScalar("name")
                .list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object[] objects = (Object[]) iterator.next();
            MyProduct myProduct = new MyProduct();
            boolean hasAllData = true;
            List listSetoff = session.createSQLQuery("select * from trip_setoff where product_id = " + objects[0])
                    .addScalar("trip_setoff_date")
                    .addScalar("update_time")
                    .list();
            if (listSetoff.iterator().hasNext()) {
                Object[] objectsSetoff = (Object[]) listSetoff.iterator().next();

               // myProduct.addSetOffTime(objectsSetoff[0] + "");
                myProduct.setRelease_time(objectsSetoff[1] + "");
                Iterator iterator1 = listSetoff.iterator();
                while(iterator1.hasNext()){
                    Object[] obj = (Object[]) iterator1.next();
                    myProduct.addSetOffTime(obj[0] + "");
                    //System.out.println(obj[0]+" ");
                }
            } else {
                hasAllData = false;
            }

            //query price
            List listPrice = session.createSQLQuery("select * from trip_price where product_id = " + objects[0])
                    .addScalar("tourist_type_id")
                    .addScalar("price")
                    .addScalar("is_expired")
                    .list();
            if (listPrice.size() == 0) {
                hasAllData = false;
            }
            String priceInfo = "";
            boolean state = false;
            Iterator priceIt = listPrice.iterator();
            while (priceIt.hasNext()) {
                Object[] prices = (Object[]) priceIt.next();

                priceInfo = priceInfo + " " + prices[1];
                state = (Boolean) prices[2];
            }
            if (hasAllData) {
                myProduct.setProduct_id(objects[0] + "");
                myProduct.setProduct_name(objects[1] + "");
                myProduct.setPrice(priceInfo);
                if (state) {
                    myProduct.setState("已过期");
                } else {
                    myProduct.setState("未过期");
                }
                productList.add(myProduct);
            }


        }


        /*List list = session.createSQLQuery("select * from product where supplier_id = "+id)
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
            while(priceIt.hasNext()){
                Object[] prices = (Object[]) priceIt.next();
                for (int i = 0;i<prices.length;i++)
                    System.out.print(prices[i]+" ");
                System.out.println();
            }
            System.out.println();
        }*/
        return productList;
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

   /* public Product findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Angency.class,id);
        return product;
    }*/

    public void create(TripPicture tripPicture) {
        sessionFactory.getCurrentSession().persist(tripPicture);
    }

    public void create(TripDetail tripDetail) {
        sessionFactory.getCurrentSession().persist(tripDetail);
    }

    public void create(TripAccomodation tripAccomodation) {
        sessionFactory.getCurrentSession().persist(tripAccomodation);
    }

    public void create(TripDestination tripDestination) {
        sessionFactory.getCurrentSession().persist(tripDestination);
    }

    public void create(TripSetoff tripSetoff) {
        sessionFactory.getCurrentSession().persist(tripSetoff);
    }

    public void create(TripTraffic tripTraffic) {
        sessionFactory.getCurrentSession().persist(tripTraffic);
    }

    public void create(TrafficType trafficType) {
        sessionFactory.getCurrentSession().persist(trafficType);
    }

    public void create(Location location) {
        sessionFactory.getCurrentSession().persist(location);
    }
}
