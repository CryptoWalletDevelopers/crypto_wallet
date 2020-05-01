package com.cryptowallet.services.facades;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.MailService;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.utils.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceFacade implements UserDetailsService {
    private UserRepository userRepository;
    private MailService mailService;
    private RoleService roleService;

    @Autowired
    public UserServiceFacade(UserRepository userRepository, MailService mailService, RoleService roleService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).get();
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
        User user = userRepository.findByLogin(login).get();

        userRepository.save(user);
        mailService.sendRestorePasswordMail(user);
    }

    public String generateActiveCode () {
        String code;
//        do{
//            code = UUID.randomUUID().toString();
//        }while (userRepository.findByActivationCode(code)!=null);
//        return code;
        return "0";
    }

}
