package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.implementations.MailServiceImpl;
import com.cryptowallet.services.implementations.RoleServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Log4j2
@Service
public class UserAuthAuthServiceFacadeImpl implements UserAuthServiceFacade {
    private final UserServiceImpl userServiceImpl;
    private final MailServiceImpl mailServiceImpl;
    private final RoleServiceImpl roleServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthAuthServiceFacadeImpl(UserServiceImpl userServiceImpl, MailServiceImpl mailServiceImpl, RoleServiceImpl roleServiceImpl, PasswordEncoder passwordEncoder) {
        this.userServiceImpl = userServiceImpl;
        this.mailServiceImpl = mailServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isUserExist(String login) {
        return userServiceImpl.isUserExist(login);
    }

    @Override
    public User findUser(String loginOrEmail) {
        return userServiceImpl.findByLoginOrEmail(loginOrEmail.toLowerCase()).orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return userServiceImpl.findByLogin(login).orElse(null);
    }

    @Override
    public User findByToken(String token) {
        return userServiceImpl.findByToken(token).orElse(null);
    }

    @Override
    public void createNewUser(User user, String password, HttpServletRequest request) {
        user.setLogin(user.getLogin().toLowerCase());
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(passwordEncode(user.getPassword()));
        user.setRole(roleServiceImpl.getUserRole());
        userServiceImpl.saveUser(user);
        sendActiveCodeToMail(user);
        loginToSite(user.getLogin(), password, request);
    }

    @Override
    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            userServiceImpl.generateToken(user);
            mailServiceImpl.sendActiveCodeToMail(user);
        }
    }

    @Override
    public void restorePassword(String login) {
        User user = findUser(login);
        userServiceImpl.generateToken(user);
        mailServiceImpl.sendRestorePasswordMail(user);
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
        userServiceImpl.saveUser(user);
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
