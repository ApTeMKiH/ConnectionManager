package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Information;
import ua.lviv.lgs.entity.User;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Артем on 5/1/2017.
 */
public interface InformationService {
    void add(Information information, User user);

    void edit(Information information);

    Information findById(int id);

    void delete(int id);

    Information findByUser(User user);


}
