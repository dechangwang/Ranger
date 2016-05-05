package cn.edu.tongji.ranger.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 马二爷 on 2016/5/2.
 */
@Entity
public class Angency {
    private long id;
    private String registerName;
    private String registerCertifateType;
    private String registerBrief;
    private String phone;
    private String email;
    private String address;
    private String lincensePicture;
    private double balance;
    private String brief;
    private String password;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "register_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    @Basic
    @Column(name = "register_certifate_type", nullable = false, insertable = true, updatable = true, length = 45)
    public String getRegisterCertifateType() {
        return registerCertifateType;
    }

    public void setRegisterCertifateType(String registerCertifateType) {
        this.registerCertifateType = registerCertifateType;
    }

    @Basic
    @Column(name = "register_brief", nullable = false, insertable = true, updatable = true, length = 100)
    public String getRegisterBrief() {
        return registerBrief;
    }

    public void setRegisterBrief(String registerBrief) {
        this.registerBrief = registerBrief;
    }

    @Basic
    @Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "lincense_picture", nullable = false, insertable = true, updatable = true, length = 100)
    public String getLincensePicture() {
        return lincensePicture;
    }

    public void setLincensePicture(String lincensePicture) {
        this.lincensePicture = lincensePicture;
    }

    @Basic
    @Column(name = "balance", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "brief", nullable = false, insertable = true, updatable = true, length = 100)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Angency angency = (Angency) o;

        if (Double.compare(angency.balance, balance) != 0) return false;
        if (id != angency.id) return false;
        if (address != null ? !address.equals(angency.address) : angency.address != null) return false;
        if (brief != null ? !brief.equals(angency.brief) : angency.brief != null) return false;
        if (email != null ? !email.equals(angency.email) : angency.email != null) return false;
        if (lincensePicture != null ? !lincensePicture.equals(angency.lincensePicture) : angency.lincensePicture != null)
            return false;
        if (password != null ? !password.equals(angency.password) : angency.password != null) return false;
        if (phone != null ? !phone.equals(angency.phone) : angency.phone != null) return false;
        if (registerBrief != null ? !registerBrief.equals(angency.registerBrief) : angency.registerBrief != null)
            return false;
        if (registerCertifateType != null ? !registerCertifateType.equals(angency.registerCertifateType) : angency.registerCertifateType != null)
            return false;
        if (registerName != null ? !registerName.equals(angency.registerName) : angency.registerName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (registerName != null ? registerName.hashCode() : 0);
        result = 31 * result + (registerCertifateType != null ? registerCertifateType.hashCode() : 0);
        result = 31 * result + (registerBrief != null ? registerBrief.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (lincensePicture != null ? lincensePicture.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
