package cn.edu.tongji.ranger.model;

/**
 * Created by wangdechang on 2016/4/30.
 */
public class Business {
    private long id;
    private String name;
    private String type;
    private String number;
    private String phone;
    private String email;
    private String address;
    private String certificate;
    private double balance;
    private String brief;
    private String password;

    public Business() {
    }

    public Business(long id, String name, String type, String number,
                    String phone, String email, String address, String certificate,
                    double balance, String brief, String password) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", certificate='" + certificate + '\'' +
                ", balance=" + balance +
                ", brief='" + brief + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
