package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.sql.Timestamp;

/**

 */
@Entity
@Table(name = "trip_price", schema = "ranger", catalog = "")
public class TripPrice {
    private long id;
    private double price;
    private byte isExpired;
    private Timestamp updateTime;
    private Product product;
    private TouristType touristType;

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
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

        TripPrice tripPrice = (TripPrice) o;

        if (id != tripPrice.id) return false;
        if (Double.compare(tripPrice.price, price) != 0) return false;
        if (isExpired != tripPrice.isExpired) return false;
        if (updateTime != null ? !updateTime.equals(tripPrice.updateTime) : tripPrice.updateTime != null) return false;
        if (product != null ? !product.equals(tripPrice.product) : tripPrice.product != null) return false;
        return touristType != null ? touristType.equals(tripPrice.touristType) : tripPrice.touristType == null;

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
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (touristType != null ? touristType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripPrice{" +
                "id=" + id +
                ", price=" + price +
                ", isExpired=" + isExpired +
                ", updateTime=" + updateTime +
                '}';
    }

}
