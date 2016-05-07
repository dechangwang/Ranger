package cn.edu.tongji.ranger.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="location")
/**
 * Created by daidongyang on 5/7/16.
 */
public class LocationD implements Serializable{
    private Long id;
    private String name;
    private Long fatherId;

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    @Column(name="father_id")
    public Long getFatherId() {
        return fatherId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public String toString() {
        return "LocationD{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherId=" + fatherId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationD locationD = (LocationD) o;

        if (id != null ? !id.equals(locationD.id) : locationD.id != null) return false;
        if (name != null ? !name.equals(locationD.name) : locationD.name != null) return false;
        return fatherId != null ? fatherId.equals(locationD.fatherId) : locationD.fatherId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fatherId != null ? fatherId.hashCode() : 0);
        return result;
    }
}
