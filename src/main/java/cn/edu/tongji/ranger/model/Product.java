package cn.edu.tongji.ranger.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Entity
public class Product {
    private long id;
    private String name;
    private String summary;
    private String searchContent;
    private int duration;
    private long supplierId;
    private long setoffLocationId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "summary", nullable = false, insertable = true, updatable = true, length = 100)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "search_content", nullable = false, insertable = true, updatable = true, length = 300)
    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    @Basic
    @Column(name = "duration", nullable = false, insertable = true, updatable = true)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "supplier_id", nullable = false, insertable = true, updatable = true)
    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "setoff_location_id", nullable = false, insertable = true, updatable = true)
    public long getSetoffLocationId() {
        return setoffLocationId;
    }

    public void setSetoffLocationId(long setoffLocationId) {
        this.setoffLocationId = setoffLocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (duration != product.duration) return false;
        if (id != product.id) return false;
        if (setoffLocationId != product.setoffLocationId) return false;
        if (supplierId != product.supplierId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (searchContent != null ? !searchContent.equals(product.searchContent) : product.searchContent != null)
            return false;
        if (summary != null ? !summary.equals(product.summary) : product.summary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (searchContent != null ? searchContent.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (int) (supplierId ^ (supplierId >>> 32));
        result = 31 * result + (int) (setoffLocationId ^ (setoffLocationId >>> 32));
        return result;
    }
}
