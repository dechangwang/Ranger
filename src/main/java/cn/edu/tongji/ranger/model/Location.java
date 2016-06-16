package cn.edu.tongji.ranger.model;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name="location")
public class Location {
    private long id;
    private String name;
    private long fatherId;
    private String eName;
    private boolean hasChild;

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


    @Basic
    @Column(name = "e_name")
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "has_child")
    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (fatherId != location.fatherId) return false;
        if (hasChild != location.hasChild) return false;
        if (name != null ? !name.equals(location.name) : location.name != null) return false;
        return eName != null ? eName.equals(location.eName) : location.eName == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (fatherId ^ (fatherId >>> 32));
        result = 31 * result + (eName != null ? eName.hashCode() : 0);
        result = 31 * result + (hasChild ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherId=" + fatherId +
                ", eName='" + eName + '\'' +
                ", hasChild=" + hasChild +
                '}';
    }
}
