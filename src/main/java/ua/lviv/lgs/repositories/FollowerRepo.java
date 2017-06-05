package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Follower;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
public interface FollowerRepo extends JpaRepository<Follower, Integer> {
    List<Follower> findByUser(User user);

    Follower findByUserAndIdFollower(User user, int id);
}
