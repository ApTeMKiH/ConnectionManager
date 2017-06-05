package ua.lviv.lgs.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import ua.lviv.lgs.entity.Information;

/**
 * Created by Артем on 5/22/2017.
 */
@Component
public class InformationValidator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Information.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
       /* Information information = (Information) o;
        ValidationUtils.rejectIfEmpty(errors, "phone", "invalid.phone");
        ValidationUtils.rejectIfEmpty(errors, "interests", "invalid.interest");
        ValidationUtils.rejectIfEmpty(errors, "socialStatus", "invalid.social");*/
    }
}
