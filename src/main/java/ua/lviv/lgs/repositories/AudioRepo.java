package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Audio;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
public interface AudioRepo extends JpaRepository<Audio, Integer> {

    List<Audio> findByUser(User user);


}
