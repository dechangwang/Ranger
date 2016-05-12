package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
<<<<<<< HEAD
 * Created by LiaoShanhe on 2016/4/27.
=======
 * Created by wangdechang on 2016/5/7.
>>>>>>> dev_w
 */
@Entity
@Table(name = "trip_traffic", schema = "ranger", catalog = "")
public class TripTraffic {
    private long id;
    private String brief;
    private byte isExpired;
    private Timestamp updateTime;
    private TrafficType trafficType;
    private Product product;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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
    @JoinColumn(name = "traffic_type_id")
    public TrafficType getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(TrafficType trafficType) {
        this.trafficType = trafficType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripTraffic that = (TripTraffic) o;

        if (id != that.id) return false;
        if (isExpired != that.isExpired) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (int) isExpired;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "TripTraffic{" +
                "id=" + id +
                ", brief='" + brief + '\'' +
                ", isExpired=" + isExpired +
                ", updateTime=" + updateTime +
                '}';
    }

}
