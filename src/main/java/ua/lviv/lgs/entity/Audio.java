package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    private String name;

    @ManyToOne
    private User user;

    public Audio() {
    }

    public Audio(String path, String name) {
        this.path = path;
        this.name = name;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
