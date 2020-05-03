package com.cryptowallet.services;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
