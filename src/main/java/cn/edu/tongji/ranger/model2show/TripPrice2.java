package cn.edu.tongji.ranger.model2show;

import cn.edu.tongji.ranger.model.TouristType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by daidongyang on 5/16/16.
 */

@Entity
@Table(name = "trip_price")
public class TripPrice2 {
    private long id;
    private double price;
    private byte isExpired;
    private Timestamp updateTime;
//    private Product product;
    private TouristType touristType;
    private long productId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name="product_id")
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "is_expired")
    public byte getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(byte isExpired) {
        this.isExpired = isExpired;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tourist_type_id")
    public TouristType getTouristType() {
        return touristType;
    }

    public void setTouristType(TouristType touristType) {
        this.touristType = touristType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripPrice2 that = (TripPrice2) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (isExpired != that.isExpired) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        return touristType != null ? touristType.equals(that.touristType) : that.touristType == null;

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
        result = 31 * result + (touristType != null ? touristType.hashCode() : 0);
        return result;
    }
}
