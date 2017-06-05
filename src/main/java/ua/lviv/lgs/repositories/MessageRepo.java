package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.Message;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

    List<Message> findByDialogs(Dialogs dialogs);

    List<Message> findByUserToAndStatusTo(User user, boolean status);

    List<Message> findByUserFromAndUserToAndDeletedByFrom(User userFrom, User userTo, boolean deletedFrom);

    List<Message> findByUserFromAndUserToAndDeletedByTo(User userFrom, User userTo, boolean deletedTo);
}
