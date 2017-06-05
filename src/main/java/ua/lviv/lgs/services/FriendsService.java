package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/9/2017.
 */
public interface FriendsService {

    void add(Friends friends, String email);

    void edit(Friends friends);

    Friends findOne(int id);

    List<Friends> findAllForUser(User user);

    void delete(int id);

    Friends findByUserAndIdFriend(User user, int id);

}
