package cn.edu.tongji.ranger.model;


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
    private Boolean hasChild;

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
    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }
}
