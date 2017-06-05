package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.UserConfig;

/**
 * Created by Артем on 5/7/2017.
 */
public interface UserConfigRepo extends JpaRepository<UserConfig, Integer> {

    UserConfig findByActivationCode(int activationCode);

    UserConfig findByUserId(int id);
}
