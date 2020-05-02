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
import java.security.Principal;
import java.util.UUID;


@Controller
public class UserController {
    private final String VERIFIED = "Your account is verified!";
    private final String NOT_VERIFIED = "Your account is not verified!";
    private final String ACTIVATION_MESSAGE = "A letter was sent to your mail. " +
            "Please follow the link in the letter to create a new password";
    private final String PASSWORD_SAVED ="Your password has been successfully saved!";
    private final String MODEL_ATTRIBUTE = "activeMessage";
    private final String ERROR_ATTRIBUTE = "not_valid";

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
    public String addUser(@ModelAttribute(name = "user") User user, Model model, HttpServletRequest request) {
        String password = user.getPassword();
        if (!userServiceFacade.isUserExist(user.getLogin())) {
            if (!validError.isCorrectValidate(user)) {
                model.addAttribute("user", user);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
                return "registration";
            }
            user.setPassword(userServiceFacade.passwordEncode(password));
            user.setRole(userServiceFacade.getUserRole());
            user.setToken(userServiceFacade.generateToken());
            userServiceFacade.saveUser(user);
            userServiceFacade.sendActiveCodeToMail(user);
        } else {
            validError.putValidationErrors("User already exists", "User already exists");
            user.setEmail("");
            user.setLogin("");
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
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
        User user = userServiceFacade.findByToken(code);
        if(user!=null) {
            user.setApproved(true);
            userServiceFacade.saveUser(user);
            model.addAttribute(MODEL_ATTRIBUTE, VERIFIED);
            return "index";
        }else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        return "index";
        }
    }

    @GetMapping("/restorePassword")
    public String getRestorePassword() {
        return "restorePassword";
    }

    @PostMapping("/restorePassword")
    public String sendMailRestorePassword (Model model, @RequestParam(name = "login") String login) {
        validError.clearValidate();
        if(validError.isLoginValid(login)) {
            if (userServiceFacade.isUserExist(login)){
                userServiceFacade.restorePassword(login);
                model.addAttribute(MODEL_ATTRIBUTE, ACTIVATION_MESSAGE);
                return "index";
            }else {
                validError.putValidationErrors("User dont exist", "User dont exist");
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
                return "restorePassword";
            }
        }else {
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "restorePassword";
        }
    }

    @GetMapping("/restore/{code}")
    public String restoreUser (Model model, @PathVariable String code) {
        User user = userServiceFacade.findByToken(code);
        if(user!=null) {
            model.addAttribute("email", user.getEmail());
            return "newPassword";
        }else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        }
        return "index";
    }

    @PostMapping("/newPassword")
    public String saveNewPassword (Model model, @RequestParam(name = "password") String password,
                                   @RequestParam(name = "login") String login) {
        if (userServiceFacade.isUserExist(login)){
            User user = userServiceFacade.findByLogin(login);
            validError.clearValidate();
            if (!validError.isPasswordValid(password)) {
                model.addAttribute("login", login);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors().values());
                return "newPassword";
            }else {
                user.setPassword(userServiceFacade.passwordEncode(password));
                userServiceFacade.saveUser(user);
                model.addAttribute(MODEL_ATTRIBUTE, PASSWORD_SAVED);
                return "index";
            }
        }else {
            model.addAttribute("login", login);
            validError.putValidationErrors("User dont exist", "User dont exist");
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "newPassword";
        }
    }

    @GetMapping ("/userProfile")
    public String userProfile (Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/";
        }
        System.out.println("principal.getName()  " + principal.getName());
        User user = userServiceFacade.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "userProfile";
    }

    @PostMapping ("/resendTokenToActivation")
    public String resendTokenToActivation () {
        return "userProfile";
    }

}
