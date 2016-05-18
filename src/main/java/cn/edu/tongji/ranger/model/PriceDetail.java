package cn.edu.tongji.ranger.model;

/**
 * Created by 马二爷 on 2016/5/10.
 */
public class PriceDetail {
    double total;
    private int adultnum;
    private int childnum;
    double adultPrice;
    double childPrice;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAdultnum() {
        return adultnum;
    }

    public void setAdultnum(int adultnum) {
        this.adultnum = adultnum;
    }

    public int getChildnum() {
        return childnum;
    }

    public void setChildnum(int childnum) {
        this.childnum = childnum;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }
}
