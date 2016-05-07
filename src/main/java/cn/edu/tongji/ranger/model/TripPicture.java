package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Entity
@Table(name = "trip_picture", schema = "ranger", catalog = "")
public class TripPicture {
    private long id;
    private String picturePath;
    private String brief;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripPicture that = (TripPicture) o;

        if (id != that.id) return false;
        if (picturePath != null ? !picturePath.equals(that.picturePath) : that.picturePath != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (picturePath != null ? picturePath.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }
}
