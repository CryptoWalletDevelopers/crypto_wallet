package com.cryptowallet.services.interfaces;


import com.cryptowallet.entities.User;
import org.springframework.lang.NonNull;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.repositories.UserRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Optional;

import java.util.Optional;

@Component
public interface UserService {

    Optional<User> findByToken (@NonNull String token);

    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findByEmail(@NonNull String email);

    Optional<User> findByLoginOrEmail(@NonNull String loginOrEmail);

    boolean isUserExist(@NonNull String loginOrEmail);

    void saveUser(@NonNull User user);

    void removeUser(@NonNull User user);

    void generateToken (@NonNull User user);

    User findUserByEmail(@NonNull String email);

   void save (@NonNull User user);

   String getNewStringTronAddress(@NonNull User user, @NonNull Currency currency);

   int getTronAddressIndex(@NonNull User user);

   ArrayList<WalletItem> getWalletItems(@NonNull  User user);
}
