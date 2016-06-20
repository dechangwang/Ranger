package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.dao.OrderFormTouristDao;
import cn.edu.tongji.ranger.dao.SupplierOrderformDao;
import cn.edu.tongji.ranger.dao.TripPriceDao;
import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.model2show.TripSetoff2;
import cn.edu.tongji.ranger.service.SupplierOrderformService;
import cn.edu.tongji.ranger.utils.IdAndStrWrapper;
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

    @Autowired
    private OrderFormTouristDao orderFormTouristDao;

    @Autowired
    private TripPriceDao tripPriceDao;

    @Override
    public List<OrderListItem> getOrderformsBySupplierId(Long supplierId) {
        List<OrderListItem> orderListItems = new ArrayList<>();

        List<Long> orderformIds = supplierOrderformDao.getOrderformBySupplierId(supplierId);
        for (Long orderformId : orderformIds) {
            try {
                Orderform orderform = genericDao.findById(orderformId, Orderform.class);
                TripSetoff2 tripSetoff2 = genericDao.findById(orderform.getTripSetoffId(), TripSetoff2.class);
                Product3 product3 = genericDao.findById(tripSetoff2.getProductId(), Product3.class);
                Angency angency = genericDao.findById(product3.getSupplierId(), Angency.class);
                List<OrderformTourist> orderformTourists = orderFormTouristDao.getOrderFormTouristByOrderId(orderform.getId());
                double price = 0;
                for (OrderformTourist orderformTourist : orderformTourists) {
                    long typeId = orderformTourist.getTouristTypeId();
                    price += tripPriceDao.getProductTouristPrice(tripSetoff2.getProductId(), typeId);
                }
                orderform.setCost(price);
                genericDao.saveOrUpdate(orderform);
                OrderListItem orderListItem = new OrderListItem();
                orderListItem.setOrderform(orderform);
                orderListItem.setProductName(product3.getName());
                orderListItem.setSetOffDate(tripSetoff2.getTripSetoffDate());
                orderListItem.setPrice(price);
                orderListItem.setSupplierName(angency.getName());
                orderListItems.add(orderListItem);
            } catch (RuntimeException e) {
                e.printStackTrace();
                continue;
            }
        }
        Collections.sort(orderListItems, new Comparator<OrderListItem>() {
            @Override
            public int compare(OrderListItem o1, OrderListItem o2) {
                try{
                    return o1.getOrderform().getBookTime().compareTo(o2.getOrderform().getBookTime());
                }catch(NullPointerException e){
                    return 0;
                }
            }
        });

        return orderListItems;
    }

    @Override
    public int uploadConfirm(IdAndStrWrapper idAndStrWrapper) {
        long id = idAndStrWrapper.getId();
        String content = idAndStrWrapper.getContent();
        try{
            Orderform orderform = genericDao.findById(id, Orderform.class);
            orderform.setState(12);
            orderform.setConfirmListBuyer(content);
            genericDao.saveOrUpdate(orderform);
            return 1;
        }catch(RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int uploadReConfirm(IdAndStrWrapper idAndStrWrapper) {
        long id = idAndStrWrapper.getId();
        String content = idAndStrWrapper.getContent();
        try{
            Orderform orderform = genericDao.findById(id, Orderform.class);
            orderform.setState(2);
            orderform.setConfirmListSupplier(content);
            genericDao.saveOrUpdate(orderform);
            return 1;
        }catch(RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<OrderListItem> getOrderformsBySupplierId2(Long supplierId) {
        List<Orderform> orderforms = new ArrayList<Orderform>();
        List<OrderListItem> results = new ArrayList<>();
        try {
            List<Long> orderformIds = supplierOrderformDao.getOrderformBySupplierId(supplierId);

            for (Long orderformId : orderformIds) {
                Orderform orderform = genericDao.findById(orderformId, Orderform.class);
                orderforms.add(orderform);
            }
            System.out.println(orderforms);
            Collections.sort(orderforms, new Comparator<Orderform>() {
                @Override
                public int compare(Orderform o1, Orderform o2) {
                    try {
                        return o1.getBookTime().compareTo(o2.getBookTime());
                    } catch (NullPointerException e) {
                        return 0;
                    }

                }
            });
            System.out.println(orderforms);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return results;
    }
}
