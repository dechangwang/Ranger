package cn.edu.tongji.ranger.model2show;

import cn.edu.tongji.ranger.model.Product3;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by Dai on 6/19/16.
 */
@Entity
@Table(name = "collection")
public class Collection2 implements Serializable {
    private long id;
    private Timestamp collectTime;
    private Product3 product;
    private long angencyId;

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
    @Column(name = "collect_time")
    public Timestamp getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Timestamp collectTime) {
        this.collectTime = collectTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "product_id")
    public Product3 getProduct() {
        return product;
    }

    public void setProduct(Product3 product) {
        this.product = product;
    }

    @Basic
    @Column(name = "angency_id")
    public long getAngencyId() {
        return angencyId;
    }

    public void setAngencyId(long angencyId) {
        this.angencyId = angencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collection2 that = (Collection2) o;

        if (id != that.id) return false;
        if (angencyId != that.angencyId) return false;
        if (collectTime != null ? !collectTime.equals(that.collectTime) : that.collectTime != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (collectTime != null ? collectTime.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (int) (angencyId ^ (angencyId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", collectTime=" + collectTime +
                ", product=" + product +
                ", angencyId=" + angencyId +
                '}';
    }
}