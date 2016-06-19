package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.SupplierOrderformDao;
import cn.edu.tongji.ranger.model.Orderform;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Dai on 6/19/16.
 */

@Repository("SupplierOrderformDao")
public class SupplierOrderformDaoImpl implements SupplierOrderformDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Long> getOrderformBySupplierId(Long supplierId) {
        List<Long> result = null;
        String sql = "select distinct orderform.id from product, trip_setoff, orderform " +
                "where product.product_id = trip_setoff.product_id and orderform.trip_setoff_id = trip_setoff.id and product.supplier_id = ";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        for(Object o : list){
            Map row = (Map)o;
            Long pid = ((BigInteger)row.get("pid")).longValue();
            result.add(pid);
        }
        return result;
    }
}
