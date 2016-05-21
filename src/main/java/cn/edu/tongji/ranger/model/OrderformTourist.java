package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 马二爷 on 2016/5/18.
 */
@Entity
@Table(name = "orderform_tourist", schema = "", catalog = "ranger")
public class OrderformTourist {
    private long id;
    private long orderformId;
    private long touristTypeId;
    private String name;
    private boolean gender;
    private String phone;
    private String email;
    private Timestamp birthDate;
    private String certifateType;
    private String certifateNumber;
    private int state;
    private String remark;

    public OrderformTourist(){}

    public OrderformTourist(TouristForm form)
    {
        this.name=form.getName();
        this.gender=form.getGender().equals("0");
        this.phone=form.getPhone();
        this.birthDate=new Timestamp(form.getBirthDate().getTime());
        this.certifateType=form.getCertifateType();
        this.certifateNumber=form.getCertifateNumber();
        this.touristTypeId=Long.parseLong(form.getTouristTypeId());
        this.remark=form.getRemark();
        this.email=form.getEmail();
    }
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderform_id", nullable = false, insertable = true, updatable = true)
    public long getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(long orderformId) {
        this.orderformId = orderformId;
    }

    @Basic
    @Column(name = "tourist_type_id", nullable = false, insertable = true, updatable = true)
    public long getTouristTypeId() {
        return touristTypeId;
    }

    public void setTouristTypeId(long touristTypeId) {
        this.touristTypeId = touristTypeId;
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

        OrderformTourist tourist = (OrderformTourist) o;

        if (gender != tourist.gender) return false;
        if (id != tourist.id) return false;
        if (orderformId != tourist.orderformId) return false;
        if (state != tourist.state) return false;
        if (touristTypeId != tourist.touristTypeId) return false;
        if (birthDate != null ? !birthDate.equals(tourist.birthDate) : tourist.birthDate != null) return false;
        if (certifateNumber != null ? !certifateNumber.equals(tourist.certifateNumber) : tourist.certifateNumber != null)
            return false;
        if (certifateType != null ? !certifateType.equals(tourist.certifateType) : tourist.certifateType != null)
            return false;
        if (email != null ? !email.equals(tourist.email) : tourist.email != null) return false;
        if (name != null ? !name.equals(tourist.name) : tourist.name != null) return false;
        if (phone != null ? !phone.equals(tourist.phone) : tourist.phone != null) return false;
        if (remark != null ? !remark.equals(tourist.remark) : tourist.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderformId ^ (orderformId >>> 32));
        result = 31 * result + (int) (touristTypeId ^ (touristTypeId >>> 32));
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
