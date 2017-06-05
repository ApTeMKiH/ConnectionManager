package ua.lviv.lgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.persistence.*;

/**
 * Created by Артем on 5/7/2017.
 */
@Entity
public class UserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int activationCode;
    private boolean activated;
    private boolean block;
    private boolean blockMessage;
    private boolean blockPost;

    @JsonIgnore
    @OneToOne
    private User user;

    public UserConfig() {
        this.activationCode = RandomUtils.nextInt(1000000,99999999);
        this.activated = false;
        this.block = true;
        this.blockMessage = false;
        this.blockPost = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(int activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public boolean isBlockMessage() {
        return blockMessage;
    }

    public void setBlockMessage(boolean blockMessage) {
        this.blockMessage = blockMessage;
    }

    public boolean isBlockPost() {
        return blockPost;
    }

    public void setBlockPost(boolean blockPost) {
        this.blockPost = blockPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
