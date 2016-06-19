package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**

 */
@Entity
@Table(name = "trip_setoff", schema = "ranger", catalog = "")
public class TripSetoff {
    private long id;
    private Timestamp tripSetoffDate;
    private Timestamp updateTime;

    private int purchaseCount;
    private int commentCount;
    private int avgRemark;

    private Product product;
    private Guide guide;

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
    @Column(name = "trip_setoff_date")
    public Timestamp getTripSetoffDate() {
        return tripSetoffDate;
    }

    public void setTripSetoffDate(Timestamp tripSetoffDate) {
        this.tripSetoffDate = tripSetoffDate;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    @Basic
    @Column(name = "purchase_count")
    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    @Basic
    @Column(name = "comment_count")
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Basic
    @Column(name = "avg_remark")
    public int getAvgRemark() {
        return avgRemark;
    }

    public void setAvgRemark(int avgRemark) {
        this.avgRemark = avgRemark;

    }


    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "guide_id")
    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripSetoff that = (TripSetoff) o;

        if (id != that.id) return false;
        if (purchaseCount != that.purchaseCount) return false;
        if (commentCount != that.commentCount) return false;
        if (avgRemark != that.avgRemark) return false;
        if (tripSetoffDate != null ? !tripSetoffDate.equals(that.tripSetoffDate) : that.tripSetoffDate != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return guide != null ? guide.equals(that.guide) : that.guide == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tripSetoffDate != null ? tripSetoffDate.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + purchaseCount;
        result = 31 * result + commentCount;
        result = 31 * result + avgRemark;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (guide != null ? guide.hashCode() : 0);
        return result;
    }
}
