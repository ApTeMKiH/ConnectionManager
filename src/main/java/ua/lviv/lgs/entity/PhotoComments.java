package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class PhotoComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private int authorId;

    @ManyToOne
    private Photo photo;


    public PhotoComments() {
    }

    public PhotoComments(String text, Date date, int authorId, Photo photo) {
        this.text = text;
        this.date = date;
        this.authorId = authorId;
        this.photo = photo;
    }

    public PhotoComments(String text, Date date) {
        this.text = text;
        this.date = date;
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
