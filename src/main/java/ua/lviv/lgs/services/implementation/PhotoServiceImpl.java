package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.PhotoRepo;
import ua.lviv.lgs.services.PhotoService;
import ua.lviv.lgs.validation.implementation.PhotoValidation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/12/2017.
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepo photoRepo;

    @Override
    public void add(Photo photo, User user) {
            photo.setUser(user);
            photoRepo.save(photo);
    }

    @Override
    public void addAvatar(Photo photo) {
        photo.setAvatar(true);
        photoRepo.save(photo);
    }

    @Override
    public Photo findByPath(String path) {
        return photoRepo.findByPath(path);
    }

    @Override
    public void edit(Photo photo) {
        photoRepo.save(photo);
    }

    @Override
    public Photo findOne(int id) {
        return photoRepo.findOne(id);
    }

    @Override
    public List<Photo> findAllForUser(User user) {
        return photoRepo.findByUser(user);
    }

    @Override
    public Photo findAvatar(User user) {
        return photoRepo.findByUserAndAvatar(user, true);
    }

    @Override
    public void delete(int id) {
        File file = new File("D:/Курси/Project/ConnectionManager/src/main/webapp"+photoRepo.findOne(id).getPath());
        file.delete();
        photoRepo.delete(id);
    }
}
