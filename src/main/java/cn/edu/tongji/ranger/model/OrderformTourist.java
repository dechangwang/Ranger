package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Entity
@Table(name = "orderform_tourist", schema = "", catalog = "ranger")
public class OrderformTourist {
    private long id;
    private String name;
    private boolean gender;
    private String phone;
    private String email;
    private Timestamp birthDate;
    private String certifateType;
    private String certifateNumber;
    private int state;
    private String remark;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true)
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "certifate_type", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCertifateType() {
        return certifateType;
    }

    public void setCertifateType(String certifateType) {
        this.certifateType = certifateType;
    }

    @Basic
    @Column(name = "certifate_number", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCertifateNumber() {
        return certifateNumber;
    }

    public void setCertifateNumber(String certifateNumber) {
        this.certifateNumber = certifateNumber;
    }

    @Basic
    @Column(name = "state", nullable = false, insertable = true, updatable = true)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "remark", nullable = false, insertable = true, updatable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderformTourist that = (OrderformTourist) o;

        if (gender != that.gender) return false;
        if (id != that.id) return false;
        if (state != that.state) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (certifateNumber != null ? !certifateNumber.equals(that.certifateNumber) : that.certifateNumber != null)
            return false;
        if (certifateType != null ? !certifateType.equals(that.certifateType) : that.certifateType != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (certifateType != null ? certifateType.hashCode() : 0);
        result = 31 * result + (certifateNumber != null ? certifateNumber.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
