package cn.edu.tongji.ranger.model2show;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "trip_accomodation", schema = "ranger", catalog = "")
public class TripAccomodation2 {
    private long id;
    private String accomodationType;
    private String brief;
    private byte isExpired;
    private Timestamp updateTime;
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
    @Column(name = "accomodation_type")
    public String getAccomodationType() {
        return accomodationType;
    }

    public void setAccomodationType(String accomodationType) {
        this.accomodationType = accomodationType;
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

    @Basic
    @Column(name = "product_id")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripAccomodation2 that = (TripAccomodation2) o;

        if (id != that.id) return false;
        if (isExpired != that.isExpired) return false;
        if (productId != that.productId) return false;
        if (accomodationType != null ? !accomodationType.equals(that.accomodationType) : that.accomodationType != null)
            return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accomodationType != null ? accomodationType.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (int) isExpired;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TripAccomodation2{" +
                "id=" + id +
                ", accomodationType='" + accomodationType + '\'' +
                ", brief='" + brief + '\'' +
                ", isExpired=" + isExpired +
                ", updateTime=" + updateTime +
                ", productId=" + productId +
                '}';
    }
}
