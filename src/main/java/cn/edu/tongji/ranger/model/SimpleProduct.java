package cn.edu.tongji.ranger.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by daidongyang on 5/14/16.
 */

@Entity
@Table(name="product")
public class SimpleProduct {
    private long id;
    private String name;
    private String summary;
    private String searchContent;
    private int duration;
    private int clickRate;
    private Location setoffLocation;
    private Angency supplier;

    private Set<SimpleTripDestination> tripDestinations;
    private Set<SimpleTripPrice> tripPrices;

    private Set<SimpleTripSetoff> tripSetoffs;


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
    @Column(name = "click_rate")
    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "setoff_location_id")
    public Location getSetoffLocation() {
        return setoffLocation;
    }

    public void setSetoffLocation(Location setoffLocation) {
        this.setoffLocation = setoffLocation;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    public Angency getSupplier() {
        return supplier;
    }

    public void setSupplier(Angency supplier) {
        this.supplier = supplier;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<SimpleTripDestination> getTripDestinations() {
        return tripDestinations;
    }

    public void setTripDestinations(Set<SimpleTripDestination> tripDestinations) {
        this.tripDestinations = tripDestinations;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<SimpleTripPrice> getTripPrices() {
        return tripPrices;
    }

    public void setTripPrices(Set<SimpleTripPrice> tripPrices) {
        this.tripPrices = tripPrices;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<SimpleTripSetoff> getTripSetoffs() {
        return tripSetoffs;
    }

    public void setTripSetoffs(Set<SimpleTripSetoff> tripSetoffs) {
        this.tripSetoffs = tripSetoffs;
    }
}
