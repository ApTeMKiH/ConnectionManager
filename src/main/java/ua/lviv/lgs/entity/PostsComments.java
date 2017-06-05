package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class PostsComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    private User author;

    @ManyToOne
    private Posts posts;

    public PostsComments() {
        this.date = new Date();
    }

    public PostsComments(String text) {
        this.text = text;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public User getUser() {
        return author;
    }

    public void setUser(User user) {
        this.author = user;
    }
}
