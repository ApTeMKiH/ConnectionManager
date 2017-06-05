package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.lviv.lgs.entity.Follower;
import ua.lviv.lgs.entity.Following;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.FollowerService;
import ua.lviv.lgs.services.FollowingService;
import ua.lviv.lgs.services.FriendsService;
import ua.lviv.lgs.services.UserService;
import ua.lviv.lgs.utill.WhoAreUser;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 5/15/2017.
 */
@Controller
public class FriendFriendsController {
    @Autowired
    private FollowingService followingService;

    @Autowired
    private FollowerService followerService;

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/friend/{id}/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFriends(Principal principal, @PathVariable Integer id){
        User currentUser = userService.findByEmail(principal.getName());
        List<Friends> friendsList = friendsService.findAllForUser(userService.findById(id));
        List<User> users = new ArrayList<>();
        for (Friends friends : friendsList) {
            users.add(userService.findById(friends.getIdFriend()));
        }
        for (int i = 0; i < users.size(); i++) {
            if (friendsService.findByUserAndIdFriend(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FRIEND.toString());
            else if ( followingService.findByUserAndIdFollowing(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWING.toString());
            else if ( followerService.findByUserAndIdFollower(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWER.toString());
            else if ( currentUser.getId() == users.get(i).getId()){
                users.get(i).setWho(WhoAreUser.YOU.toString());
            }else {
                users.get(i).setWho(WhoAreUser.NONE.toString());
            }
        }
        return users;
    }

    @RequestMapping(value = "/friend/{id}/followers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFollowers(Principal principal,@PathVariable Integer id){
        User currentUser = userService.findByEmail(principal.getName());
        List<Follower> followers = followerService.findAllForUser(userService.findById(id));
        List<User> users = new ArrayList<>();
        for (Follower follower : followers) {
            users.add(userService.findById(follower.getIdFollower()));
        }
        for (int i = 0; i < users.size(); i++) {
            if (friendsService.findByUserAndIdFriend(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FRIEND.toString());
            else if ( followingService.findByUserAndIdFollowing(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWING.toString());
            else if ( followerService.findByUserAndIdFollower(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWER.toString());
            else if ( currentUser.getId() == users.get(i).getId()){
                users.get(i).setWho(WhoAreUser.YOU.toString());
            }else {
                users.get(i).setWho(WhoAreUser.NONE.toString());
            }
        }
        return users;
    }

    @RequestMapping(value = "/friend/{id}/following", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllFollowing(Principal principal,@PathVariable Integer id){
        User currentUser = userService.findByEmail(principal.getName());
        List<Following> followings = followingService.findAllForUser(userService.findById(id));
        List<User> users = new ArrayList<>();
        for (Following following: followings) {
            users.add(userService.findById(following.getIdFollowing()));
        }
        for (int i = 0; i < users.size(); i++) {
            if (friendsService.findByUserAndIdFriend(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FRIEND.toString());
            else if ( followingService.findByUserAndIdFollowing(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWING.toString());
            else if ( followerService.findByUserAndIdFollower(currentUser, users.get(i).getId()) != null)
                users.get(i).setWho(WhoAreUser.FOLLOWER.toString());
            else if ( currentUser.getId() == users.get(i).getId()){
                users.get(i).setWho(WhoAreUser.YOU.toString());
            }else {
                users.get(i).setWho(WhoAreUser.NONE.toString());
            }
        }
        return users;
    }

}
