package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**

 */
@Entity
@Table(name = "trip_accomodation", schema = "ranger", catalog = "")
public class TripAccomodation {
    private long id;
    private String accomodationType;
    private String brief;
    private byte isExpired;
    private Timestamp updateTime;
    private Product product;

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

        TripAccomodation that = (TripAccomodation) o;

        if (id != that.id) return false;
        if (isExpired != that.isExpired) return false;
        if (accomodationType != null ? !accomodationType.equals(that.accomodationType) : that.accomodationType != null)
            return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accomodationType != null ? accomodationType.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (int) isExpired;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripAccomodation{" +
                "id=" + id +
                ", accomodationType='" + accomodationType + '\'' +
                ", brief='" + brief + '\'' +
                ", isExpired=" + isExpired +
                ", updateTime=" + updateTime +
                '}';
    }


}
