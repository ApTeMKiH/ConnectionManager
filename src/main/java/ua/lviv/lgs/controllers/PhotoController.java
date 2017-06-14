package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.PhotoService;
import ua.lviv.lgs.services.UserService;
import ua.lviv.lgs.utill.ValidationMessages;
import ua.lviv.lgs.validation.implementation.PhotoValidation;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/12/2017.
 */
@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserService userService;

    @Autowired
    private PhotoValidation photoValidation;

    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public String getPhoto(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        List<Photo> photos = photoService.findAllForUser(userService.findByEmail(principal.getName()));
        Collections.reverse(photos);
        model.addAttribute("photos", photos);
        return "photo";
    }

    @RequestMapping(value = "/friend/{id}/photo", method = RequestMethod.GET)
    public String getPhoto(Principal principal, Model model, @PathVariable Integer id){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        model.addAttribute("user", userService.findById(id));
        List<Photo> photos = photoService.findAllForUser(userService.findById(id));
        Collections.reverse(photos);
        model.addAttribute("photos", photos);
        return "photoFriend";
    }

    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    public String addPhoto(Principal principal, @RequestParam("image")MultipartFile multipartFile, HttpRequestHandler request){
        User user = userService.findByEmail(principal.getName());
            if (multipartFile!=null){
                try {
                    //String path = "D:/Курси/Project/ConnectionManager/src/main/webapp/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    String path2 = "/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("");
                    path = path.replace('\\','/').substring(0,path.length()-38)+"src/main/webapp/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    File file = new File(path);
                    if (!(file.isDirectory())){
                        file.mkdirs();
                    }
                    photoService.add(new Photo(path2, new Date()), user);
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "photo";
    }

    @RequestMapping(value = "/photo/check", method = RequestMethod.POST)
    @ResponseBody
    public void checkPhoto(@RequestBody String path){
        photoValidation.validate(path);
    }

    @RequestMapping(value = "/add/avatar", method = RequestMethod.POST)
    public String addAvatar(@RequestParam("image")MultipartFile multipartFile, Principal principal){
        User user = userService.findByEmail(principal.getName());
        try {
            //String path = "D:/Курси/Project/ConnectionManager/src/main/webapp/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
            String path2 = "/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
            String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("");
            path = path.replace('\\','/').substring(0,path.length()-38)+"src/main/webapp/resources/photo/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
            File file = new File(path);
            if (!(file.isDirectory())){
                file.mkdirs();
            }
            multipartFile.transferTo(file);
            Photo photo = new Photo(path2, new Date());
            photo.setUser(user);
            Photo photo1 = photoService.findAvatar(user);
            if (photo1 != null){
                photo1.setAvatar(false);
                user.setAvatarPath(photo.getPath());
                userService.edit(user);
                photoService.edit(photo1);
                photoService.addAvatar(photo);
            } else {
                user.setAvatarPath(photo.getPath());
                userService.edit(user);
                photoService.addAvatar(photo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/set/avatar/{id}", method = RequestMethod.GET)
    public String setAvatar(@PathVariable Integer id, Principal principal){
        User user = userService.findByEmail(principal.getName());
        Photo photo = photoService.findOne(id);
        Photo photo1 = photoService.findAvatar(user);
        if (photo1 != null){
            photo1.setAvatar(false);
            user.setAvatarPath(photo.getPath());
            userService.edit(user);
            photoService.edit(photo1);
            photoService.addAvatar(photo);
        } else {
            user.setAvatarPath(photo.getPath());
            userService.edit(user);
            photoService.addAvatar(photo);
        }
        return "redirect:/photo";
    }

    @RequestMapping(value = "/delete/avatar", method = RequestMethod.GET)
    public String deleteAvatar(Principal principal){
        User user = userService.findByEmail(principal.getName());
        Photo photo = photoService.findAvatar(user);
        photo.setAvatar(false);
        user.setAvatarPath(ValidationMessages.AVATAR_DEFAULT_PATH);
        userService.edit(user);
        photoService.edit(photo);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/image/{id}", method = RequestMethod.GET)
    public String deleteImage(@PathVariable Integer id, Principal principal){
        Photo photo = photoService.findOne(id);
        if (photo.isAvatar()){
            User user = userService.findByEmail(principal.getName());
            user.setAvatarPath(ValidationMessages.AVATAR_DEFAULT_PATH);
            userService.edit(user);
            photoService.delete(id);
        }else {
            photoService.delete(id);
        }
        return "redirect:/photo";
    }
}
