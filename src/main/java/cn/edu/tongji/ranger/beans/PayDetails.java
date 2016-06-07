package cn.edu.tongji.ranger.beans;

/**
 * Created by LiaoShanhe on 2016/6/6.
 */
public class PayDetails {
    private Long orderId;
    private Double amount;
    private Long buyerId;
    private String payPass;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPayPass() {
        return payPass;
    }

    public void setPayPass(String payPass) {
        this.payPass = payPass;
    }

    @Override
    public String toString() {
        return "PayDetails{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", buyerId=" + buyerId +
                ", payPass='" + payPass + '\'' +
                '}';
    }
}
