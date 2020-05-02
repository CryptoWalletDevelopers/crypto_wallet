package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.utils.PasswordGenerator;
import com.cryptowallet.utils.UsersRoles;
import com.cryptowallet.utils.ValidateInputData;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
public class UserController {
    private final String VERIFIED = "Your account is verified!";
    private final String NOT_VERIFIED = "Your account is not verified!";
    private final String ACTIVATION_MESSAGE = "A letter was sent to your mail. " +
            "Please follow the link in the letter to create a new password";
    private final String PASSWORD_SAVED ="Your password has been successfully saved!";

    private UserServiceFacade userServiceFacade;
    private UserService userService;
    private ValidateInputData validError;

    @Autowired
    public UserController(UserService userService, UserServiceFacade userServiceFacade) {
        this.userService = userService;
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
    public String addUser(@ModelAttribute(name = "user") User user, Model model, HttpServletRequest request) {
        String password = user.getPassword();
        if (!userService.isUserExist(user.getEmail())) {
            if (!validError.isCorrectValidate(user)) {
                model.addAttribute("user", user);
                model.addAttribute("not_valid", validError.getValidationErrors());
                return "registration";
            }
            user.setPassword(userServiceFacade.passwordEncode(password));
            user.setRole(userServiceFacade.getUserRole());
            user.setToken(userServiceFacade.generateToken());
            userService.saveUser(user);
            userServiceFacade.sendActiveCodeToMail(user);
        } else {
            validError.putValidationErrors("User already exists", "User already exists");
            user.setEmail("");
            user.setLogin("");
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute("not_valid", validError.getValidationErrors());
            return "registration";
        }
        try {
            request.login(user.getEmail(), password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activateUser (Model model, @PathVariable String code)  {
        User user = userService.findByToken(code);
        if(user!=null) {
            user.setApproved(true);
            userService.saveUser(user);
            model.addAttribute("activeMessage", VERIFIED);
            return "index";
        }else {
            model.addAttribute("activeMessage", NOT_VERIFIED);
        return "index";
        }
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
        User user = userService.findByToken(code);
        if(user!=null) {
            model.addAttribute("email", user.getEmail());
            return "newPassword";
        }else {
            model.addAttribute("activeMessage", NOT_VERIFIED);
        }
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
                user.setPassword(userServiceFacade.passwordEncode(password));
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
