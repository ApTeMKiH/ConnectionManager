package ua.lviv.lgs.dto;

import java.util.Date;

/**
 * Created by Артем on 5/21/2017.
 */
public class MessageDTO {

    private int id;
    private String text;
    private Date date;
    private boolean favorite;
    private boolean deletedByFrom;
    private boolean deletedByTo;
    private boolean statusFrom;
    private boolean statusTo;
    private String userFrom;
    private int userFromId;
    private String userTo;
    private int userToId;
    private int dialogsId;

    public MessageDTO() {
        this.favorite = false;
        this.deletedByFrom = false;
        this.deletedByTo = false;
        this.statusFrom = false;
        this.statusTo = false;
    }

    public MessageDTO(int id, String text, Date date, boolean favorite, boolean deletedByFrom, boolean deletedByTo, boolean statusFrom, boolean statusTo, String userFrom, int userFromId, String userTo, int userToId, int dialogsId) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.favorite = favorite;
        this.deletedByFrom = deletedByFrom;
        this.deletedByTo = deletedByTo;
        this.statusFrom = statusFrom;
        this.statusTo = statusTo;
        this.userFrom = userFrom;
        this.userFromId = userFromId;
        this.userTo = userTo;
        this.userToId = userToId;
        this.dialogsId = dialogsId;
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

    public void setDeletedByTo(boolean deletedByUser) {
        this.deletedByTo = deletedByUser;
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

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public int getDialogsId() {
        return dialogsId;
    }

    public void setDialogsId(int dialogsId) {
        this.dialogsId = dialogsId;
    }

    public int getUserFromId() {
        return userFromId;
    }

    public void setUserFromId(int userFromId) {
        this.userFromId = userFromId;
    }

    public int getUserToId() {
        return userToId;
    }

    public void setUserToId(int userToId) {
        this.userToId = userToId;
    }
}
