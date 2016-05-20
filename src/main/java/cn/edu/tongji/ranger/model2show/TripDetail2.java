package cn.edu.tongji.ranger.model2show;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "trip_detail", schema = "ranger", catalog = "")
public class TripDetail2 {
    private long id;
    private String type;
    private String content;
    private Timestamp updateTime;
    private long productId;
//    private Product product;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        TripDetail2 that = (TripDetail2) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TripDetail2{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", updateTime=" + updateTime +
                ", productId=" + productId +
                '}';
    }
}
