package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
public interface PhotoRepo extends JpaRepository<Photo, Integer> {
    List<Photo> findByUser(User user);

    Photo findByUserAndAvatar(User user, boolean avatar);

    Photo findByPath(String path);
}
