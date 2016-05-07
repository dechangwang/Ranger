package cn.edu.tongji.ranger.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Entity
public class Location {
    private long id;
    private String name;
    private long fatherId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "father_id")
    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (fatherId != location.fatherId) return false;
        if (name != null ? !name.equals(location.name) : location.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (fatherId ^ (fatherId >>> 32));
        return result;
    }
}
