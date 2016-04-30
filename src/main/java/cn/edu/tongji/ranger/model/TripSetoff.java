package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Entity
@Table(name = "trip_setoff", schema = "", catalog = "ranger")
public class TripSetoff {
    private long id;
    private long productId;
    private long guideId;
    private Timestamp tripSetoffDate;
    private Timestamp updateTime;
    private Product productByProductId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id", nullable = false, insertable = true, updatable = true)
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "guide_id", nullable = false, insertable = true, updatable = true)
    public long getGuideId() {
        return guideId;
    }

    public void setGuideId(long guideId) {
        this.guideId = guideId;
    }

    @Basic
    @Column(name = "trip_setoff_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getTripSetoffDate() {
        return tripSetoffDate;
    }

    public void setTripSetoffDate(Timestamp tripSetoffDate) {
        this.tripSetoffDate = tripSetoffDate;
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

        TripSetoff that = (TripSetoff) o;

        if (guideId != that.guideId) return false;
        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (tripSetoffDate != null ? !tripSetoffDate.equals(that.tripSetoffDate) : that.tripSetoffDate != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + (int) (guideId ^ (guideId >>> 32));
        result = 31 * result + (tripSetoffDate != null ? tripSetoffDate.hashCode() : 0);
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
}
