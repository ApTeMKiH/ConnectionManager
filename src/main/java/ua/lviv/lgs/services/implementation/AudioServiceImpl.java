package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Audio;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.AudioRepo;
import ua.lviv.lgs.services.AudioService;

import java.io.File;
import java.util.List;

/**
 * Created by Артем on 5/13/2017.
 */
@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioRepo audioRepo;

    @Override
    public void add(Audio audio, User user) {
        audio.setUser(user);
        audioRepo.save(audio);
    }

    @Override
    public Audio findOne(int id) {
        return audioRepo.findOne(id);
    }

    @Override
    public void edit(Audio audio) {
        audioRepo.save(audio);
    }

    @Override
    public List<Audio> findAllForUser(User user) {
        return audioRepo.findByUser(user);
    }

    @Override
    public void delete(int id) {
        File file = new File("D:/Курси/Project/ConnectionManager/src/main/webapp"+audioRepo.findOne(id).getPath());
        file.delete();
        audioRepo.delete(id);
    }
}
