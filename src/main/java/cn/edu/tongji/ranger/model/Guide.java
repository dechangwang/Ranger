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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



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

    public boolean isGender() {
        return gender;
    }

    //    public Angency getAngency() {
//        return angency;
//    }
//
//    public void setAngency(Angency angency) {
//        this.angency = angency;
//    }

}
