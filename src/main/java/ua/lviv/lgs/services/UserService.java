package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/1/2017.
 */
public interface UserService {
    void add(User user);

    void edit(User user);

    void activate(int activationKey);

    List<User> searchPeople(String name);

    void delete(int id);

    User findByEmail(String email);

    User findById(int id);

    List<User> getAll();
}
