package cn.edu.tongji.ranger.model;

/**
 * Created by wangdechang on 2016/5/12.
 */
public class Invoice {
    private String invoice_id;
    private String invoice_info;
    private String apply_time;
    private String price;

    public Invoice(String invoice_id, String invoice_info, String apply_time, String price) {
        this.invoice_id = invoice_id;
        this.invoice_info = invoice_info;
        this.apply_time = apply_time;
        this.price = price;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getInvoice_info() {
        return invoice_info;
    }

    public void setInvoice_info(String invoice_info) {
        this.invoice_info = invoice_info;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
