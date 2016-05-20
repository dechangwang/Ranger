package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "tourist_type", schema = "ranger", catalog = "")
public class TouristType {
    private long id;
    private String type;
    private String brief;

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

        TouristType that = (TouristType) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return brief != null ? brief.equals(that.brief) : that.brief == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TouristType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}
