package cn.edu.tongji.ranger.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
public class Orderform {
    private long id;
    private String booker;
    private String bookerPhone;
    private String bookerAddress;
    private Timestamp bookTime;
    private Timestamp confirmTime;
    private int state;
    private double cost;
    private double deposit;
    private String confirmListBuyer;
    private String confirmListSupplier;
    private String contractSupplier;
    private String contractBuyer;
    private String invoice;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "booker")
    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    @Basic
    @Column(name = "booker_phone")
    public String getBookerPhone() {
        return bookerPhone;
    }

    public void setBookerPhone(String bookerPhone) {
        this.bookerPhone = bookerPhone;
    }

    @Basic
    @Column(name = "booker_address")
    public String getBookerAddress() {
        return bookerAddress;
    }

    public void setBookerAddress(String bookerAddress) {
        this.bookerAddress = bookerAddress;
    }

    @Basic
    @Column(name = "book_time")
    public Timestamp getBookTime() {
        return bookTime;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }

    @Basic
    @Column(name = "confirm_time")
    public Timestamp getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Timestamp confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "deposit")
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "confirm_list_buyer")
    public String getConfirmListBuyer() {
        return confirmListBuyer;
    }

    public void setConfirmListBuyer(String confirmListBuyer) {
        this.confirmListBuyer = confirmListBuyer;
    }

    @Basic
    @Column(name = "confirm_list_supplier")
    public String getConfirmListSupplier() {
        return confirmListSupplier;
    }

    public void setConfirmListSupplier(String confirmListSupplier) {
        this.confirmListSupplier = confirmListSupplier;
    }

    @Basic
    @Column(name = "contract_supplier")
    public String getContractSupplier() {
        return contractSupplier;
    }

    public void setContractSupplier(String contractSupplier) {
        this.contractSupplier = contractSupplier;
    }

    @Basic
    @Column(name = "contract_buyer")
    public String getContractBuyer() {
        return contractBuyer;
    }

    public void setContractBuyer(String contractBuyer) {
        this.contractBuyer = contractBuyer;
    }

    @Basic
    @Column(name = "invoice")
    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderform orderform = (Orderform) o;

        if (id != orderform.id) return false;
        if (state != orderform.state) return false;
        if (Double.compare(orderform.cost, cost) != 0) return false;
        if (Double.compare(orderform.deposit, deposit) != 0) return false;
        if (booker != null ? !booker.equals(orderform.booker) : orderform.booker != null) return false;
        if (bookerPhone != null ? !bookerPhone.equals(orderform.bookerPhone) : orderform.bookerPhone != null)
            return false;
        if (bookerAddress != null ? !bookerAddress.equals(orderform.bookerAddress) : orderform.bookerAddress != null)
            return false;
        if (bookTime != null ? !bookTime.equals(orderform.bookTime) : orderform.bookTime != null) return false;
        if (confirmTime != null ? !confirmTime.equals(orderform.confirmTime) : orderform.confirmTime != null)
            return false;
        if (confirmListBuyer != null ? !confirmListBuyer.equals(orderform.confirmListBuyer) : orderform.confirmListBuyer != null)
            return false;
        if (confirmListSupplier != null ? !confirmListSupplier.equals(orderform.confirmListSupplier) : orderform.confirmListSupplier != null)
            return false;
        if (contractSupplier != null ? !contractSupplier.equals(orderform.contractSupplier) : orderform.contractSupplier != null)
            return false;
        if (contractBuyer != null ? !contractBuyer.equals(orderform.contractBuyer) : orderform.contractBuyer != null)
            return false;
        if (invoice != null ? !invoice.equals(orderform.invoice) : orderform.invoice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
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
        result = 31 * result + (contractSupplier != null ? contractSupplier.hashCode() : 0);
        result = 31 * result + (contractBuyer != null ? contractBuyer.hashCode() : 0);
        result = 31 * result + (invoice != null ? invoice.hashCode() : 0);
        return result;
    }
}
