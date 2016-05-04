package cn.edu.tongji.ranger.model;

/**
 * Created by wangdechang on 2016/5/4.
 */
public class GuideInfo {
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String cname;

    public GuideInfo() {
    }

    public GuideInfo(String name, String gender, String email,
                     String phone, String address, String cname) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cname = cname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "GuideInfo{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
