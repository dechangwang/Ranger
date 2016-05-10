package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "trip_destination", schema = "ranger", catalog = "")
public class TripDestination {
    private long id;
    private String brief;


    private Location location;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }



    @ManyToOne
    @JoinColumn(name="location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripDestination that = (TripDestination) o;

        if (id != that.id) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripDestination{" +
                "id=" + id +
                ", brief='" + brief + '\'' +
                ", location=" + location +
                '}';
    }
}
