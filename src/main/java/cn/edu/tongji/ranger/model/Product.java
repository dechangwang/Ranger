package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name="product")
public class Product {
    private long id;
    private String name;
    private String summary;
    private String searchContent;
    private int duration;

    private String postcode;
    private String postReceiver;
    private String postAddress;
    private String postPhone;
    private long setoffLocationId;
    private int clickRate;


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
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "search_content")
    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Basic
    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "post_receiver")
    public String getPostReceiver() {
        return postReceiver;
    }

    public void setPostReceiver(String postReceiver) {
        this.postReceiver = postReceiver;
    }

    @Basic
    @Column(name = "post_address")
    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    @Basic
    @Column(name = "post_phone")
    public String getPostPhone() {
        return postPhone;
    }

    public void setPostPhone(String postPhone) {
        this.postPhone = postPhone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (duration != product.duration) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (summary != null ? !summary.equals(product.summary) : product.summary != null) return false;
        if (searchContent != null ? !searchContent.equals(product.searchContent) : product.searchContent != null)
            return false;

        if (postcode != null ? !postcode.equals(product.postcode) : product.postcode != null) return false;
        if (postReceiver != null ? !postReceiver.equals(product.postReceiver) : product.postReceiver != null)
            return false;
        if (postAddress != null ? !postAddress.equals(product.postAddress) : product.postAddress != null) return false;
        if (postPhone != null ? !postPhone.equals(product.postPhone) : product.postPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (searchContent != null ? searchContent.hashCode() : 0);
        result = 31 * result + duration;

        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (postReceiver != null ? postReceiver.hashCode() : 0);
        result = 31 * result + (postAddress != null ? postAddress.hashCode() : 0);
        result = 31 * result + (postPhone != null ? postPhone.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "setoff_location_id")
    public long getSetoffLocationId() {
        return setoffLocationId;
    }

    public void setSetoffLocationId(long setoffLocationId) {
        this.setoffLocationId = setoffLocationId;
    }

    @Basic
    @Column(name = "clickRate")
    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }

}
