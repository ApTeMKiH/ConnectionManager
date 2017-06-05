package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.DialogsRepo;
import ua.lviv.lgs.services.DialogService;

import java.util.List;

/**
 * Created by Артем on 5/18/2017.
 */
@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogsRepo dialogsRepo;

    @Override
    public void add(Dialogs dialogs) {
        dialogsRepo.save(dialogs);
    }

    @Override
    public void edit(Dialogs dialogs) {
        dialogsRepo.save(dialogs);
    }

    @Override
    public Dialogs findOne(int id) {
        return dialogsRepo.findOne(id);
    }

    @Override
    public List<Dialogs> findByUserFrom(User userFrom) {
        return dialogsRepo.findByUserFrom(userFrom);
    }

    @Override
    public List<Dialogs> findByUserTo(User userTo) {
        return dialogsRepo.findByUserTo(userTo);
    }

    @Override
    public Dialogs findByUserFromAndUserTo(User userFrom, User userTo) {
        return dialogsRepo.findByUserFromAndUserTo(userFrom, userTo);
    }

    @Override
    public void delete(int id) {
        dialogsRepo.delete(id);
    }
}
