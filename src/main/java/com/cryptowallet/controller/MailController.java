package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.UserService;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.utils.ValidateInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MailController {
    private final String VERIFIED = "Your account is verified!";
    private final String NOT_VERIFIED = "Your account is not verified!";
    private final String ACTIVATION_MESSAGE = "A letter was sent to your mail. " +
            "Please follow the link in the letter to create a new password";
    private final String PASSWORD_SAVED ="Your password has been successfully saved!";

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private ValidateInputData validError;
    private UserServiceFacade userServiceFacade;

    @Autowired
    public MailController(UserService userService, PasswordEncoder passwordEncoder, UserServiceFacade userServiceFacade) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.validError = new ValidateInputData();
        this.userServiceFacade = userServiceFacade;
    }

    @GetMapping("/activate/{code}")
    public String activateUser (Model model, @PathVariable String code)  {
//        User user = userService.findByActivationCode(code);
//        if(user!=null) {
//            user.setApproved(true);
//            userService.saveUser(user);
//            model.addAttribute("activeMessage", VERIFIED);
//            return "index";
//        }else {
//            model.addAttribute("activeMessage", NOT_VERIFIED);
            return "index";
//        }
    }

    @GetMapping("/restorePassword")
    public String getRestorePassword() {
        return "restorePassword";
    }

    @PostMapping("/restorePassword")
    public String sendMailRestorePassword (Model model, @RequestParam(name = "email") String email) {
        validError.clearValidate();
        if(validError.isEmailValid(email)) {
            if (userService.isUserExist(email)){
                userServiceFacade.restorePassword(email);
                model.addAttribute("activeMessage", ACTIVATION_MESSAGE);
                return "index";
            }else {
                validError.putValidationErrors("User dont exist", "User dont exist");
                model.addAttribute("not_valid", validError.getValidationErrors());
                return "restorePassword";
            }
        }else {
            model.addAttribute("not_valid", validError.getValidationErrors());
            return "restorePassword";
        }
    }

    @GetMapping("/restore/{code}")
    public String restoreUser (Model model, @PathVariable String code) {
//        User user = userService.findByActivationCode(code);
//        if(user!=null) {
//            model.addAttribute("email", user.getEmail());
//            return "newPassword";
//        }else {
//            model.addAttribute("activeMessage", NOT_VERIFIED);
//        }
        return "index";
    }

    @PostMapping("/newPassword")
    public String saveNewPassword (Model model, @RequestParam(name = "password") String password,
                                   @RequestParam(name = "login") String login) {
        User user = userService.findByLogin(login);
        if (user!=null){
            validError.clearValidate();
            if (!validError.isPasswordValid(password)) {
                model.addAttribute("login", login);
                model.addAttribute("not_valid", validError.getValidationErrors().values());
                return "newPassword";
            }else {
                user.setPassword(passwordEncoder.encode(password));

                userService.saveUser(user);
                model.addAttribute("activeMessage", PASSWORD_SAVED);
                return "index";
            }
        }else {
            model.addAttribute("login", login);
            validError.putValidationErrors("User dont exist", "User dont exist");
            model.addAttribute("not_valid", validError.getValidationErrors());
            return "newPassword";
        }
    }
}
