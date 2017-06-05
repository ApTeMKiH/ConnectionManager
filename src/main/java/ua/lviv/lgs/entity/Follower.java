package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by Артем on 5/11/2017.
 */
@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idFollower;

    @ManyToOne
    private User user;

    public Follower() {
    }

    public Follower(int idFollower) {
        this.idFollower = idFollower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFollower() {
        return idFollower;
    }

    public void setIdFollower(int idFollower) {
        this.idFollower = idFollower;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
