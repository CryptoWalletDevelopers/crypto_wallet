package com.cryptowallet.services;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByToken (String token) {return userRepository.findByToken(token);}

    public User findByLogin(String login) {
        return userRepository.findByLogin(login.toLowerCase());
    }

    public boolean isUserExist(String loginOrEmail) {
        return userRepository.existsByLogin(loginOrEmail.toLowerCase()) || userRepository.existsByEmail(loginOrEmail.toLowerCase());
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
