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
        User user = userService.findByLogin(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                mapRolesToAuthorises(roleService.getAuthorities(UsersRoles.ROLE_USER.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorises(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }

    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            mailService.sendActiveCodeToMail(user);
        }
    }

    public void restorePassword(String login) {
        User user = userService.findByLogin(login);
        userService.saveUser(user);
        mailService.sendRestorePasswordMail(user);
    }

    public String generateToken () {
        return PasswordGenerator.generate(TOKEN_LENGTH);
    }

    public Role getUserRole () {
        return roleService.getRoleById(UsersRoles.ROLE_USER.getRole()).get();
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }

    public boolean isUserExist (String login) {
        return userService.isUserExist(login);
    }

    public void saveUser (User user) {
        userService.saveUser(user);
    }

    public User findByToken (String token) {
        return userService.findByToken(token);
    }

    public User findByLogin (String login) {
        return userService.findByLogin(login);
    }
}
