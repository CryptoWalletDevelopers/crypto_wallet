package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.utils.ValidateInputData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;

@Log4j2
@Controller
public class UserController {
    private final int HOURS = 2;
    private final long EXPIRED_TIME = 60 * 60 * 1000 * HOURS;

    private final String VERIFIED = "Your account is verified!";
    private final String NOT_VERIFIED = "Your account is not verified!";
    private final String TOKEN_EXPIRED = "Your token is expired! We have sent you an email with a new token.";
    private final String ACTIVATION_MESSAGE = "A letter was sent to your mail. " +
            "Please follow the link in the letter to create a new password";
    private final String PASSWORD_SAVED = "Your password has been successfully saved!";
    private final String MODEL_ATTRIBUTE = "activeMessage";
    private final String ERROR_ATTRIBUTE = "not_valid";
    private final String USER_EXIST = "User already exists";
    private final String USER_DONT_EXIST = "User dont exist";
    private UserServiceFacade userServiceFacade;
    private ValidateInputData validError;

    @Autowired
    public UserController(UserServiceFacade userServiceFacade) {
        this.userServiceFacade = userServiceFacade;
        this.validError = new ValidateInputData();
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("create_user")
    @Transactional
    public String createUser(@ModelAttribute(name = "user") User user, Model model, HttpServletRequest request) {
        String password = user.getPassword();

        if (!userServiceFacade.isUserExist(user.getLogin())) {
            if (!validError.isCorrectValidate(user)) {
                model.addAttribute("user", user);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
                return "registration";
            }
            userServiceFacade.createNewUser(user);
        } else {
            validError.putValidationErrors(USER_EXIST, USER_EXIST);
            userServiceFacade.clearFields(user);
            model.addAttribute("user", user);
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "registration";
        }

        try {
            request.login(user.getLogin(), password);
        } catch (ServletException e) {
            log.info("Cant authority new User with login = " + user.getLogin());
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(Model model, @PathVariable String code) {
        User user = userServiceFacade.findByToken(code);
        if (user != null) {
            if (user.getDate_exp().getTime() + EXPIRED_TIME > new Date().getTime()) {
                user.setApproved(true);
                userServiceFacade.saveUser(user);
                model.addAttribute(MODEL_ATTRIBUTE, VERIFIED);
            } else {
                model.addAttribute(MODEL_ATTRIBUTE, TOKEN_EXPIRED);
                userServiceFacade.sendActiveCodeToMail(user);
            }
        } else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        }
        return "index";
    }

    @GetMapping("/restorePassword")
    public String getRestorePassword() {
        return "restorePassword";
    }

    @PostMapping("/restorePassword")
    public String sendMailRestorePassword(Model model, @RequestParam(name = "login") String login) {
        validError.clearValidate();
//        if (validError.isLoginValid(login)) { // А есть ли смысл проверять валидность поля для уже существующего пользователя? Ведь любая некорректная инф. просто не найдент пользователя.
            if (userServiceFacade.isUserExist(login.toLowerCase())) {
                userServiceFacade.restorePassword(login);
                model.addAttribute(MODEL_ATTRIBUTE, ACTIVATION_MESSAGE);
                return "index";
            } else {
                validError.putValidationErrors(USER_DONT_EXIST, USER_DONT_EXIST);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
                return "restorePassword";
            }
//        } else {
//            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
//            return "restorePassword";
//        }
    }

    @GetMapping("/restore/{code}")
    public String restoreUser(Model model, @PathVariable String code) {
        User user = userServiceFacade.findByToken(code);
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            return "newPassword";
        } else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        }
        return "index";
    }

    @PostMapping("/newPassword")
    public String saveNewPassword(Model model,
                                  @RequestParam(name = "password") String password,
                                  @RequestParam(name = "email") String email) {
        if (userServiceFacade.isUserExist(email.toLowerCase())) {
            User user = userServiceFacade.authorize(email);
            validError.clearValidate();
            if (!validError.isPasswordValid(password)) {
                model.addAttribute("login", email);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors().values());
                return "newPassword";
            } else {
                user.setPassword(userServiceFacade.passwordEncode(password));
                userServiceFacade.saveUser(user);
                model.addAttribute(MODEL_ATTRIBUTE, PASSWORD_SAVED);
                return "index";
            }
        } else {
            model.addAttribute("email", email);
            validError.putValidationErrors(USER_DONT_EXIST, USER_DONT_EXIST);
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "newPassword";
        }
    }

    @GetMapping("/userProfile")
    public String userProfile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/";
        }
        User user = userServiceFacade.findByLogin(principal.getName());
        model.addAttribute("user", user);
        return "userProfile";
    }

    @GetMapping("/resendTokenToActivation")
    public String resendTokenToActivation(Model model, Principal principal) {
        User user = userServiceFacade.findByLogin(principal.getName());
        userServiceFacade.resendTokenToActivation(user); //  Мне кажется можно использовать sendActiveCodeToMail()
        model.addAttribute("user", user);
        return "userProfile";
    }
}
