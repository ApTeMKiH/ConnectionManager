package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.services.DialogService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.List;

/**
 * Created by Артем on 5/18/2017.
 */
@Controller
public class DialogsController {
    @Autowired
    private UserService userService;

    @Autowired
    private DialogService dialogService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getAll(Model model, Principal principal){
        List<Dialogs> dialogsList = dialogService.findByUserFrom(userService.findByEmail(principal.getName()));
        dialogsList.addAll(dialogService.findByUserTo(userService.findByEmail(principal.getName())));
        model.addAttribute("dialogs", dialogsList);
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "dialogs";
    }

    @RequestMapping(value = "//dialog/delete/{id}", method = RequestMethod.GET)
    public String deleteDialog(@PathVariable Integer id){
        dialogService.delete(id);
        return "redirect:/message";
    }
}
