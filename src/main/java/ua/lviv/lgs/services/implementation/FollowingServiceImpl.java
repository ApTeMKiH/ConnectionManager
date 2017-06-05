package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Following;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.FollowingRepo;
import ua.lviv.lgs.repositories.UserRepo;
import ua.lviv.lgs.services.FollowingService;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
@Service
public class FollowingServiceImpl implements FollowingService {

    @Autowired
    private FollowingRepo followingRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void add(Following following, String email) {
        following.setUser(userRepo.findByEmail(email));
        followingRepo.save(following);
    }

    @Override
    public void edit(Following following) {
        followingRepo.save(following);
    }

    @Override
    public Following findOne(int id) {
        return followingRepo.findOne(id);
    }

    @Override
    public List<Following> findAllForUser(User user) {
        return followingRepo.findByUser(user);
    }

    @Override
    public void delete(int id) {
        followingRepo.delete(id);
    }

    @Override
    public Following findByUserAndIdFollowing(User user, int id) {
        return followingRepo.findByUserAndIdFollowing(user, id);
    }
}
