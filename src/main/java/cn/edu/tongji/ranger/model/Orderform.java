package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/5/18.
 */
@Entity
@Table(name="orderform")
public class Orderform {
    private long id;

    @Id
    @GeneratedValue
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long buyerId;

    @Basic
    @javax.persistence.Column(name = "buyer_id", nullable = false, insertable = true, updatable = true)
    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    private long tripSetoffId;

    @Basic
    @javax.persistence.Column(name = "trip_setoff_id", nullable = false, insertable = true, updatable = true)
    public long getTripSetoffId() {
        return tripSetoffId;
    }

    public void setTripSetoffId(long tripSetoffId) {
        this.tripSetoffId = tripSetoffId;
    }

    private String booker;

    @Basic
    @javax.persistence.Column(name = "booker", nullable = false, insertable = true, updatable = true, length = 45)
    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    private String bookerPhone;

    @Basic
    @javax.persistence.Column(name = "booker_phone", nullable = false, insertable = true, updatable = true, length = 45)
    public String getBookerPhone() {
        return bookerPhone;
    }

    public void setBookerPhone(String bookerPhone) {
        this.bookerPhone = bookerPhone;
    }

    private String bookerAddress;

    @Basic
    @javax.persistence.Column(name = "booker_address", nullable = false, insertable = true, updatable = true, length = 45)
    public String getBookerAddress() {
        return bookerAddress;
    }

    public void setBookerAddress(String bookerAddress) {
        this.bookerAddress = bookerAddress;
    }

    private Timestamp bookTime;

    @Basic
    @javax.persistence.Column(name = "book_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getBookTime() {
        return bookTime;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }

    private Timestamp confirmTime;

    @Basic
    @javax.persistence.Column(name = "confirm_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Timestamp confirmTime) {
        this.confirmTime = confirmTime;
    }

    private int state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = false, insertable = true, updatable = true)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private double cost;

    @Basic
    @javax.persistence.Column(name = "cost", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private double deposit;

    @Basic
    @javax.persistence.Column(name = "deposit", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    private String confirmListBuyer;

    @Basic
    @javax.persistence.Column(name = "confirm_list_buyer", nullable = false, insertable = true, updatable = true, length = 100)
    public String getConfirmListBuyer() {
        return confirmListBuyer;
    }

    public void setConfirmListBuyer(String confirmListBuyer) {
        this.confirmListBuyer = confirmListBuyer;
    }

    private String confirmListSupplier;

    @Basic
    @javax.persistence.Column(name = "confirm_list_supplier", nullable = false, insertable = true, updatable = true, length = 100)
    public String getConfirmListSupplier() {
        return confirmListSupplier;
    }

    public void setConfirmListSupplier(String confirmListSupplier) {
        this.confirmListSupplier = confirmListSupplier;
    }

    private String tripNotice;

    @Basic
    @javax.persistence.Column(name = "trip_notice", nullable = false, insertable = true, updatable = true, length = 100)
    public String getTripNotice() {
        return tripNotice;
    }

    public void setTripNotice(String tripNotice) {
        this.tripNotice = tripNotice;
    }

    private String contractSupplier;

    @Basic
    @javax.persistence.Column(name = "contract_supplier", nullable = false, insertable = true, updatable = true, length = 100)
    public String getContractSupplier() {
        return contractSupplier;
    }

    public void setContractSupplier(String contractSupplier) {
        this.contractSupplier = contractSupplier;
    }

    private String contractBuyer;

    @Basic
    @javax.persistence.Column(name = "contract_buyer", nullable = false, insertable = true, updatable = true, length = 100)
    public String getContractBuyer() {
        return contractBuyer;
    }

    public void setContractBuyer(String contractBuyer) {
        this.contractBuyer = contractBuyer;
    }

    private String invoice;

    @Basic
    @javax.persistence.Column(name = "invoice", nullable = false, insertable = true, updatable = true, length = 100)
    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    private String comment;

    @Basic
    @javax.persistence.Column(name = "comment", nullable = false, insertable = true, updatable = true, length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private int remark;

    @Basic
    @javax.persistence.Column(name = "remark", nullable = false, insertable = true, updatable = true)
    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderform orderform = (Orderform) o;

        if (buyerId != orderform.buyerId) return false;
        if (Double.compare(orderform.cost, cost) != 0) return false;
        if (Double.compare(orderform.deposit, deposit) != 0) return false;
        if (id != orderform.id) return false;
        if (remark != orderform.remark) return false;
        if (state != orderform.state) return false;
        if (tripSetoffId != orderform.tripSetoffId) return false;
        if (bookTime != null ? !bookTime.equals(orderform.bookTime) : orderform.bookTime != null) return false;
        if (booker != null ? !booker.equals(orderform.booker) : orderform.booker != null) return false;
        if (bookerAddress != null ? !bookerAddress.equals(orderform.bookerAddress) : orderform.bookerAddress != null)
            return false;
        if (bookerPhone != null ? !bookerPhone.equals(orderform.bookerPhone) : orderform.bookerPhone != null)
            return false;
        if (comment != null ? !comment.equals(orderform.comment) : orderform.comment != null) return false;
        if (confirmListBuyer != null ? !confirmListBuyer.equals(orderform.confirmListBuyer) : orderform.confirmListBuyer != null)
            return false;
        if (confirmListSupplier != null ? !confirmListSupplier.equals(orderform.confirmListSupplier) : orderform.confirmListSupplier != null)
            return false;
        if (confirmTime != null ? !confirmTime.equals(orderform.confirmTime) : orderform.confirmTime != null)
            return false;
        if (contractBuyer != null ? !contractBuyer.equals(orderform.contractBuyer) : orderform.contractBuyer != null)
            return false;
        if (contractSupplier != null ? !contractSupplier.equals(orderform.contractSupplier) : orderform.contractSupplier != null)
            return false;
        if (invoice != null ? !invoice.equals(orderform.invoice) : orderform.invoice != null) return false;
        if (tripNotice != null ? !tripNotice.equals(orderform.tripNotice) : orderform.tripNotice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (buyerId ^ (buyerId >>> 32));
        result = 31 * result + (int) (tripSetoffId ^ (tripSetoffId >>> 32));
        result = 31 * result + (booker != null ? booker.hashCode() : 0);
        result = 31 * result + (bookerPhone != null ? bookerPhone.hashCode() : 0);
        result = 31 * result + (bookerAddress != null ? bookerAddress.hashCode() : 0);
        result = 31 * result + (bookTime != null ? bookTime.hashCode() : 0);
        result = 31 * result + (confirmTime != null ? confirmTime.hashCode() : 0);
        result = 31 * result + state;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(deposit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (confirmListBuyer != null ? confirmListBuyer.hashCode() : 0);
        result = 31 * result + (confirmListSupplier != null ? confirmListSupplier.hashCode() : 0);
        result = 31 * result + (tripNotice != null ? tripNotice.hashCode() : 0);
        result = 31 * result + (contractSupplier != null ? contractSupplier.hashCode() : 0);
        result = 31 * result + (contractBuyer != null ? contractBuyer.hashCode() : 0);
        result = 31 * result + (invoice != null ? invoice.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + remark;
        return result;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", tripSetoffId=" + tripSetoffId +
                ", booker='" + booker + '\'' +
                ", bookerPhone='" + bookerPhone + '\'' +
                ", bookerAddress='" + bookerAddress + '\'' +
                ", bookTime=" + bookTime +
                ", confirmTime=" + confirmTime +
                ", state=" + state +
                ", cost=" + cost +
                ", deposit=" + deposit +
                ", confirmListBuyer='" + confirmListBuyer + '\'' +
                ", confirmListSupplier='" + confirmListSupplier + '\'' +
                ", tripNotice='" + tripNotice + '\'' +
                ", contractSupplier='" + contractSupplier + '\'' +
                ", contractBuyer='" + contractBuyer + '\'' +
                ", invoice='" + invoice + '\'' +
                ", comment='" + comment + '\'' +
                ", remark=" + remark +
                '}';
    }
}
