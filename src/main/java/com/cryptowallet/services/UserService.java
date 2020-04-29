package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.LengthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    //private Map<String, String> validationErrors=new HashMap<>();

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).get();
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                mapRolesToAuthorises(user.getRoles()));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorises(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }

    public boolean isUserExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            mailService.sendActiveCodeToMail(user);
        }
    }

    public User findByActivationCode (String code) {
        return userRepository.findByActivationCode(code);
    }

    public void restorePassword(String email) {
        User user = userRepository.findByEmail(email).get();
        user.setActivationCode(generateActiveCode());
        userRepository.save(user);
        mailService.sendRestorePasswordMail(user);
    }

    public String generateActiveCode () {
        String code;
        do{
            code = UUID.randomUUID().toString();
        }while (userRepository.findByActivationCode(code)!=null);
        return code;
    }
}
