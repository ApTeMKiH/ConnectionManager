package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Information;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.InformationRepo;
import ua.lviv.lgs.services.InformationService;
import ua.lviv.lgs.services.UserService;

/**
 * Created by Артем on 5/1/2017.
 */
@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    private InformationRepo informationRepo;

    @Autowired
    private UserService userService;

    public void add(Information information, User user) {
        information.setUser(user);
        informationRepo.save(information);
        user.setInformation(information);
        userService.edit(user);
    }

    public void edit(Information information) {
        informationRepo.save(information);
    }

    public Information findById(int id) {
        return informationRepo.findOne(id);
    }

    public void delete(int id) {
        informationRepo.delete(id);
    }

    @Override
    public Information findByUser(User user) {
        return informationRepo.findByUser(user);
    }
}
