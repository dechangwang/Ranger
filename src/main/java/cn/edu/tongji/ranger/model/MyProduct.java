package cn.edu.tongji.ranger.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdechang on 2016/5/10.
 */
public class MyProduct {
    private String product_id;
    private String product_name;
    private List<String> setoff_time = new ArrayList<String>();
    private String release_time;
    private String price;
    private String state;

    public MyProduct() {
    }

    public MyProduct(String product_id, String product_name, List<String> setoff_time,
                     String release_time, String price, String state) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.setoff_time = setoff_time;
        this.release_time = release_time;
        this.price = price;
        this.state = state;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public List<String> getSetoff_time() {
        return setoff_time;
    }

    public void setSetoff_time(List<String> setoff_time) {
        this.setoff_time = setoff_time;
    }

    public void addSetOffTime(String setofftime){
        this.setoff_time.add(setofftime);
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MyProduct{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", setoff_time='" + setoff_time + '\'' +
                ", release_time='" + release_time + '\'' +
                ", price='" + price + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
