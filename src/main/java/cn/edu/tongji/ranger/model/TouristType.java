package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Entity
@Table(name = "tourist_type", schema = "", catalog = "ranger")
public class TouristType {
    private long id;
    private String type;
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
    @Column(name = "type", nullable = false, insertable = true, updatable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        TouristType that = (TouristType) o;

        if (id != that.id) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }
}
