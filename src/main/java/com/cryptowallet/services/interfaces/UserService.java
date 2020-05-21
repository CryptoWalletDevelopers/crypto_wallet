package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface UserService {
   User findUserByEmail(@NonNull String email);
   void save (@NonNull User user);
   String getNewStringTronAddress(@NonNull User user, @NonNull Currency currency);
   int getTronAddressIndex(@NonNull User user);
   ArrayList<WalletItem> getWalletItems(@NonNull  User user);

}
