package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripSetoff that = (TripSetoff) o;

        if (id != that.id) return false;
        if (tripSetoffDate != null ? !tripSetoffDate.equals(that.tripSetoffDate) : that.tripSetoffDate != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tripSetoffDate != null ? tripSetoffDate.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
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
}
