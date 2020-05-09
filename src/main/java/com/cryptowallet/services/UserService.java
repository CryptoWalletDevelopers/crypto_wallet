package com.cryptowallet.services;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    public static final int TOKEN_LENGTH = 50;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByToken (String token) {
        return userRepository.findByToken(token);
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login.toLowerCase().trim());
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email.toLowerCase().trim());
    }

    public Optional<User> findByLoginOrEmail(String loginOrEmail) {
        return userRepository.findByLoginOrEmail(loginOrEmail.toLowerCase().trim(), loginOrEmail.toLowerCase().trim());
    }

    public boolean isUserExist(String loginOrEmail) {
        return userRepository.existsByLoginOrEmail(loginOrEmail.toLowerCase(), loginOrEmail.toLowerCase());
    }

    public void saveUser(User user) {
        user.setLogin(user.getLogin().toLowerCase().trim());
        user.setEmail(user.getEmail().toLowerCase().trim());
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public void generateToken (User user) {
        user.setToken(PasswordGenerator.generateToken(TOKEN_LENGTH));
        user.setDate_exp(new Date());
        saveUser(user);
    }
}
