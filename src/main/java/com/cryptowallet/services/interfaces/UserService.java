package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.User;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserService {

    Optional<User> findByToken (@NonNull String token);

    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findByEmail(@NonNull String email);

    Optional<User> findByLoginOrEmail(@NonNull String loginOrEmail);

    boolean isUserExist(@NonNull String loginOrEmail);

    void saveUser(@NonNull User user);

    void removeUser(@NonNull User user);

    void generateToken (@NonNull User user);
}
