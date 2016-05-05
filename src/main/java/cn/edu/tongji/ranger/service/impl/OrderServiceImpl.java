package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.*;
import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderformDao orderformDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private TripSetOffDao tripSetOffDao;
    @Autowired
    private OrderFormTouristDao orderFormTouristDao;
    @Autowired
    private TripPriceDao tripPriceDao;
    @Autowired
    private AngencyDao angencyDao;

    @Override
    public List<OrderListItem> getAllListOrder(long buyerid) {
        List<OrderListItem> itemlist= new ArrayList<OrderListItem>();
        List<Orderform> orderforms= orderformDao.findByBuyerId(buyerid);
        OrderListItem oditem;
        TripSetoff ts;
        Product pd;
        Angency angency;
        List<OrderformTourist> odft;
        for(Orderform od:orderforms)
        {
            double price=0;
            ts=tripSetOffDao.getTripSetOffById(od.getTripSetoffId());
            pd=productDao.getProductById(ts.getProductId());
            odft=orderFormTouristDao.getOrderFormTouristByOrderId(od.getId());
            angency=angencyDao.getAngencyById(pd.getSupplierId());

            for(OrderformTourist tourist:odft)
            {
                long typeId=tourist.getTouristTypeId();
                price+=tripPriceDao.getProductTouristPrice(pd.getId(),typeId);

            }
            oditem=new OrderListItem();
            oditem.setOrderform(od);
            oditem.setProductName(pd.getName());
            oditem.setSetOffDate(ts.getTripSetoffDate());
            oditem.setSupplierName(angency.getRegisterName());
            oditem.setPrice(price);
            itemlist.add(oditem);
        }
        return itemlist;
    }

    @Override
    public List<OrderListItem> getToBeACK(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==1)//1为待确认
            {
                result.add(od);
            }
        }
        return result;
    }

    @Override
    public List<OrderListItem> getToPay(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==2)//2为待付款
            {
                result.add(od);
            }
        }
        return result;
    }

    @Override
    public List<OrderListItem> getHasPaidDeposit(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==3)//3为已付定金
            {
                result.add(od);
            }
        }
        return result;
    }

    @Override
    public List<OrderListItem> getHasPaidAll(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==4)//4为已付款
            {
                result.add(od);
            }
        }
        return result;
    }

    @Override
    public List<OrderListItem> getHasFinished(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==5)//5为已完成
            {
                result.add(od);
            }
        }
        return result;
    }

    @Override
    public List<OrderListItem> getHasCanceled(long buyerid) {
        List<OrderListItem> all=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:all)
        {
            if(od.getOrderform().getState()==6)//6为已取消
            {
                result.add(od);
            }
        }
        return result;
    }

}
