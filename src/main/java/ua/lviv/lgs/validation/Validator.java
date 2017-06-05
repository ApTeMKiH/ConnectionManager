package ua.lviv.lgs.validation;

/**
 * Created by Артем on 5/7/2017.
 */
public interface Validator {

    String NAME_REGEX = "^[a-zA-Zа-яА-ЯіІёЁїЇ]{1,20}$";
    String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,16}$";
    String PHOTO_REGEX = "^.+(jpg|bmp|gif|png|jpeg)$";
    String AUDIO_REGEX = "^.+(mp3)$";

    void validate(Object o);
}
