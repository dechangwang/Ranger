package cn.edu.tongji.ranger.model;

import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/4/30.
 */
public class OrderListItem {
    private Orderform orderform;
    private String supplierName;
    private String productName;
    private double price;
    private int adultNum;
    private int childNum;
    private Timestamp setOffDate;

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int chileNum) {
        this.childNum = chileNum;
    }

    public Timestamp getSetOffDate() {
        return setOffDate;
    }

    public void setSetOffDate(Timestamp setOffDate) {
        this.setOffDate = setOffDate;
    }

    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAdultNum() {
        return adultNum;
    }

    public void setAdultNum(int adultNum) {
        this.adultNum = adultNum;
    }


}

