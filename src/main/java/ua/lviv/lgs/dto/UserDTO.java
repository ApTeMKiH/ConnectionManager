package ua.lviv.lgs.dto;

import ua.lviv.lgs.entity.UserConfig;

/**
 * Created by Артем on 6/5/2017.
 */
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private String who;
    private String avatarPath;
    private UserConfig userConfig;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String email, String password, String role, String who, String avatarPath, UserConfig userConfig) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.who = who;
        this.avatarPath = avatarPath;
        this.userConfig = userConfig;
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

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public UserConfig getUserConfig() {
        return userConfig;
    }

    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }
}
