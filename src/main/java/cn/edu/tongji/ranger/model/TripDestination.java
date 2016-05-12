package cn.edu.tongji.ranger.model;

import javax.persistence.*;

@Entity
@Table(name = "trip_destination", schema = "ranger", catalog = "")
public class TripDestination {
    private long id;
    private String brief;
    private Product product;
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

    @ManyToOne
    @JoinColumn(name="product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="product_id")
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
