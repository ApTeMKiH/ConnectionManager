package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
public interface PostsRepo extends JpaRepository<Posts, Integer> {

    List<Posts> findByUser(User user);


}
