package com.cryptowallet.services;

import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.interfaces.UserService;
import com.cryptowallet.wallets.TronWallet;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {
    private UserRepository userRepository;
    @Autowired
    private TronWallet tronWallet;
    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByEmail(@NonNull String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void save(@NonNull User user) {
        userRepository.save(user);
    }

    @Override
    public String getNewStringTronAddress(@NonNull User user, @NonNull Currency currency){
        String newAddress = tronWallet.getNewAddress(user);
        Address address = new Address(user, currency ,getTronAddressIndex(user),newAddress);
        user.getAddresses().add(address);
        addressService.save(address);
        return newAddress;
    }

    @Override
     public int getTronAddressIndex(@NonNull User user){
        return tronWallet.getMaxAddressIndex(user);
     }
}
