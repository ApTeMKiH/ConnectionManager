package ua.lviv.lgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private boolean avatar;
    private int size;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "photo")
    private List<PhotoComments> photoCommentsList;

    public Photo() {
        this.avatar = false;
        this.size = 0;
    }

    public Photo(String path, Date date) {
        this.avatar = false;
        this.size = 0;
        this.path = path;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PhotoComments> getPhotoCommentsList() {
        return photoCommentsList;
    }

    public void setPhotoCommentsList(List<PhotoComments> photoCommentsList) {
        this.photoCommentsList = photoCommentsList;
    }

    public boolean isAvatar() {
        return avatar;
    }

    public void setAvatar(boolean avatar) {
        this.avatar = avatar;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
