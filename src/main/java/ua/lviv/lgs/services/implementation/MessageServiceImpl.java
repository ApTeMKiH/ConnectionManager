package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dto.MessageDTO;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.Message;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.MessageRepo;
import ua.lviv.lgs.services.DialogService;
import ua.lviv.lgs.services.MessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 5/1/2017.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private DialogService dialogService;

    @Override
    public void add(Message message, Dialogs dialogs, User userFrom, User userTo) {
        message.setUserFrom(userFrom);
        message.setUserTo(userTo);
        message.setDialogs(dialogs);
        dialogs.setLastMessage(message.getText());
        dialogService.edit(dialogs);
        messageRepo.save(message);
    }

    @Override
    public List<MessageDTO> findByDialogs(Dialogs dialogs) {
        List<Message> messages = messageRepo.findByDialogs(dialogs);
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message message : messages) {
            messageDTOS.add(new MessageDTO(message.getId(),message.getText(), message.getDate(),message.isFavorite(), message.isDeletedByFrom(), message.isDeletedByTo(), message.isStatusFrom(), message.isStatusTo(), message.getUserFrom().getName(), message.getUserFrom().getId(), message.getUserTo().getName(), message.getUserTo().getId(), message.getDialogs().getId()));
        }
        return messageDTOS;
    }

    @Override
    public List<Message> findByUserAndStatus(User user, boolean status) {
        return messageRepo.findByUserToAndStatusTo(user, status);
    }

    @Override
    public List<MessageDTO> findByUserFromAndUserToAndDeletedByFrom(User userFrom, User userTo, boolean deletedFrom) {
        List<Message> messages = messageRepo.findByUserFromAndUserToAndDeletedByFrom(userFrom, userTo, deletedFrom);
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message message : messages) {
            messageDTOS.add(new MessageDTO(message.getId(),message.getText(), message.getDate(),message.isFavorite(), message.isDeletedByFrom(), message.isDeletedByTo(), message.isStatusFrom(), message.isStatusTo(), message.getUserFrom().getName(), message.getUserFrom().getId(), message.getUserTo().getName(), message.getUserTo().getId(), message.getDialogs().getId()));
        }
        return messageDTOS;
    }

    @Override
    public List<MessageDTO> findByUserFromAndUserToAndDeletedByTo(User userFrom, User userTo, boolean deletedTo) {
        List<Message> messages = messageRepo.findByUserFromAndUserToAndDeletedByTo(userFrom, userTo, deletedTo);
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message message : messages) {
            messageDTOS.add(new MessageDTO(message.getId(),message.getText(), message.getDate(),message.isFavorite(), message.isDeletedByFrom(), message.isDeletedByTo(), message.isStatusFrom(), message.isStatusTo(), message.getUserFrom().getName(), message.getUserFrom().getId(), message.getUserTo().getName(), message.getUserTo().getId(), message.getDialogs().getId()));
        }
        return messageDTOS;
    }

    @Override
    public void delete(int id) {
        messageRepo.delete(id);
    }

    @Override
    public Message findOne(int id) {
        return messageRepo.findOne(id);
    }

    @Override
    public void edit(Message message) {
        messageRepo.save(message);
    }
}
