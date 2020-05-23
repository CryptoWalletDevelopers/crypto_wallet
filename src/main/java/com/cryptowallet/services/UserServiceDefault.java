package com.cryptowallet.services;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.interfaces.UserService;
import com.cryptowallet.utils.PasswordGenerator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceDefault implements UserService {
    public static final int TOKEN_LENGTH = 50;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceDefault(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByToken (String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login.toLowerCase().trim());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email.toLowerCase().trim());
    }

    @Override
    public Optional<User> findByLoginOrEmail(String loginOrEmail) {
        return userRepository.findByLoginOrEmail(loginOrEmail.toLowerCase().trim(), loginOrEmail.toLowerCase().trim());
    }

    @Override
    public boolean isUserExist(String loginOrEmail) {
        return userRepository.existsByLoginOrEmail(loginOrEmail.toLowerCase(), loginOrEmail.toLowerCase());
    }

    @Override
    public void save(@NonNull User user) {
        user.setLogin(user.getLogin().toLowerCase().trim());
        user.setEmail(user.getEmail().toLowerCase().trim());
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void generateToken (User user) {
        user.setToken(PasswordGenerator.generateToken(TOKEN_LENGTH));
        user.setDateExpired(new Date());
        save(user);
    }

//    ////////////////// after merge ///////////////////

    @Override
    public String getNewStringTronAddress(@NonNull User user, @NonNull Currency currency) {
        return null;
    }

    @Override
    public int getTronAddressIndex(@NonNull User user) {
        return 0;
    }

    @Override
    public ArrayList<WalletItem> getWalletItems(@NonNull User user) {
        return null;
    }
}
