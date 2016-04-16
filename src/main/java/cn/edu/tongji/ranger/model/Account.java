package cn.edu.tongji.ranger.model;

import javax.persistence.*;

@Table(name = "account", catalog = "ranger")
@Entity
public class Account {
    private String name;
    private String password;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
