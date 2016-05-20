package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "orderform_track", schema = "ranger", catalog = "")
public class OrderformTrack {
    private long id;
    private String trackItem;
    private Timestamp updateTime;
    private long orderformId;
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name="orderform_id")
    public long getOrderformId(){return orderformId;}
    public void setOrderformId(long orderformId){this.orderformId=orderformId;}
    @Basic
    @Column(name = "track_item")
    public String getTrackItem() {
        return trackItem;
    }

    public void setTrackItem(String trackItem) {
        this.trackItem = trackItem;
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

        OrderformTrack that = (OrderformTrack) o;

        if (id != that.id) return false;
        if (trackItem != null ? !trackItem.equals(that.trackItem) : that.trackItem != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (trackItem != null ? trackItem.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
