package ua.lviv.lgs.services;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Follower;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
public interface FollowerService {
    void add(Follower follower, String email);

    void edit(Follower follower);

    Follower findOne(int id);

    List<Follower> findAllForUser(User user);

    void delete(int id);

    Follower findByUserAndIdFollower(User user, int id);
}
