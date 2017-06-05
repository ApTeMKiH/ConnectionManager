package ua.lviv.lgs.services;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Following;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
public interface FollowingService {
    void add(Following following, String email);

    void edit(Following following);

    Following findOne(int id);

    List<Following> findAllForUser(User user);

    void delete(int id);

    Following findByUserAndIdFollowing(User user, int id);
}
