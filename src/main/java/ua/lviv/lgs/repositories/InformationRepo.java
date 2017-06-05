package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Information;
import ua.lviv.lgs.entity.User;

/**
 * Created by Артем on 5/7/2017.
 */
public interface InformationRepo extends JpaRepository<Information, Integer>{

    Information findByUser(User user);
}
