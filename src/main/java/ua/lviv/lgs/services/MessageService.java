package ua.lviv.lgs.services;

import ua.lviv.lgs.dto.MessageDTO;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.Message;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/1/2017.
 */
public interface MessageService {

    void add(Message message, Dialogs dialogs, User userFrom, User userTo);

    List<Message> findByUserAndStatus(User user, boolean status);

    List<MessageDTO> findByUserFromAndUserToAndDeletedByFrom(User userFrom, User userTo, boolean deletedFrom);

    List<MessageDTO> findByUserFromAndUserToAndDeletedByTo(User userFrom, User userTo, boolean deletedFrom);

    void edit(Message message);

    List<MessageDTO> findByDialogs(Dialogs dialogs);

    void delete(int id);

    Message findOne(int id);

}
