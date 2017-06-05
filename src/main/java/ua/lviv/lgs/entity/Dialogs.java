package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Артем on 5/2/2017.
 */
@Entity
public class Dialogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastMessage;
    private boolean deletedByFrom;
    private boolean deletedByTo;

    @ManyToOne
    private User userFrom;

    @ManyToOne
    private User userTo;

    @OneToMany(mappedBy = "dialogs", cascade = CascadeType.REMOVE)
    private List<Message> messageList;

    public Dialogs() {
        this.deletedByFrom = false;
        this.deletedByTo = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
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
}
