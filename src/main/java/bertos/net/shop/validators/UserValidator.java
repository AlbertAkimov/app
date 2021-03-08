package bertos.net.shop.validators;

import bertos.net.shop.model.access.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if(user.getUsername().length() < 8 || user.getUsername().length() > 32)
            errors.rejectValue("username", "Size.userForm.username");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "Required");

        if(!user.getPassword().equals(user.getPasswordConfirm()))
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");

    }
}
