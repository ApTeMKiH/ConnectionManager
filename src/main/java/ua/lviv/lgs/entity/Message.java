package ua.lviv.lgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Артем on 4/24/2017.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1000)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private boolean favorite;
    private boolean deletedByFrom;
    private boolean deletedByTo;
    private boolean statusFrom;
    private boolean statusTo;

    @ManyToOne
    private User userFrom;

    @ManyToOne
    private User userTo;

    @ManyToOne
    private Dialogs dialogs;


    public Message() {
        this.date = new Date();
        this.favorite = false;
        this.deletedByFrom = false;
        this.deletedByTo = false;
        this.statusFrom = false;
        this.statusTo = false;
    }

    public Message(String text) {
        this.text = text;
        this.date = new Date();
        this.favorite = false;
        this.deletedByFrom = false;
        this.deletedByTo = false;
        this.statusFrom = false;
        this.statusTo = false;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isDeletedByFrom() {
        return deletedByFrom;
    }

    public void setDeletedByFrom(boolean deletedByFrom) {
        this.deletedByFrom = deletedByFrom;
    }

    public boolean isDeletedByTo() {
        return deletedByTo;
    }

    public void setDeletedByTo(boolean deletedByTo) {
        this.deletedByTo = deletedByTo;
    }

    public boolean isStatusFrom() {
        return statusFrom;
    }

    public void setStatusFrom(boolean statusFrom) {
        this.statusFrom = statusFrom;
    }

    public boolean isStatusTo() {
        return statusTo;
    }

    public void setStatusTo(boolean statusTo) {
        this.statusTo = statusTo;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public Dialogs getDialogs() {
        return dialogs;
    }

    public void setDialogs(Dialogs dialogs) {
        this.dialogs = dialogs;
    }
}
