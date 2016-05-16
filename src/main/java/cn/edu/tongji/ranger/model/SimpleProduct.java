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

    private Set<TripDestination> tripDestinations;
    private Set<TripTraffic> tripTraffics;
    private Set<TripPrice> tripPrices;
    private Set<TripPicture> tripPictures;
    private Set<TripAccomodation> tripAccomodations;
    private Set<TripSetoff> tripSetoffs;


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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<TripDestination> getTripDestinations() {
        return tripDestinations;
    }

    public void setTripDestinations(Set<TripDestination> tripDestinations) {
        this.tripDestinations = tripDestinations;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<TripTraffic> getTripTraffics() {
        return tripTraffics;
    }

    public void setTripTraffics(Set<TripTraffic> tripTraffics) {
        this.tripTraffics = tripTraffics;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<TripPrice> getTripPrices() {
        return tripPrices;
    }

    public void setTripPrices(Set<TripPrice> tripPrices) {
        this.tripPrices = tripPrices;
    }


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
    public Set<TripPicture> getTripPictures() {
        return tripPictures;
    }

    public void setTripPictures(Set<TripPicture> tripPictures) {
        this.tripPictures = tripPictures;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<TripAccomodation> getTripAccomodations() {
        return tripAccomodations;
    }

    public void setTripAccomodations(Set<TripAccomodation> tripAccomodations) {
        this.tripAccomodations = tripAccomodations;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<TripSetoff> getTripSetoffs() {
        return tripSetoffs;
    }

    public void setTripSetoffs(Set<TripSetoff> tripSetoffs) {
        this.tripSetoffs = tripSetoffs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProduct that = (SimpleProduct) o;

        if (id != that.id) return false;
        if (duration != that.duration) return false;
        if (clickRate != that.clickRate) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (searchContent != null ? !searchContent.equals(that.searchContent) : that.searchContent != null)
            return false;
        if (setoffLocation != null ? !setoffLocation.equals(that.setoffLocation) : that.setoffLocation != null)
            return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        if (tripDestinations != null ? !tripDestinations.equals(that.tripDestinations) : that.tripDestinations != null)
            return false;
        if (tripTraffics != null ? !tripTraffics.equals(that.tripTraffics) : that.tripTraffics != null) return false;
        if (tripPrices != null ? !tripPrices.equals(that.tripPrices) : that.tripPrices != null) return false;
        if (tripPictures != null ? !tripPictures.equals(that.tripPictures) : that.tripPictures != null) return false;
        if (tripAccomodations != null ? !tripAccomodations.equals(that.tripAccomodations) : that.tripAccomodations != null)
            return false;
        return tripSetoffs != null ? tripSetoffs.equals(that.tripSetoffs) : that.tripSetoffs == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (searchContent != null ? searchContent.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + clickRate;
        result = 31 * result + (setoffLocation != null ? setoffLocation.hashCode() : 0);
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (tripDestinations != null ? tripDestinations.hashCode() : 0);
        result = 31 * result + (tripTraffics != null ? tripTraffics.hashCode() : 0);
        result = 31 * result + (tripPrices != null ? tripPrices.hashCode() : 0);
        result = 31 * result + (tripPictures != null ? tripPictures.hashCode() : 0);
        result = 31 * result + (tripAccomodations != null ? tripAccomodations.hashCode() : 0);
        result = 31 * result + (tripSetoffs != null ? tripSetoffs.hashCode() : 0);
        return result;
    }
}
