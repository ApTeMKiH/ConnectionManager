package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.services.PostsService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;

/**
 * Created by Артем on 5/14/2017.
 */
@Controller
public class PostsController {
    @Autowired
    private PostsService postsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/posts/add", method = RequestMethod.POST)
    public String addPost(Principal principal, @ModelAttribute Posts posts){
        postsService.add(posts, userService.findByEmail(principal.getName()));
        return "redirect:/";
    }

    @RequestMapping(value = "/posts/add/{id}", method = RequestMethod.POST)
    public String addPost(@PathVariable Integer id, Principal principal, @ModelAttribute Posts posts){
        postsService.add(posts, userService.findByEmail(principal.getName()), userService.findById(id));
        return "redirect:/friend/profile/"+id;
    }

    @RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Integer id){
        postsService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void editPost(@PathVariable Integer id, @RequestBody Posts posts){
        Posts posts1 = postsService.findOne(id);
        posts1.setText(posts.getText());
        postsService.edit(posts1);
    }
}
