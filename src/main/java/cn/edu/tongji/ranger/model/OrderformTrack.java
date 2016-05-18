package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/5/10.
 */
@Entity
@Table(name = "orderform_track", schema = "", catalog = "ranger")
public class OrderformTrack {
    private long id;
    private long orderformId;
    private String trackItem;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderform_id", nullable = false, insertable = true, updatable = true)
    public long getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(long orderformId) {
        this.orderformId = orderformId;
    }

    @Basic
    @Column(name = "track_item", nullable = false, insertable = true, updatable = true, length = 100)
    public String getTrackItem() {
        return trackItem;
    }

    public void setTrackItem(String trackItem) {
        this.trackItem = trackItem;
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

        OrderformTrack that = (OrderformTrack) o;

        if (id != that.id) return false;
        if (orderformId != that.orderformId) return false;
        if (trackItem != null ? !trackItem.equals(that.trackItem) : that.trackItem != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderformId ^ (orderformId >>> 32));
        result = 31 * result + (trackItem != null ? trackItem.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
