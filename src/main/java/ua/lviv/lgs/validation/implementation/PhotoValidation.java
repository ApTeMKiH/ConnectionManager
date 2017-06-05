package ua.lviv.lgs.validation.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.lgs.entity.Photo;
import ua.lviv.lgs.exceptions.ValidationException;
import ua.lviv.lgs.utill.ValidationMessages;
import ua.lviv.lgs.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артем on 6/4/2017.
 */
@Component
public class PhotoValidation implements Validator {

    @Override
    public void validate(Object o) {
        String path = (String) o;
        Pattern pattern = Pattern.compile(Validator.PHOTO_REGEX);
        Matcher matcher = pattern.matcher(path);
        if (!matcher.matches()){
            throw new ValidationException(ValidationMessages.INVALID_PHOTO);
        }
    }
}
