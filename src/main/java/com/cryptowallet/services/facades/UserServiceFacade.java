package com.cryptowallet.services.facades;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailService;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import com.cryptowallet.utils.PasswordGenerator;
import com.cryptowallet.utils.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserServiceFacade implements UserDetailsService {
    public static final int TOKEN_LENGTH = 50;
    private UserService userService;
    private MailService mailService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceFacade(UserService userService, MailService mailService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mailService = mailService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = authorize(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                mapRolesToAuthorises(roleService.getAuthorities(UsersRoles.ROLE_USER.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorises(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }

    /**
     * Вспомогательный метод, находящий пользователя либо по login, либо по email, которые ввел пользователь в общее поле
     *
     * @param loginOrEmail - Строка, по замыслу хранящая Login или Email пользователя
     * @return - Возвращает конкретного пользователя или  null
     */
    public User authorize (String loginOrEmail) {
        User user;
        for (char ch : loginOrEmail.toCharArray()) {
            if (ch == '@'){
                user = userService.findByEmail(loginOrEmail.toLowerCase());
                if (user != null) return user;
            }
        }
        user = userService.findByLogin(loginOrEmail.toLowerCase());
        return user;
    }

    public String generateToken () {
        return PasswordGenerator.generateToken(TOKEN_LENGTH);
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    public Role getUserRole () {
        return roleService.getRoleById(UsersRoles.ROLE_USER.getRole()).get();
    }

    public boolean isUserExist(String login) {
        return userService.isUserExist(login);
    }

    public User findByLogin(String login) {
        return userService.findByLogin(login);
    }

    public User findByToken(String token) {
        return userService.findByToken(token);
    }

    public void restorePassword(String login) {
        User user = authorize(login);
        userService.saveUser(user);
        mailService.sendRestorePasswordMail(user);
    }

    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            user.setToken(generateToken());
            user.setDate_exp(new Date());
            saveUser(user);
            mailService.sendActiveCodeToMail(user);
        }
    }

//    Не уверен конечно, но мне кажется можно отказаться от этого метода.
    public void resendTokenToActivation(User user) {
        sendActiveCodeToMail(user);
    }

    public void saveUser(User user) {
        userService.saveUser(user);
    }

    public void createNewUser(User user) {
        user.setPassword(passwordEncode(user.getPassword()));
        user.setRole(getUserRole());
        user.setEmail(user.getEmail().toLowerCase());
        user.setLogin(user.getLogin().toLowerCase());
        saveUser(user);
        sendActiveCodeToMail(user);
    }

    public void clearFields(User user) {
        user.setEmail("");
        user.setLogin("");
        user.setPassword("");
    }
}
