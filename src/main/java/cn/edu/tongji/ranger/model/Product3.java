package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by 马二爷 on 2016/5/19.
 */
@Entity
@Table(name = "product", schema = "", catalog = "ranger")
public class Product3 {
    private long id;
    private String name;
    private String summary;
    private String searchContent;
    private int duration;
    private long supplierId;
    private long setoffLocationId;
    private String postcode;
    private String postReceiver;
    private String postAddress;
    private String postPhone;
   // private int clickRate;

    @Id
    @Column(name = "product_id", nullable = false, insertable = true, updatable = true)
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

    @Basic
    @Column(name = "postcode", nullable = false, insertable = true, updatable = true, length = 10)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "post_receiver", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPostReceiver() {
        return postReceiver;
    }

    public void setPostReceiver(String postReceiver) {
        this.postReceiver = postReceiver;
    }

    @Basic
    @Column(name = "post_address", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    @Basic
    @Column(name = "post_phone", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPostPhone() {
        return postPhone;
    }

    public void setPostPhone(String postPhone) {
        this.postPhone = postPhone;
    }

  /*  @Basic
    @Column(name = "clickRate", nullable = false, insertable = true, updatable = true)
    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product3 product3 = (Product3) o;

       // if (clickRate != product3.clickRate) return false;
        if (duration != product3.duration) return false;
        if (id != product3.id) return false;
        if (setoffLocationId != product3.setoffLocationId) return false;
        if (supplierId != product3.supplierId) return false;
        if (name != null ? !name.equals(product3.name) : product3.name != null) return false;
        if (postAddress != null ? !postAddress.equals(product3.postAddress) : product3.postAddress != null)
            return false;
        if (postPhone != null ? !postPhone.equals(product3.postPhone) : product3.postPhone != null) return false;
        if (postReceiver != null ? !postReceiver.equals(product3.postReceiver) : product3.postReceiver != null)
            return false;
        if (postcode != null ? !postcode.equals(product3.postcode) : product3.postcode != null) return false;
        if (searchContent != null ? !searchContent.equals(product3.searchContent) : product3.searchContent != null)
            return false;
        if (summary != null ? !summary.equals(product3.summary) : product3.summary != null) return false;

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
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (postReceiver != null ? postReceiver.hashCode() : 0);
        result = 31 * result + (postAddress != null ? postAddress.hashCode() : 0);
        result = 31 * result + (postPhone != null ? postPhone.hashCode() : 0);
        //result = 31 * result + clickRate;
        return result;
    }
}
