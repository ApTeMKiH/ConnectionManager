package ua.lviv.lgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1000)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private int coments;


    @OneToOne(fetch = FetchType.EAGER)
    private User author;

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "posts")
    private List<PostsComments> postsCommentsList;

    public Posts() {
        this.date = new Date();
    }

    public Posts(String text) {
        this.text = text;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PostsComments> getPostsCommentsList() {
        return postsCommentsList;
    }

    public void setPostsCommentsList(List<PostsComments> postsCommentsList) {
        this.postsCommentsList = postsCommentsList;
    }

    public int getComents() {
        return coments;
    }

    public void setComents(int coments) {
        this.coments = coments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
