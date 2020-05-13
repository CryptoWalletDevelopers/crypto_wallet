package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailServiceDefault;
import com.cryptowallet.services.RoleServiceImpl;
import com.cryptowallet.services.UserServiceDefault;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Log4j2
@Service
public class UserServiceFacadeImpl implements UserServiceFacade {
    private final UserServiceDefault userServiceDefault;
    private final MailServiceDefault mailServiceDefault;
    private final RoleServiceImpl roleServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceFacadeImpl(UserServiceDefault userServiceDefault, MailServiceDefault mailServiceDefault, RoleServiceImpl roleServiceImpl, PasswordEncoder passwordEncoder) {
        this.userServiceDefault = userServiceDefault;
        this.mailServiceDefault = mailServiceDefault;
        this.roleServiceImpl = roleServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isUserExist(String login) {
        return userServiceDefault.isUserExist(login);
    }

    @Override
    public User findUser(String loginOrEmail) {
        return userServiceDefault.findByLoginOrEmail(loginOrEmail.toLowerCase()).orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return userServiceDefault.findByLogin(login).orElse(null);
    }

    @Override
    public User findByToken(String token) {
        return userServiceDefault.findByToken(token).orElse(null);
    }

    @Override
    public void createNewUser(User user, String password, HttpServletRequest request) {
        user.setLogin(user.getLogin().toLowerCase());
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(passwordEncode(user.getPassword()));
        user.setRole(roleServiceImpl.getUserRole());
        userServiceDefault.saveUser(user);
        sendActiveCodeToMail(user);
        loginToSite(user.getLogin(), password, request);
    }

    @Override
    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            userServiceDefault.generateToken(user);
            mailServiceDefault.sendActiveCodeToMail(user);
        }
    }

    @Override
    public void restorePassword(String login) {
        User user = findUser(login);
        userServiceDefault.generateToken(user);
        mailServiceDefault.sendRestorePasswordMail(user);
    }

    @Override
    public void updatePassword(User user, String password) {
        user.setPassword(passwordEncode(password));
        activateUser(user);
    }

    public void activateUser(User user) {
        user.setApproved(true);
        user.setToken(null);
        user.setDateExpired(null);
        userServiceDefault.saveUser(user);
    }

    public void clearFields(User user) {
        user.setEmail("");
        user.setLogin("");
        user.setPassword("");
    }

    @Override
    public void loginToSite(String login, String password, HttpServletRequest request) {
        try {
            request.login(login, password);
        } catch (ServletException e) {
            log.info("Cant authority User with login = " + login);
            e.printStackTrace();
        }
    }
}
