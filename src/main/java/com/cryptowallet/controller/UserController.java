package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import com.cryptowallet.utils.PasswordGenerator;
import com.cryptowallet.utils.UsersRoles;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.LengthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {
    public static final int TOKEN_LENGTH = 50;

    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    private Map<String, String> validationErrors;

    @Autowired
    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.validationErrors = new HashMap<>();
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("create_user")
    @Transactional
    public String addUser(@ModelAttribute(name = "user") User user, Model model, HttpServletRequest request) {
        validationErrors.clear();
        String password = user.getPassword();

        if (!userService.isUserExist(user.getEmail())) {
            if (!isCorrectValidate(user)) {
                model.addAttribute("user", user);
                model.addAttribute("not_valid", validationErrors);
                return "registration";
            }
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(roleService.getAllRolesById(UsersRoles.ROLE_USER.getRole()));
            user.setToken(PasswordGenerator.generate(TOKEN_LENGTH));
            userService.saveUser(user);
        } else {
            validationErrors.put("User already exists", "User already exists");
            user.setEmail("");
            user.setLogin("");
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute("not_valid", validationErrors);
            return "registration";
        }
        try {
            request.login(user.getLogin(), password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    private boolean isCorrectValidate(User user) {
        boolean isCorrect = true;
        if (LengthValidator.isNotValid(6, 30, user.getPassword())) {
            validationErrors.put("password length error", "Password must be between 6 and 30 characters");
            isCorrect = false;
        } else if (CharSetValidator.isNotValid(user.getPassword())) {
            validationErrors.put("password charset error", "Password contains invalid characters");
            isCorrect = false;
        }

        if (LengthValidator.isNotValid(3, 30, user.getLogin())) {
            validationErrors.put("login length error", "Login must be between 3 and 30 characters");
            isCorrect = false;
        } else if (CharSetValidator.isNotValid(user.getLogin())) {
            validationErrors.put("login charset error", "Login contains invalid characters");
            isCorrect = false;
        }

        if (CharSetValidator.isNotValid(user.getEmail())) {
            validationErrors.put("email charset error", "Email contains invalid characters");
            isCorrect = false;
        }
        return isCorrect;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
