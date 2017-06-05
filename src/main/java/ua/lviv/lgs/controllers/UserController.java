package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.dto.UserDTO;
import ua.lviv.lgs.entity.Follower;
import ua.lviv.lgs.entity.Information;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.entity.UserConfig;
import ua.lviv.lgs.services.FollowerService;
import ua.lviv.lgs.services.InformationService;
import ua.lviv.lgs.services.UserConfigService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 5/3/2017.
 */
@Controller
public class UserController {

    @Autowired
    private FollowerService followerService;

    @Autowired
    private UserService userService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private UserConfigService userConfigService;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public void userAdd(@RequestBody User user){
        userService.add(user);
    }


    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    @ResponseBody
    public User getCurrentUser(Principal principal){
        return userService.findByEmail(principal.getName());
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        Information information = informationService.findByUser(userService.findByEmail(principal.getName()));
        if (information != null){
            model.addAttribute("information", information);
        } else {
            model.addAttribute("information", new Information());
        }

        model.addAttribute("userConfig", userConfigService.findByUserId(userService.findByEmail(principal.getName()).getId()));
        return "settings";
    }

    @RequestMapping(value = "/user/check/friend", method = RequestMethod.GET)
    @ResponseBody
    public int getNewFriend(Principal principal){
        List<Follower> followers = followerService.findAllForUser(userService.findByEmail(principal.getName()));
        return followers.size();
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manage(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "managePage";
    }

    @RequestMapping(value = "/manage/search", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> searchUser(@RequestParam("name") String name){
        List<User> users = userService.searchPeople(name);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getRole(), user.getWho(), user.getAvatarPath(), user.getUserConfig()));
        }
        return userDTOS;
    }

    @RequestMapping(value = "/manage/block/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void blockUser(@PathVariable Integer id){
        UserConfig userConfig = userConfigService.findByUserId(id);
        userConfig.setBlock(false);
        userConfigService.edit(userConfig);
    }

    @RequestMapping(value = "/manage/unblock/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void unblockUser(@PathVariable Integer id){
        UserConfig userConfig = userConfigService.findByUserId(id);
        userConfig.setBlock(true);
        userConfigService.edit(userConfig);
    }

    @RequestMapping(value = "/manage/delete/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }



}
