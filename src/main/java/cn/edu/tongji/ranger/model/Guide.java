package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Entity
@Table(name = "guide")
public class Guide {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name",nullable = false,length = 45)
    private String name;// `name` VARCHAR(45) NOT NULL DEFAULT "",
    @Column(name = "angency_id",nullable = false,length = 20)
    private long angency_id;
    @Column(name = "gender", nullable = false, length = 1)
    private boolean gender;
    @Column(name = "phone", nullable = false, length = 45)
    private String phone;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "address", nullable = false, length = 200)
    private String address;

//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "angency_id", referencedColumnName = "ID")
//    private Angency angency;

    public Guide() {
    }

    public Guide(String name,long angency_id,boolean gender, String phone,
                 String email, String address) {
        this.name = name;
        this.angency_id = angency_id;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;

    }

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

    public boolean getGender() {
        return gender;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAngency_id() {
        return angency_id;
    }

    public void setAngency_id(long angency_id) {
        this.angency_id = angency_id;
    }

    @Basic
    @Column(name = "gender")
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guide guide = (Guide) o;

        if (id != guide.id) return false;
        if (gender != guide.gender) return false;
        if (name != null ? !name.equals(guide.name) : guide.name != null) return false;
        if (phone != null ? !phone.equals(guide.phone) : guide.phone != null) return false;
        if (email != null ? !email.equals(guide.email) : guide.email != null) return false;
        if (address != null ? !address.equals(guide.address) : guide.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    //    public Angency getAngency() {
//        return angency;
//    }
//
//    public void setAngency(Angency angency) {
//        this.angency = angency;
//    }
}
