package ua.lviv.lgs.controllers;

import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.dto.MessageDTO;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.Message;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.DialogService;
import ua.lviv.lgs.services.MessageService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Артем on 5/3/2017.
 */
@Controller
public class MessageController {

    @Autowired
    private DialogService dialogService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dialogs/{id}", method = RequestMethod.GET)
    public String dialog(@PathVariable Integer id, Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "dialog";
    }

    @RequestMapping(value = "/friend/profile/{id}/messaging", method = RequestMethod.GET)
    public String writeMessage(Principal principal, @PathVariable Integer id, @RequestParam("text") String text){
        Message message = new Message();
        message.setText(text);
        Dialogs dialogs = dialogService.findByUserFromAndUserTo(userService.findByEmail(principal.getName()), userService.findById(id));
        Dialogs dialogs1 = dialogService.findByUserFromAndUserTo(userService.findById(id), userService.findByEmail(principal.getName()));
        if (dialogs == null && dialogs1 == null){
            Dialogs dialogs2 = new Dialogs();
            dialogs2.setUserFrom(userService.findByEmail(principal.getName()));
            dialogs2.setUserTo(userService.findById(id));
            dialogService.add(dialogs2);
            messageService.add(message, dialogs2, userService.findByEmail(principal.getName()), userService.findById(id));
        }else {
            if (dialogs == null){
                messageService.add(message, dialogs1, userService.findByEmail(principal.getName()), userService.findById(id));
            }else {
                messageService.add(message, dialogs, userService.findByEmail(principal.getName()), userService.findById(id));
            }
        }
        return "redirect:/friend/profile/{id}";
    }

    @RequestMapping(value = "/dialog/friend/{id}", method = RequestMethod.GET)
    public String messaging(@PathVariable Integer id, Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        if (dialogService.findByUserFromAndUserTo(userService.findByEmail(principal.getName()), userService.findById(id)) != null){
            model.addAttribute("dialog", dialogService.findByUserFromAndUserTo(userService.findByEmail(principal.getName()), userService.findById(id)));
        } else if (dialogService.findByUserFromAndUserTo(userService.findById(id), userService.findByEmail(principal.getName())) != null){
            model.addAttribute("dialog", dialogService.findByUserFromAndUserTo(userService.findById(id), userService.findByEmail(principal.getName())));
        }
        return "messaging";
    }

    @RequestMapping(value = "/dialog/friend/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void messaging(@PathVariable Integer id, @RequestBody Message message, Principal principal){
        Dialogs dialogs = dialogService.findOne(id);
        int userId;
        if (dialogs.getUserFrom().getId() == userService.findByEmail(principal.getName()).getId()){
            userId = dialogs.getUserTo().getId();
        } else {
            userId = dialogs.getUserFrom().getId();
        }
        messageService.add(message, dialogs, userService.findByEmail(principal.getName()), userService.findById(userId));
    }



    @RequestMapping(value = "/dialog/{id}/all/message", method = RequestMethod.GET)
    @ResponseBody
    public List<MessageDTO> getAllMessage(@PathVariable Integer id, Principal principal){
        User user = userService.findByEmail(principal.getName());
        List<MessageDTO> messageDTOS = messageService.findByDialogs(dialogService.findOne(id));
        for (int i = 0; i < messageDTOS.size(); i++) {
            if (messageDTOS.get(i).getUserFromId() == user.getId()){
                if (!(messageDTOS.get(i).isStatusFrom())){
                    Message message = messageService.findOne(messageDTOS.get(i).getId());
                    message.setStatusFrom(true);
                    messageService.edit(message);
                }
            }else if (messageDTOS.get(i).getUserToId() == user.getId()){
                if (!(messageDTOS.get(i).isStatusTo())){
                    Message message = messageService.findOne(messageDTOS.get(i).getId());
                    message.setStatusTo(true);
                    messageService.edit(message);
                }
            }
        }
        return messageDTOS;
    }

    @RequestMapping(value = "/dialog/message/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteMessage(Principal principal, @PathVariable Integer id){
        messageService.delete(id);
    }

    @RequestMapping(value = "/message/check", method = RequestMethod.GET)
    @ResponseBody
    public int checkMessage(Principal principal){
        return messageService.findByUserAndStatus(userService.findByEmail(principal.getName()), false).size();
    }


}
