package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.FriendsRepo;
import ua.lviv.lgs.repositories.UserRepo;
import ua.lviv.lgs.services.FriendsService;

import java.util.List;

/**
 * Created by Артем on 5/9/2017.
 */
@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsRepo friendsRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void add(Friends friends, String email) {
        friends.setUser(userRepo.findByEmail(email));
        friendsRepo.save(friends);
    }

    @Override
    public void edit(Friends friends) {
        friendsRepo.save(friends);
    }

    @Override
    public Friends findOne(int id) {
        return friendsRepo.findOne(id);
    }

    @Override
    public List<Friends> findAllForUser(User user) {
        return friendsRepo.findByUser(user);
    }

    @Override
    public void delete(int id) {
        friendsRepo.delete(id);
    }

    @Override
    public Friends findByUserAndIdFriend(User user, int id) {
        return friendsRepo.findByUserAndIdFriend(user, id);
    }
}
