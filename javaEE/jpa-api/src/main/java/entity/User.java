package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wzh on 15/12/2016.
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

    private String userId;
    private String password;
    private String department;
    private String major;
    private String name;
    private String sex;

    public User() {
    }

    public User(String userId, String password, String department, String major, String name, String sex) {
        this.userId = userId;
        this.password = password;
        this.department = department;
        this.major = major;
        this.name = name;
        this.sex = sex;
    }

    @Id
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
