package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Follower;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.FollowerRepo;
import ua.lviv.lgs.repositories.UserRepo;
import ua.lviv.lgs.services.FollowerService;

import java.util.List;

/**
 * Created by Артем on 5/11/2017.
 */
@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerRepo followerRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void add(Follower follower, String email) {
        follower.setUser(userRepo.findByEmail(email));
        followerRepo.save(follower);
    }

    @Override
    public void edit(Follower follower) {
        followerRepo.save(follower);
    }

    @Override
    public Follower findOne(int id) {
        return followerRepo.findOne(id);
    }

    @Override
    public List<Follower> findAllForUser(User user) {
        return followerRepo.findByUser(user);
    }

    @Override
    public void delete(int id) {
        followerRepo.delete(id);
    }

    @Override
    public Follower findByUserAndIdFollower(User user, int id) {
        return followerRepo.findByUserAndIdFollower(user, id);
    }
}
