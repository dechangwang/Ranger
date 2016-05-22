package cn.edu.tongji.ranger.model;

import cn.edu.tongji.ranger.model2show.SimpleProduct;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "collection")
public class Collection {
    private long id;
    private Timestamp collectTime;
    private SimpleProduct product;
    private Angency angency;

    @Id
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

    @ManyToOne
    @JoinColumn(name = "product_id")
    public SimpleProduct getProduct() {
        return product;
    }

    public void setProduct(SimpleProduct simpleProduct) {
        this.product = simpleProduct;
    }

    @ManyToOne
    @JoinColumn(name = "angency_id")
    public Angency getAngency() {
        return angency;
    }

    public void setAngency(Angency angency) {
        this.angency = angency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collection that = (Collection) o;

        if (id != that.id) return false;
        if (collectTime != null ? !collectTime.equals(that.collectTime) : that.collectTime != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return angency != null ? angency.equals(that.angency) : that.angency == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (collectTime != null ? collectTime.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (angency != null ? angency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", collectTime=" + collectTime +
                ", product=" + product +
                ", angency=" + angency +
                '}';
    }
}
