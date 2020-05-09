package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailService;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFacade {
    private final UserService userService;
    private final MailService mailService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceFacade(UserService userService, MailService mailService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mailService = mailService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Вспомогательный метод, находящий пользователя либо по login, либо по email, которые ввел пользователь в общее поле
     *
     * @param loginOrEmail - Строка, по замыслу хранящая Login или Email пользователя
     * @return - Возвращает конкретного пользователя или  null
     */
    public User findUser(String loginOrEmail) {
        return userService.findByLoginOrEmail(loginOrEmail.toLowerCase()).orElse(null);
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    /**
     *
     * @param login - Строка, по замыслу хранящая Login или Email пользователя
     * @return - возвращает булиевое значение о существовании пользователя с данной записью в БД
     */
    public boolean isUserExist(String login) {
        return userService.isUserExist(login);
    }

    public User findByLogin(String login) {
        return userService.findByLogin(login).orElse(null);
    }

    public User findByToken(String token) {
        return userService.findByToken(token).orElse(null);
    }

    /**
     * Метод находит пользователя,
     * создает токен и ставит отметку создания токена в базу,
     * после чего токен подшивается в ссылку для восстановления пароля
     *
     * @param login - Строка, по замыслу хранящая Login или Email пользователя
     */
    public void restorePassword(String login) {
        User user = findUser(login);
        userService.generateToken(user);
        mailService.sendRestorePasswordMail(user);
    }

    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            userService.generateToken(user);
            mailService.sendActiveCodeToMail(user);
        }
    }

    public void createNewUser(User user) {
        user.setPassword(passwordEncode(user.getPassword()));
        user.setRole(roleService.getUserRole());
        user.setEmail(user.getEmail().toLowerCase());
        user.setLogin(user.getLogin().toLowerCase());
        userService.saveUser(user);
        sendActiveCodeToMail(user);
    }

    public void activateUser(User user) {
        user.setApproved(true);
        user.setToken(null);
        user.setDate_exp(null);
        userService.saveUser(user);
    }

    public void updatePassword(User user, String password) {
        user.setPassword(passwordEncode(password));
        activateUser(user);
    }

    public void clearFields(User user) {
        user.setEmail("");
        user.setLogin("");
        user.setPassword("");
    }
}
