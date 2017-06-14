package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.entity.Audio;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.AudioService;
import ua.lviv.lgs.services.UserService;
import ua.lviv.lgs.validation.implementation.AudioValidation;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

/**
 * Created by Артем on 5/13/2017.
 */
@Controller
public class AudioController {

    @Autowired
    private AudioService audioService;

    @Autowired
    private UserService userService;

    @Autowired
    private AudioValidation audioValidation;

    @RequestMapping(value = "/audio", method = RequestMethod.GET)
    public String getAudio(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        List<Audio> audios = audioService.findAllForUser(userService.findByEmail(principal.getName()));
        Collections.reverse(audios);
        model.addAttribute("audio", audios);
        return "audio";
    }

    @RequestMapping(value = "/audio/check", method = RequestMethod.POST)
    @ResponseBody
    public void checkAudio(@RequestBody String path){
        audioValidation.validate(path);
    }

    @RequestMapping(value = "/friend/{id}/audio", method = RequestMethod.GET)
    public String getAudio(Principal principal, Model model,@PathVariable Integer id){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        model.addAttribute("user", userService.findById(id));
        List<Audio> audios = audioService.findAllForUser(userService.findById(id));
        Collections.reverse(audios);
        model.addAttribute("audio", audios);
        return "audioFriend";
    }

    @RequestMapping(value = "/audio/add", method = RequestMethod.POST)
    public String addAudio(@RequestParam("audio")MultipartFile multipartFile, Principal principal){
        User user = userService.findByEmail(principal.getName());
            if (multipartFile!=null){
                try {
                    //String path = "D:/Курси/Project/ConnectionManager/src/main/webapp/resources/audio/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    String path2 = "/resources/audio/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("");
                    path = path.replace('\\','/').substring(0,path.length()-38)+"src/main/webapp/resources/audio/user"+user.getId()+"/"+multipartFile.getOriginalFilename();
                    File file = new File(path);
                    if (!(file.isDirectory())){
                        file.mkdirs();
                    }
                    audioService.add(new Audio(path2, multipartFile.getOriginalFilename()), user);
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return "redirect:/audio";
    }

    @RequestMapping(value = "/audio/delete/{id}", method = RequestMethod.GET)
    public String deleteAudio(@PathVariable Integer id){
        audioService.delete(id);
        return "redirect:/audio";
    }

    @RequestMapping(value = "/radio", method = RequestMethod.GET)
    public String getRadio(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "radio";
    }
}
