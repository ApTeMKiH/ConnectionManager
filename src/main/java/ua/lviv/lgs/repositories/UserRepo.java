package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.lgs.entity.User;

import java.util.List;


/**
 * Created by Артем on 5/7/2017.
 */
public interface UserRepo extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.name like %:name% or u.surname like %:name%")
    List<User> searchPeople(@Param("name") String name);

    User findByEmail(String email);

}
