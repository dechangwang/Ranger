package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
//public class Account extends BaseModel implements Serializable {
public class Account implements Serializable {
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
