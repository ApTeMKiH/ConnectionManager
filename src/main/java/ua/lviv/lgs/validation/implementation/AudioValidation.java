package ua.lviv.lgs.validation.implementation;


import org.springframework.stereotype.Component;
import ua.lviv.lgs.exceptions.ValidationException;
import ua.lviv.lgs.utill.ValidationMessages;
import ua.lviv.lgs.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артем on 6/5/2017.
 */
@Component
public class AudioValidation implements Validator{

    @Override
    public void validate(Object o) {
        String path = (String) o;
        Pattern pattern = Pattern.compile(Validator.AUDIO_REGEX);
        Matcher matcher = pattern.matcher(path);
        if (!matcher.matches()){
            throw new ValidationException(ValidationMessages.INVALID_AUDIO);
        }
    }
}
