package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.lgs.entity.Information;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.InformationService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.Date;

/**
 * Created by Артем on 5/3/2017.
 */
@Controller
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;

    @Qualifier("informationValidator")
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/registration/more-information", method = RequestMethod.GET)
    public String addInformation(Model model){
        model.addAttribute("information", new Information());
        return "setInformation";
    }

    @RequestMapping(value = "/registration/more-information", method = RequestMethod.POST)
    public String addInformation(@ModelAttribute Information information, Principal principal, BindingResult bindingResult){
        User user = userService.findByEmail(principal.getName());
        informationService.add(information,user);
        return "redirect:/";
    }

    @RequestMapping(value = "/information/edit", method = RequestMethod.POST)
    public String informationEdit(@ModelAttribute("information")Information information, Principal principal){
        Information information1 = informationService.findByUser(userService.findByEmail(principal.getName()));
        if (information == null){
            information1.setDate(new Date());
            information1.setSex(information.getSex());
            information1.setPhone(information.getPhone());
            information1.setMaritalStatus(information.getMaritalStatus());
            information1.setInterests(information.getInterests());
            information1.setSocialStatus(information.getSocialStatus());
            informationService.add(information1, userService.findByEmail(principal.getName()));
        }else {
            information1.setDate(new Date());
            information1.setSex(information.getSex());
            information1.setPhone(information.getPhone());
            information1.setMaritalStatus(information.getMaritalStatus());
            information1.setInterests(information.getInterests());
            information1.setSocialStatus(information.getSocialStatus());
            informationService.edit(information1);
        }
        return "redirect:/settings";
    }
}
