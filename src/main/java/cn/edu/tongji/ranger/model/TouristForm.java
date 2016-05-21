package cn.edu.tongji.ranger.model;

import java.util.Date;

/**
 * Created by 马二爷 on 2016/5/21.
 */
public class TouristForm {
    private String name;
    private String phone;
    private String touristTypeId;
    private String certifateType;
    private String certifateNumber;
    private String gender;
    private Date birthDate;
    private String remark;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTouristTypeId() {
        return touristTypeId;
    }

    public void setTouristTypeId(String touristTypeId) {
        this.touristTypeId = touristTypeId;
    }

    public String getCertifateNumber() {
        return certifateNumber;
    }

    public void setCertifateNumber(String certifateNumber) {
        this.certifateNumber = certifateNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCertifateType() {
        return certifateType;
    }

    public void setCertifateType(String certifateType) {
        this.certifateType = certifateType;
    }
}
