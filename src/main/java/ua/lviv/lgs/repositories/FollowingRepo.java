package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Following;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
public interface FollowingRepo extends JpaRepository<Following, Integer>{
    List<Following> findByUser(User user);

    Following findByUserAndIdFollowing(User user, int id);
}
