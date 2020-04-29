package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import com.cryptowallet.utils.PasswordGenerator;
import com.cryptowallet.utils.UsersRoles;
import com.cryptowallet.utils.ValidateInputData;
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
import java.util.UUID;


@Controller
public class UserController {
    public static final int TOKEN_LENGTH = 50;

    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private ValidateInputData validError;

    @Autowired
    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
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
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(roleService.getAllRolesById(UsersRoles.ROLE_USER.getRole()));
            user.setToken(PasswordGenerator.generate(TOKEN_LENGTH));
            user.setActivationCode(userService.generateActiveCode());
            userService.saveUser(user);
            userService.sendActiveCodeToMail(user);
        } else {
            validError.putValidationErrors("User already exists", "User already exists");
            System.out.println(6);
            user.setEmail("");
            user.setLogin("");
            user.setPassword(null);
            model.addAttribute("user", user);
            model.addAttribute("not_valid", validError.getValidationErrors());
            return "registration";
        }
        try {
            request.login(user.getLogin(), password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
