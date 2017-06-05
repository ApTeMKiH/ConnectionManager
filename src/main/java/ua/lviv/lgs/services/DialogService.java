package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Dialogs;
import ua.lviv.lgs.entity.User;

import java.util.List;

/**
 * Created by Артем on 5/18/2017.
 */
public interface DialogService {

     void add(Dialogs dialogs);

     void edit(Dialogs dialogs);

     Dialogs findOne(int id);

    List<Dialogs> findByUserFrom(User userFrom);

    List<Dialogs> findByUserTo(User userTo);

     Dialogs findByUserFromAndUserTo(User userFrom, User userTo);

     void delete(int id);

}
