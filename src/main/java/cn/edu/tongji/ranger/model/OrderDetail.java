package cn.edu.tongji.ranger.model;

import cn.edu.tongji.ranger.model2show.Product2;
import cn.edu.tongji.ranger.model2show.TripSetoff2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by 马二爷 on 2016/5/4.
 *
 */

public class OrderDetail {

    private Orderform orderform;
    private Product3 product;
    private TripSetoff2 tripSetoff;
    private PriceDetail price;
    private List<OrderformTrack> orderprocess;
    private List<OrderformTourist> tourists;

    public List<OrderformTourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<OrderformTourist> tourists) {
        this.tourists = tourists;
    }



    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }

    public Product3 getProduct() {
        return product;
    }

    public void setProduct(Product3 product) {
        this.product = product;
    }

    public TripSetoff2 getTripSetoff() {
        return tripSetoff;
    }

    public void setTripSetoff(TripSetoff2 tripSetoff) {
        this.tripSetoff = tripSetoff;
    }

    public List<OrderformTrack> getOrderprocess() {
        return orderprocess;
    }

    public void setOrderprocess(List<OrderformTrack> orderprocess) {
        this.orderprocess = orderprocess;
    }



    public PriceDetail getPrice() {
        return price;
    }

    public void setPrice(PriceDetail price) {
        this.price = price;
    }


}
