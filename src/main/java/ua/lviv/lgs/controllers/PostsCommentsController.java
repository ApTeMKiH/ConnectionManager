package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.entity.PostsComments;
import ua.lviv.lgs.services.PostsCommentsService;
import ua.lviv.lgs.services.PostsService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

/**
 * Created by Артем on 5/14/2017.
 */
@Controller
public class PostsCommentsController {
    @Autowired
    private PostsCommentsService postsCommentsService;

    @Autowired
    private PostsService postsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/post/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PostsComments> getAll(@PathVariable Integer id){
        List<PostsComments> postsCommentsList = postsCommentsService.findAllForPost(postsService.findOne(id));
        Collections.reverse(postsCommentsList);
        return postsCommentsList;
    }

    @RequestMapping(value = "/post/comments/add/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void addComment(@PathVariable Integer id, @RequestBody PostsComments postsComments, Principal principal){
        postsComments.setUser(userService.findByEmail(principal.getName()));
        postsCommentsService.add(postsComments, postsService.findOne(id));
    }

    @RequestMapping(value = "/post/comments/edit/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void editComment(@PathVariable Integer id, @RequestBody PostsComments postsComments){
        PostsComments postsComments1 = postsCommentsService.findOne(id);
        postsComments1.setText(postsComments.getText());
        postsCommentsService.edit(postsComments1);
    }

    @RequestMapping(value = "/post/comments/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteComment(@PathVariable Integer id){
        postsCommentsService.delete(id);
    }
}
