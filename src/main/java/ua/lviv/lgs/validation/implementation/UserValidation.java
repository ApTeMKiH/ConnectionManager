package ua.lviv.lgs.validation.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.exceptions.ValidationException;
import ua.lviv.lgs.services.UserService;
import ua.lviv.lgs.utill.ValidationMessages;
import ua.lviv.lgs.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артем on 5/7/2017.
 */
@Component
public class UserValidation implements Validator {

    @Autowired
    private UserService userService;

    public void validate(Object o) {
        User user = (User) o;
        User user2 = userService.findByEmail(user.getEmail());
        Pattern pattern = Pattern.compile(Validator.NAME_REGEX);
        Pattern patternEmail = Pattern.compile(Validator.EMAIL_REGEX);
        Pattern patternPassword = Pattern.compile(Validator.PASSWORD_REGEX);
        Matcher matcherPassword = patternPassword.matcher(user.getPassword());
        Matcher matcherName = pattern.matcher(user.getName());
        Matcher matcherSurname = pattern.matcher(user.getSurname());
        Matcher matcherEmail = patternEmail.matcher(user.getEmail());

        if (user.getName().isEmpty() || !(matcherName.matches())){
            throw new ValidationException(ValidationMessages.INVALID_USER_NAME);
        }
        if (user.getSurname().isEmpty() || !(matcherSurname.matches())){
            throw new ValidationException(ValidationMessages.INVALID_USER_SECOND_NAME);
        }
        if (user.getEmail().isEmpty() || !(matcherEmail.matches())){
            throw new ValidationException(ValidationMessages.INVALID_USER_EMAIL);
        }else if (user2 != null){
            throw new ValidationException(ValidationMessages.ACCOUNT_ALREADY_EXIST);
        }
        if (user.getPassword().isEmpty() || !(matcherPassword.matches())){
            throw new ValidationException(ValidationMessages.INVALID_USER_PASSWORD);
        }
    }
}
