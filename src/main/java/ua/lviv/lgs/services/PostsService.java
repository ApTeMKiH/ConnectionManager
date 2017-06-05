package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/14/2017.
 */
public interface PostsService {

    void add(Posts posts, User user);

    void add(Posts posts, User currentUser, User user);

    void edit(Posts posts);

    List<Posts> findAllForUser(User user);

    Posts findOne(int id);

    void delete(int id);
}
