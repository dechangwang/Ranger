package cn.edu.tongji.ranger.model;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import sun.management.Agent;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Entity
@Table(name = "guide")
public class Guide {

    private long id;
    private String name;// `name` VARCHAR(45) NOT NULL DEFAULT "",
    private long angency_id;
    private boolean gender;
    private String phone;
    private String email;
    private String address;

//    private Angency angency;

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
    @Column(name = "name",nullable = false,length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "angency_id",nullable = false,length = 20)
    public long getAngency_id() {
        return angency_id;
    }

    public void setAngency_id(long angency_id) {
        this.angency_id = angency_id;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 1)
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
