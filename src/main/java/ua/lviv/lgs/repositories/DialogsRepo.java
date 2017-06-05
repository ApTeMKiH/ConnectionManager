package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
@Repository
public interface DialogsRepo extends JpaRepository<Dialogs, Integer> {

    List<Dialogs> findByUserFrom(User userFrom);

    List<Dialogs> findByUserTo(User userTo);

    Dialogs findByUserFromAndUserTo(User userFrom, User userTo);


}
