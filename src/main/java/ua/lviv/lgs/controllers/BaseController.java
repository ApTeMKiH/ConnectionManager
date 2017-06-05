package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.entity.UserConfig;
import ua.lviv.lgs.services.*;

import java.security.Principal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 4/20/2017.
 */
@Controller
public class BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConfigService userConfigService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PostsService postsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String profile(Principal principal, Model model, @RequestParam(value = "first", required = false) String first){
        if (first != null){
            return "redirect:/registration/more-information";
        }else {
            if (!(principal.getName().equalsIgnoreCase("adminConnection"))){
                User user = userService.findByEmail(principal.getName());
                informationService.findByUser(user);
                model.addAttribute("information", informationService.findByUser(user));
                model.addAttribute("currentUser", user);
                Photo photo = photoService.findAvatar(user);
                if (photo != null){
                    model.addAttribute("avatarDate", photo.getDate());
                }else {
                    model.addAttribute("avatarDate", new Date());
                }
                List<Posts> postsList = postsService.findAllForUser(user);
                Collections.reverse(postsList);
                model.addAttribute("posts", postsList);
                model.addAttribute("newPosts", new Posts());
                List<Photo> photos = photoService.findAllForUser(user);
                if (photos.size() < 5){
                    model.addAttribute("photo", photos);
                }else {
                    model.addAttribute("photo", photos.subList(0,5));
                }
            }else {
                model.addAttribute("newPosts", new Posts());
            }
        }
        return "profile";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public void registration(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String signIn(@RequestParam(value = "failure", required = false) String error,
                         @RequestParam(value = "active", required = false) String active,
                         @RequestParam(value = "block", required = false) String block,
                         @RequestParam(value = "reg", required = false) String reg, Model model){
        if (active != null){
            model.addAttribute("error", "Your account isn't activated. Please check your email.");
            model.addAttribute("info", "");
            return "signIn";
        }else if (block != null){
            model.addAttribute("error", "Your account was blocked. For more details contact with email: connection.manage@gmail.com");
            model.addAttribute("info", "");
            return "signIn";
        }else if (reg != null){
            model.addAttribute("info", "Registration successful. Check your email for activate account.");
        }else if (error != null){
            model.addAttribute("error", "Invalid user name or password");
            model.addAttribute("info", "");
        }else {
            model.addAttribute("info", "");
            model.addAttribute("error", null);
        }
        return "signIn";
    }

    @RequestMapping(value = "/user/check", method = RequestMethod.POST)
    @ResponseBody
    public UserConfig signInProcess(@RequestBody String username){
        User user = userService.findByEmail(username);
        UserConfig userConfig = userConfigService.findByUserId(user.getId());
        return userConfig;
    }

    @RequestMapping(value = "/activate/{activationKey}", method = RequestMethod.GET)
    public String activate(@PathVariable Integer activationKey){
        if (userConfigService.findByActivationCode(activationKey).isActivated()){
            return "redirect:/";
        }
        userService.activate(activationKey);
        return "redirect:/?first=1";
    }
}
