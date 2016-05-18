package cn.edu.tongji.ranger.model2show;

import cn.edu.tongji.ranger.model.Location;

import javax.persistence.*;

/**
 * Created by daidongyang on 5/16/16.
 */

@Entity
@Table(name = "trip_destination", schema = "ranger", catalog = "")
public class TripDestination2 {
    private long id;
    private String brief;
    private Location location;
//    private long productId;

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

        TripDestination2 that = (TripDestination2) o;

        if (id != that.id) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
