package cn.edu.tongji.ranger.model2show;

import cn.edu.tongji.ranger.model.*;
import org.hibernate.annotations.*;

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

    private Set<TripDestination2> tripDestinations;
    private Set<TripPrice2> tripPrices;

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
    public Set<TripDestination2> getTripDestinations() {
        return tripDestinations;
    }

    public void setTripDestinations(Set<TripDestination2> tripDestinations) {
        this.tripDestinations = tripDestinations;
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
    public Set<TripSetoff2> getTripSetoffs() {
        return tripSetoffs;
    }

    public void setTripSetoffs(Set<TripSetoff2> tripSetoffs) {
        this.tripSetoffs = tripSetoffs;
    }
}
