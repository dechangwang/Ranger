package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Entity
@Table(name = "trip_price", schema = "", catalog = "ranger")
public class TripPrice {
    private long id;
    private double price;
    private byte isExpired;
    private Timestamp updateTime;
    private Product productByProductId;
    private TouristType touristTypeByTouristTypeId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "is_expired", nullable = false, insertable = true, updatable = true)
    public byte getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(byte isExpired) {
        this.isExpired = isExpired;
    }

    @Basic
    @Column(name = "update_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripPrice tripPrice = (TripPrice) o;

        if (id != tripPrice.id) return false;
        if (isExpired != tripPrice.isExpired) return false;
        if (Double.compare(tripPrice.price, price) != 0) return false;
        if (updateTime != null ? !updateTime.equals(tripPrice.updateTime) : tripPrice.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) isExpired;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "tourist_type_id", referencedColumnName = "id", nullable = false)
    public TouristType getTouristTypeByTouristTypeId() {
        return touristTypeByTouristTypeId;
    }

    public void setTouristTypeByTouristTypeId(TouristType touristTypeByTouristTypeId) {
        this.touristTypeByTouristTypeId = touristTypeByTouristTypeId;
    }
}
