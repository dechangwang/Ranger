package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.dao.SupplierOrderformDao;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.SupplierOrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Dai on 6/19/16.
 */

@Service("SupplierOrderformService")
@Transactional
public class SupplierOrderformDaoServiceImpl implements SupplierOrderformService {

    @Autowired
    private SupplierOrderformDao supplierOrderformDao;

    @Autowired
    private GenericDao genericDao;

    @Override
    public List<Orderform> getOrderformsBySupplierId(Long supplierId) {
        List<Long> orderformIds = supplierOrderformDao.getOrderformBySupplierId(supplierId);
        List<Orderform> orderforms = new ArrayList<Orderform>();
        for(Long orderformId : orderformIds){
            Orderform orderform = genericDao.findById(orderformId, Orderform.class);
            orderforms.add(orderform);
        }
        System.out.println(orderforms);
        Collections.sort(orderforms, new Comparator<Orderform>() {
            @Override
            public int compare(Orderform o1, Orderform o2) {
                try{
                    return o1.getBookTime().compareTo(o2.getBookTime());
                }catch(NullPointerException e){
                    return 0;
                }

            }
        });
        System.out.println(orderforms);

        return orderforms;
    }
}
