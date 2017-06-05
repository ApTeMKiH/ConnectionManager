package ua.lviv.lgs.services;

import com.restfb.types.User;
import ua.lviv.lgs.entity.UserConfig;

/**
 * Created by Артем on 5/7/2017.
 */
public interface UserConfigService {
    void add(UserConfig userConfig);

    void edit(UserConfig userConfig);

    UserConfig findByActivationCode(int activationCode);

    UserConfig findOne(int id);

    UserConfig findByUserId(int id);


}
