package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by Артем on 5/11/2017.
 */
@Entity
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idFollowing;

    @ManyToOne
    private User user;

    public Following() {
    }

    public Following(int idFollowing) {
        this.idFollowing = idFollowing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFollowing() {
        return idFollowing;
    }

    public void setIdFollowing(int idFollowing) {
        this.idFollowing = idFollowing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
