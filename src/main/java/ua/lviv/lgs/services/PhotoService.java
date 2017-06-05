package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/12/2017.
 */
public interface PhotoService {
    void add(Photo photo, User user);

    void addAvatar(Photo photo);

    Photo findByPath(String path);

    Photo findOne(int id);

    void edit(Photo photo);

    List<Photo> findAllForUser(User user);

    Photo findAvatar(User user);

    void delete(int id);

}
