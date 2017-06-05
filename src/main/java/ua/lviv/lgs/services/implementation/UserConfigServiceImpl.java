package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.UserConfig;
import ua.lviv.lgs.repositories.UserConfigRepo;
import ua.lviv.lgs.services.UserConfigService;

/**
 * Created by Артем on 5/7/2017.
 */
@Service
public class UserConfigServiceImpl implements UserConfigService {

    @Autowired
    private UserConfigRepo userConfigRepo;

    @Override
    public UserConfig findByActivationCode(int activationCode) {
        return userConfigRepo.findByActivationCode(activationCode);
    }

    public void add(UserConfig userConfig) {
        userConfigRepo.save(userConfig);
    }

    @Override
    public UserConfig findOne(int id) {
        return userConfigRepo.findOne(id);
    }

    @Override
    public UserConfig findByUserId(int id) {
        return userConfigRepo.findByUserId(id);
    }

    public void edit(UserConfig userConfig) {
        userConfigRepo.save(userConfig);
    }
}
