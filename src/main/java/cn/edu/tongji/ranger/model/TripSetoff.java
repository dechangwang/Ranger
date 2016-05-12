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
    public String toString() {
        return "TripSetoff{" +
                "id=" + id +
                ", tripSetoffDate=" + tripSetoffDate +
                ", updateTime=" + updateTime +
                ", purchaseCount=" + purchaseCount +
                ", commentCount=" + commentCount +
                ", avgRemark=" + avgRemark +
                ", product=" + product +
                ", guide=" + guide +
                '}';
    }
}
