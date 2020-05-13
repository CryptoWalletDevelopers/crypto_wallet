package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacadeImpl;
import com.cryptowallet.utils.ValidateInputData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
public class SecurityUserControllerImpl implements SecurityUserController {
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

    private final UserServiceFacadeImpl userServiceFacadeImpl;
    private final ValidateInputData validError;

    @Autowired
    public SecurityUserControllerImpl(UserServiceFacadeImpl userServiceFacadeImpl) {
        this.userServiceFacadeImpl = userServiceFacadeImpl;
        this.validError = new ValidateInputData();
    }

    @Override
    @GetMapping("/sign_up")
    public String signUp(@NonNull Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @Override
    @PostMapping("create_user")
    @Transactional
    public String createUser(@ModelAttribute(name = "user") @NonNull User user, Model model, HttpServletRequest request) {
        String password = user.getPassword();
        validError.verifyUserCorrectness(user, userServiceFacadeImpl);
        if (!validError.isEmpty()){
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "registration";
        }
        userServiceFacadeImpl.createNewUser(user, password, request);
        return "redirect:/";
    }

    @Override
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @Override
    @GetMapping("/activate/{code}")
    public String activateUser(Model model, @PathVariable String code) {
        final User user = userServiceFacadeImpl.findByToken(code);
        if (user != null) {
            if (user.getDateExpired().getTime() + EXPIRED_TIME > new Date().getTime()) {
                userServiceFacadeImpl.activateUser(user);
                model.addAttribute(MODEL_ATTRIBUTE, VERIFIED);
            } else {
                model.addAttribute(MODEL_ATTRIBUTE, TOKEN_EXPIRED);
                userServiceFacadeImpl.sendActiveCodeToMail(user);
            }
        } else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        }
        return "index";
    }

    @Override
    @GetMapping("/restorePassword")
    public String getRestorePassword() {
        return "restorePassword";
    }

    @Override
    @PostMapping("/restorePassword")
    public String sendMailRestorePassword(Model model, @RequestParam(name = "login") String login) {
        validError.clearValidate();
        if (validError.isLoginValid(login)) {
            if (userServiceFacadeImpl.isUserExist(login.toLowerCase())) {
                userServiceFacadeImpl.restorePassword(login);
                model.addAttribute(MODEL_ATTRIBUTE, ACTIVATION_MESSAGE);
                return "index";
            } else {
                validError.putValidationErrors(USER_DONT_EXIST, USER_DONT_EXIST);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
                return "restorePassword";
            }
        } else {
            model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors());
            return "restorePassword";
        }
    }

    @Override
    @GetMapping("/restore/{code}")
    public String restoreUser(Model model, @PathVariable String code) {
        User user = userServiceFacadeImpl.findByToken(code);
        if (user != null) {
            if (user.getDateExpired().getTime() + EXPIRED_TIME > new Date().getTime()) {
                model.addAttribute("email", user.getEmail());
                return "newPassword";
            } else {
                model.addAttribute(ERROR_ATTRIBUTE, NOT_VERIFIED);
                return "restorePassword";
            }
        } else {
            model.addAttribute(MODEL_ATTRIBUTE, NOT_VERIFIED);
        }
        return "index";
    }

    @Override
    @PostMapping("/newPassword")
    public String saveNewPassword(Model model,
                                  @RequestParam(name = "password") @NonNull String password,
                                  @RequestParam(name = "email") @NonNull String email) {
        if (userServiceFacadeImpl.isUserExist(email.toLowerCase())) {
            User user = userServiceFacadeImpl.findUser(email);
            validError.clearValidate();
            if (!validError.isPasswordValid(password)) {
                model.addAttribute("email", email);
                model.addAttribute(ERROR_ATTRIBUTE, validError.getValidationErrors().values());
                return "newPassword";
            } else {
                userServiceFacadeImpl.updatePassword(user, password);
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

    @Override
    @GetMapping("/userProfile")
    public String userProfile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userServiceFacadeImpl.findByLogin(principal.getName());
        model.addAttribute("user", user);
        return "userProfile";
    }

    @Override
    @GetMapping("/resendTokenToActivation")
    public String resendTokenToActivation(@NonNull Model model, @NonNull Principal principal) {
        User user = userServiceFacadeImpl.findByLogin(principal.getName());
        userServiceFacadeImpl.sendActiveCodeToMail(user);
        model.addAttribute("user", user);
        return "userProfile";
    }
}
