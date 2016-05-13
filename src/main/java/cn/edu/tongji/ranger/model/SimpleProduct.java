package cn.edu.tongji.ranger.model;

/**
 * Created by daidongyang on 5/14/16.
 */
public class SimpleProduct {
    private long product_id;
    private String name;
//    private String summary;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
