package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by 马二爷 on 2016/5/10.
 */
@Entity
@Table(name = "orderform_tourist_picture", schema = "", catalog = "ranger")
public class OrderformTouristPicture {
    private long id;
    private long orderformTouristId;
    private String picturePath;
    private String brief;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderform_tourist_id", nullable = false, insertable = true, updatable = true)
    public long getOrderformTouristId() {
        return orderformTouristId;
    }

    public void setOrderformTouristId(long orderformTouristId) {
        this.orderformTouristId = orderformTouristId;
    }

    @Basic
    @Column(name = "picture_path", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Basic
    @Column(name = "brief", nullable = false, insertable = true, updatable = true, length = 100)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderformTouristPicture that = (OrderformTouristPicture) o;

        if (id != that.id) return false;
        if (orderformTouristId != that.orderformTouristId) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (picturePath != null ? !picturePath.equals(that.picturePath) : that.picturePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderformTouristId ^ (orderformTouristId >>> 32));
        result = 31 * result + (picturePath != null ? picturePath.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }
}
