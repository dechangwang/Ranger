package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Entity
@Table(name = "angency")
public class Angency {
    private long id;
    private String name;
    private String type;
    private String number;
    private String rnumber;
    private String phone;
    private String email;
    private String address;
    private String certificate;
    private double balance;
    private String brief;
    private String password;
    private String cname;

    public Angency() {
    }

    public Angency(long id, String name, String type, String number, String phone,
                   String email, String address, String certificate, double balance,
                   String brief, String password, String cname,String rnumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.certificate = certificate;
        this.balance = balance;
        this.brief = brief;
        this.password = password;
        this.cname = cname;
        this.rnumber = rnumber;
    }

    public Angency(long id, String name, String type, String number, String phone,
                   String email, String address, String certificate, double balance,
                   String brief, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.certificate = certificate;
        this.balance = balance;
        this.brief = brief;
        this.password = password;
    }



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
    @Column(name = "register_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Basic
    @Column(name = "register_certifate_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

    }

    @Basic
    @Column(name = "register_brief")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;

    }

    @Basic
    @Column(name = "regiester_number")
    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
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

    @Basic
    @Column(name = "lincense_picture")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }


    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }


    public void setBrief(String brief) {
        this.brief = brief;
    }


    @Basic
    @Column(name = "name")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "password")
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

        if (id != angency.id) return false;
        if (Double.compare(angency.balance, balance) != 0) return false;
        if (name != null ? !name.equals(angency.name) : angency.name != null)
            return false;
        if (type != null ? !type.equals(angency.type) : angency.type != null)
            return false;
        if (number != null ? !number.equals(angency.number) : angency.number != null)

            return false;
        if (phone != null ? !phone.equals(angency.phone) : angency.phone != null) return false;
        if (email != null ? !email.equals(angency.email) : angency.email != null) return false;
        if (address != null ? !address.equals(angency.address) : angency.address != null) return false;
        if (certificate != null ? !certificate.equals(angency.certificate) : angency.certificate != null)
            return false;
        if (brief != null ? !brief.equals(angency.brief) : angency.brief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (certificate != null ? certificate.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Angency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", rnumber='"+rnumber+'\''+
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", certificate='" + certificate + '\'' +
                ", balance=" + balance +
                ", brief='" + brief + '\'' +
                ", password='" + password + '\'' +
                ", cname ='"+cname+'\''+
                '}';
    }

}
