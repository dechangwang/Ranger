package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.*;
import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.model2show.Product2;
import cn.edu.tongji.ranger.model2show.TripSetoff2;
import cn.edu.tongji.ranger.service.OrderService;
import cn.edu.tongji.ranger.utils.OrderStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Order;
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
    @Autowired
    OrderformTrackDao orderformTrackDao;

    private List<OrderListItem> allorder= new ArrayList<OrderListItem>();

    public boolean comment(long oid,String content)
    {

      Orderform order= orderformDao.findByOrderId(oid);
        order.setComment(content);
        return orderformDao.updateOrder(order);

    }

    public Long findSupplierId(Long orderId) {
        Orderform orderform = orderformDao.findByOrderId(orderId);
        Long tripSetoffId = orderform.getTripSetoffId();
        TripSetoff2 tripSetoff2 = tripSetOffDao.getTripSetOffById(tripSetoffId);
        Long productId = tripSetoff2.getProductId();
        Product3 product3 = productDao.getProductById(productId);
        return product3.getSupplierId();
    }

    public boolean updateOrderForm(Orderform orderform) {
        return orderformDao.updateOrder(orderform);
    }

    public boolean addTourist(OrderformTourist tourist) {
        return orderFormTouristDao.createTourist(tourist);
    }

    public boolean changeOrderState(long orderid)
    {
        Orderform orderform=orderformDao.findByOrderId(orderid);
        int state=orderform.getState();
        switch (state) {
            case 1:orderform.setState(11);break;
            case 11:orderform.setState(12);break;
            case 12:orderform.setState(2);break;
            case 2: orderform.setState(3);break;
            case 3: orderform.setState(4);break;
            case 4:orderform.setState(5);break;
            case 5: orderform.setState(6);break;
            case 6:orderform.setState(7);break;
        }
        return orderformDao.updateOrder(orderform);
    }
    public OrderDetail getOrderDetail(long orderId)
    {
        OrderDetail detail=new OrderDetail();
        Orderform order=orderformDao.findByOrderId(orderId);
        Product3 product=null;
        TripSetoff2 tripSetoff=null;
        PriceDetail priceDetail=new PriceDetail();
        List<OrderformTourist> tourists=null;
        List<OrderformTrack> process=null;

        if(order!=null) {
            tripSetoff = tripSetOffDao.getTripSetOffById(order.getTripSetoffId());
            process = orderformTrackDao.getOrderTracksByOrderId(orderId);
            tourists = orderFormTouristDao.getOrderFormTouristByOrderId(order.getId());
        }
        if (tripSetoff!=null)
        product=productDao.getProductById(tripSetoff.getProductId());
        //product=tripSetoff.getProduct();

        int adultnum=0;
        int childnum=0;
        double adultprice=0;
        double childprice=0;

        if(tourists!=null&&product!=null){
            for(OrderformTourist tourist : tourists)
        {
            if(tourist.getTouristTypeId()==1)//成人
            {
                adultnum++;
                adultprice=tripPriceDao.getProductTouristPrice(product.getId(),tourist.getTouristTypeId());
            }
            if(tourist.getTouristTypeId()==2)//儿童
            {
                childnum++;
                childprice=tripPriceDao.getProductTouristPrice(product.getId(),tourist.getTouristTypeId());
            }
        }
        }
        priceDetail.setAdultnum(adultnum);
        priceDetail.setChildnum(childnum);
        priceDetail.setAdultPrice(adultprice);
        priceDetail.setChildPrice(childprice);
        priceDetail.setTotal(adultnum*adultprice+childnum*childprice);

        detail.setOrderform(order);
        detail.setOrderprocess(process);
        detail.setPrice(priceDetail);
        detail.setTripSetoff(tripSetoff);
        detail.setTourists(tourists);
        detail.setProduct(product);

        return detail;

    }


    public List<OrderListItem> getAllListOrder(long buyerid) {

        List<OrderListItem> itemlist= new ArrayList<OrderListItem>();
        List<Orderform> orderforms= orderformDao.findByBuyerId(buyerid);
        OrderListItem oditem;
        TripSetoff2 ts;
        Product3 pd=null;
        Angency angency=null;
        List<OrderformTourist> odft;
        for(Orderform od:orderforms)
        {
            double price=0;
            ts=tripSetOffDao.getTripSetOffById(od.getTripSetoffId());
            if(ts!=null)
                pd=productDao.getProductById(ts.getProductId());
          //  pd=ts.getProduct();

            odft=orderFormTouristDao.getOrderFormTouristByOrderId(od.getId());
             if(pd!=null)
                 angency=angencyDao.getAngencyById(pd.getSupplierId());
             //angency=pd.getSupplier();

            for(OrderformTourist tourist:odft)
            {
                long typeId=tourist.getTouristTypeId();
                if(pd!=null)
                price+=tripPriceDao.getProductTouristPrice(pd.getId(),typeId);

            }

            oditem=new OrderListItem();
            oditem.setOrderform(od);
            if(pd!=null)
            oditem.setProductName(pd.getName());
            if(ts!=null)
            oditem.setSetOffDate(ts.getTripSetoffDate());
            if(angency!=null)
            oditem.setSupplierName(angency.getName());
            oditem.setPrice(price);
            itemlist.add(oditem);
            System.out.println(oditem.getSupplierName());
        }
        allorder=itemlist;

        return itemlist;
    }

    public List<OrderListItem> getToBeACK(long buyerid) {
        if(allorder.isEmpty())
        allorder=getAllListOrder(buyerid);

        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==1||od.getOrderform().getState()==11||od.getOrderform().getState()==12)//1为待确认
            {
                result.add(od);
            }
        }
        return result;
    }


    public List<OrderListItem> getToPay(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==2)//2为待付款
            {
                result.add(od);
            }
        }
        return result;
    }

    public List<OrderListItem> getHasPaidDeposit(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==3)//3为已付定金
            {
                result.add(od);
            }
        }
        return result;
    }

    public List<OrderListItem> getHasPaidAll(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==4)//4为已付款
            {
                result.add(od);
            }
        }
        return result;
    }

    public List<OrderListItem> getHasFinished(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==5)//5为已完成
            {
                result.add(od);
            }
        }
        return result;
    }

    public List<OrderListItem> getHasEvaluate(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()==6)//6为已评价
            {
                result.add(od);
            }
        }
        return result;
    }

    public List<OrderListItem> getHasCanceled(long buyerid) {
        if(allorder.isEmpty())
            allorder=getAllListOrder(buyerid);
        List<OrderListItem> result=new ArrayList<OrderListItem>();
        for(OrderListItem od:allorder)
        {
            if(od.getOrderform().getState()== OrderStateEnum.已取消.getValue())//7为已取消
            {
                result.add(od);
            }
        }
        return result;
    }



}
