package cn.edu.tongji.ranger.model2show;

import javax.persistence.*;

/**

 */
@Entity
@Table(name = "trip_picture", schema = "ranger", catalog = "")
public class TripPicture2 {
    private long id;
    private String picturePath;
    private String brief;
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
    @Column(name = "picture_path")
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
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

        TripPicture2 that = (TripPicture2) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (picturePath != null ? !picturePath.equals(that.picturePath) : that.picturePath != null) return false;
        return brief != null ? brief.equals(that.brief) : that.brief == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (picturePath != null ? picturePath.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TripPicture2{" +
                "id=" + id +
                ", picturePath='" + picturePath + '\'' +
                ", brief='" + brief + '\'' +
                ", productId=" + productId +
                '}';
    }
}
