package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.entity.*;
import ua.lviv.lgs.services.*;
import ua.lviv.lgs.utill.WhoAreUser;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;
import java.util.*;

/**
 * Created by Артем on 5/9/2017.
 */
@Controller
public class FriendsController {

    @Autowired
    private FollowingService followingService;

    @Autowired
    private FollowerService followerService;

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private UserService userService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private AudioService audioService;

    @Autowired
    private PostsService postsService;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public String getFriends(Principal principal, Model model){
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "friends";
    }

    @RequestMapping(value = "/friends/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFriends(Principal principal){
        User user = userService.findByEmail(principal.getName());
        List<Friends> friendsList = friendsService.findAllForUser(user);
        List<User> users = new ArrayList<>();
        for (Friends friends : friendsList) {
            users.add(userService.findById(friends.getIdFriend()));
        }
        return users;
    }

    @RequestMapping(value = "/friends/followers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFollowers(Principal principal){
        User user = userService.findByEmail(principal.getName());
        List<Follower> followers = followerService.findAllForUser(user);
        List<User> users = new ArrayList<>();
        for (Follower follower : followers) {
            users.add(userService.findById(follower.getIdFollower()));
        }
        return users;
    }

    @RequestMapping(value = "/friends/following", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFollowing(Principal principal){
        User user = userService.findByEmail(principal.getName());
        List<Following> followings = followingService.findAllForUser(user);
        List<User> users = new ArrayList<>();
        for (Following following: followings) {
            users.add(userService.findById(following.getIdFollowing()));
        }
        return users;
    }

    @RequestMapping(value = "/friends/people", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllPeople(Principal principal){
        User currentUser = userService.findByEmail(principal.getName());
        List<User> users = userService.getAll();
        users.removeIf(user -> user.getEmail().equals(principal.getName()));
        Friends friends;
        Follower follower;
        Following following;
        for (int i = 0; i < users.size(); i++) {
            friends = friendsService.findByUserAndIdFriend(currentUser, users.get(i).getId());
            following = followingService.findByUserAndIdFollowing(currentUser, users.get(i).getId());
            follower = followerService.findByUserAndIdFollower(currentUser, users.get(i).getId());
            if (friends != null)
                users.get(i).setWho(WhoAreUser.FRIEND.toString());
            else if ( following != null)
                users.get(i).setWho(WhoAreUser.FOLLOWING.toString());
            else if ( follower != null)
                users.get(i).setWho(WhoAreUser.FOLLOWER.toString());
            else
                users.get(i).setWho(WhoAreUser.NONE.toString());
        }
        return users;
    }

    @RequestMapping(value = "/friends/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void deleteFriend(@PathVariable Integer id, Principal principal){
        friendsService.delete(friendsService.findByUserAndIdFriend(userService.findByEmail(principal.getName()), id).getId());
        friendsService.delete(friendsService.findByUserAndIdFriend(userService.findById(id),userService.findByEmail(principal.getName()).getId()).getId());
        followerService.add(new Follower(id), principal.getName());
        followingService.add(new Following(userService.findByEmail(principal.getName()).getId()), userService.findById(id).getEmail());
    }

    @RequestMapping(value = "/friends/confirm/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void confirmFriend(@PathVariable Integer id, Principal principal){
        followerService.delete(followerService.findByUserAndIdFollower(userService.findByEmail(principal.getName()), id).getId());
        followingService.delete(followingService.findByUserAndIdFollowing(userService.findById(id), userService.findByEmail(principal.getName()).getId()).getId());
        friendsService.add(new Friends(id), principal.getName());
        friendsService.add(new Friends(userService.findByEmail(principal.getName()).getId()), userService.findById(id).getEmail());
    }

    @RequestMapping(value = "/friends/unfollowing/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void unfollowingFriend(@PathVariable Integer id, Principal principal){
        followingService.delete(followingService.findByUserAndIdFollowing(userService.findByEmail(principal.getName()),id).getId());
        followerService.delete(followerService.findByUserAndIdFollower(userService.findById(id), userService.findByEmail(principal.getName()).getId()).getId());

    }

    @RequestMapping(value = "/friends/add/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void addFriend(@PathVariable Integer id, Principal principal){
        followingService.add(new Following(id), principal.getName());
        followerService.add(new Follower(userService.findByEmail(principal.getName()).getId()), userService.findById(id).getEmail());
    }

    @RequestMapping(value = "/friend/profile/{id}", method = RequestMethod.GET)
    public String getFriendProfile(@PathVariable Integer id, Principal principal, Model model){
        User currentUser = userService.findByEmail(principal.getName());
        User user = userService.findById(id);
        informationService.findByUser(user);
        model.addAttribute("information", informationService.findByUser(user));
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("user", user);
        if (friendsService.findByUserAndIdFriend(currentUser,user.getId()) != null){
            model.addAttribute("checkFriend", "friend");
        }else if (followerService.findByUserAndIdFollower(currentUser,user.getId()) != null){
            model.addAttribute("checkFriend", "follower");
        }else if (followingService.findByUserAndIdFollowing(currentUser,user.getId()) != null){
            model.addAttribute("checkFriend", "following");
        }else {
            model.addAttribute("checkFriend", "none");
        }
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
        model.addAttribute("audio", audioService.findAllForUser(user));
        model.addAttribute("friendsSize", friendsService.findAllForUser(userService.findById(id)).size());
        model.addAttribute("photoSize", photoService.findAllForUser(userService.findById(id)).size());
        return "friendProfile";
    }

    @RequestMapping(value = "/friend/{id}/friends", method = RequestMethod.GET)
    public String getAllFriends(@PathVariable Integer id,Principal principal, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "friendsFriend";
    }


}
