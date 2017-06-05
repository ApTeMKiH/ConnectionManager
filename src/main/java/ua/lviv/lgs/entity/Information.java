package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Артем on 4/24/2017.
 */
@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sex;
    private String phone;
    private String maritalStatus;
    @Column(length = 1000)
    private String interests;
    @Column(length = 1000)
    private String socialStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    private User user;

    public Information() {
        this.date = new Date();
    }

    public Information(String sex, String phone, String maritalStatus, String interests, String socialStatus) {
        this.sex = sex;
        this.phone = phone;
        this.maritalStatus = maritalStatus;
        this.interests = interests;
        this.socialStatus = socialStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
