package ua.lviv.lgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import ua.lviv.lgs.utill.ValidationMessages;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Артем on 4/24/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private String who;
    private String avatarPath;

    @JsonIgnore
    @OneToOne
    private PostsComments postsComments;

    @JsonIgnore
    @OneToOne
    private Posts posts;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    private UserConfig userConfig;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    private Information information;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Friends> friends;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Follower> followers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Following> followings;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Posts> postsList;

    @JsonIgnore
    @OneToMany(mappedBy = "userFrom")
    private List<Dialogs> dialogsFromList;

    @JsonIgnore
    @OneToMany(mappedBy = "userTo")
    private List<Dialogs> dialogsToList;

    @JsonIgnore
    @OneToMany(mappedBy = "userFrom")
    private List<Message> messageFromList;

    @JsonIgnore
    @OneToMany(mappedBy = "userTo")
    private List<Message> messageToList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Photo> photoList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Audio> audioList;



    public User() {
        this.role = "ROLE_USER";
        this.avatarPath = ValidationMessages.AVATAR_DEFAULT_PATH;
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = "ROLE_USER";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public UserConfig getUserConfig() {
        return userConfig;
    }

    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }

    public List<Dialogs> getDialogsFromList() {
        return dialogsFromList;
    }

    public void setDialogsFromList(List<Dialogs> dialogsFromList) {
        this.dialogsFromList = dialogsFromList;
    }

    public List<Dialogs> getDialogsToList() {
        return dialogsToList;
    }

    public void setDialogsToList(List<Dialogs> dialogsToList) {
        this.dialogsToList = dialogsToList;
    }

    public List<Message> getMessageFromList() {
        return messageFromList;
    }

    public void setMessageFromList(List<Message> messageFromList) {
        this.messageFromList = messageFromList;
    }

    public List<Message> getMessageToList() {
        return messageToList;
    }

    public void setMessageToList(List<Message> messageToList) {
        this.messageToList = messageToList;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<Audio> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<Audio> audioList) {
        this.audioList = audioList;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<Following> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Following> followings) {
        this.followings = followings;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public PostsComments getPostsComments() {
        return postsComments;
    }

    public void setPostsComments(PostsComments postsComments) {
        this.postsComments = postsComments;
    }
}
