package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Audio;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/13/2017.
 */
public interface AudioService {

    void add(Audio audio, User user);

    void edit(Audio audio);

    Audio findOne(int id);

    List<Audio> findAllForUser(User user);

    void delete(int id);
}
