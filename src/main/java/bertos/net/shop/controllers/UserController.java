package bertos.net.shop.controllers;

import bertos.net.shop.model.User;
import bertos.net.shop.security.SecurityService;
import bertos.net.shop.services.UserServiceImp;
import bertos.net.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @Authot: Albert Akimov
 * @Date: 29.04.2020
 * @Description:
 */

@Controller
public class UserController {

    private final UserServiceImp userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @Autowired
    public UserController(UserServiceImp userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        User user = userService.findByUsername(userForm.getUsername());

        if(user != null)
            bindingResult.rejectValue("username", "Username.already.exist");

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.register(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Неправельное имя пользователя или пароль.");

        if (logout != null)
            model.addAttribute("message", "Вы вышли из своей учётной записи");

        return "login";
    }

    @GetMapping({"/", "/main"})
    public String main(Model model) {
        return "main";
    }

}
