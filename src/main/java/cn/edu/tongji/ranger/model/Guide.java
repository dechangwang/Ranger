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

    public long getAngency_id() {
        return angency_id;
    }

    public void setAngency_id(long angency_id) {
        this.angency_id = angency_id;
    }

    public boolean isGender() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guide guide = (Guide) o;

        if (id != guide.id) return false;
        if (angency_id != guide.angency_id) return false;
        if (gender != guide.gender) return false;
        if (name != null ? !name.equals(guide.name) : guide.name != null) return false;
        if (phone != null ? !phone.equals(guide.phone) : guide.phone != null) return false;
        if (email != null ? !email.equals(guide.email) : guide.email != null) return false;
        return address != null ? address.equals(guide.address) : guide.address == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (angency_id ^ (angency_id >>> 32));
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", angency_id=" + angency_id +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
