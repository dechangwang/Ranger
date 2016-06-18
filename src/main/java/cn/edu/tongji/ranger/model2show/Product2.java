package cn.edu.tongji.ranger.model2show;

import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Location;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="product")
public class Product2 implements Serializable{
    private long id;
    private String name;
    private String summary;
    private String searchContent;
    private int duration;
    private String postcode;
    private String postReceiver;
    private String postAddress;
    private String postPhone;
    //    private long setoffLocationId;
    private int clickRate;
    private Location setoffLocation;
    private Angency supplier;

    private Set<TripDestination2> tripDestinations;
    private List<TripDetail2> tripDetails;
    private Set<TripTraffic2> tripTraffics;
    private Set<TripPrice2> tripPrices;
    private Set<TripPicture2> tripPictures;
    private Set<TripAccomodation2> tripAccomodations;
    private Set<TripSetoff2> tripSetoffs;



    @Id
    @GeneratedValue
    @Column(name = "product_id")
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

    @Basic
    @Column(name = "click_rate")
    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "setoff_location_id")
    public Location getSetoffLocation() {
        return setoffLocation;
    }

    public void setSetoffLocation(Location setoffLocation) {
        this.setoffLocation = setoffLocation;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    public Angency getSupplier() {
        return supplier;
    }

    public void setSupplier(Angency supplier) {
        this.supplier = supplier;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripDestination2> getTripDestinations() {
        return tripDestinations;
    }

    public void setTripDestinations(Set<TripDestination2> tripDestinations) {
        this.tripDestinations = tripDestinations;
    }

    @Transient
    public List<TripDetail2> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(List<TripDetail2> tripDetails) {
        this.tripDetails = tripDetails;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripTraffic2> getTripTraffics() {
        return tripTraffics;
    }

    public void setTripTraffics(Set<TripTraffic2> tripTraffics) {
        this.tripTraffics = tripTraffics;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripPrice2> getTripPrices() {
        return tripPrices;
    }

    public void setTripPrices(Set<TripPrice2> tripPrices) {
        this.tripPrices = tripPrices;
    }


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripPicture2> getTripPictures() {
        return tripPictures;
    }

    public void setTripPictures(Set<TripPicture2> tripPictures) {
        this.tripPictures = tripPictures;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripAccomodation2> getTripAccomodations() {
        return tripAccomodations;
    }

    public void setTripAccomodations(Set<TripAccomodation2> tripAccomodations) {
        this.tripAccomodations = tripAccomodations;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<TripSetoff2> getTripSetoffs() {
        return tripSetoffs;
    }

    public void setTripSetoffs(Set<TripSetoff2> tripSetoffs) {
        this.tripSetoffs = tripSetoffs;
    }

    public void growClickRate(){
        this.clickRate++;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "supplier=" + supplier +
                ", setoffLocation=" + setoffLocation +
                ", clickRate=" + clickRate +
                ", postPhone='" + postPhone + '\'' +
                ", postAddress='" + postAddress + '\'' +
                ", postReceiver='" + postReceiver + '\'' +
                ", postcode='" + postcode + '\'' +
                ", duration=" + duration +
                ", searchContent='" + searchContent + '\'' +
                ", summary='" + summary + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
