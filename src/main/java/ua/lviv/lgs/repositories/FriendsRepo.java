package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
public interface FriendsRepo extends JpaRepository<Friends, Integer> {
        List<Friends> findByUser(User user);

        Friends findByUserAndIdFriend(User user, int id);
}
