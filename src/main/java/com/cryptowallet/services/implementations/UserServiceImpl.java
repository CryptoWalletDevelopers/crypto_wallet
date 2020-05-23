package com.cryptowallet.services.implementations;

import com.cryptowallet.API.TronApi;
import com.cryptowallet.entities.*;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.interfaces.UserService;
import com.cryptowallet.wallets.TronWallet;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService  {
    private UserRepository userRepository;
    private AddressServiceImpl addressService;
    private TronWallet tronWallet;
    private TronApi tronApi;

    private final int tronIndex = 195;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddressServiceImpl addressService, TronWallet tronWallet, TronApi tronApi) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.tronWallet = tronWallet;
        this.tronApi = tronApi;
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
        Address address = new Address(user, currency ,getTronAddressIndex(user)+1,newAddress);
        user.getAddresses().add(address);
        addressService.save(address);
        return newAddress;
    }

    @Override
     public int getTronAddressIndex(@NonNull User user){
        return tronWallet.getMaxAddressIndex(user);
     }

     public HashMap<String, Integer> getAddressAndCurrency(@NonNull User user){
        HashMap<String, Integer> map = new HashMap<>();
         Collection<Address> addresses =  user.getAddresses();
         if(!addresses.isEmpty()){
             addresses.stream().forEach(address -> {
                 map.put(address.getAddress(), address.getCurrency().getIndex());
             });
         }
         return map;
     }

     @Override
     public ArrayList<WalletItem> getWalletItems(@NonNull User user){
         ArrayList<WalletItem> walletItems= new ArrayList<>();
         HashMap<String, Integer> pairs = getAddressAndCurrency(user);
         if(!pairs.isEmpty()){
             for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
                 if (entry.getValue() == tronIndex) {
                     if (tronApi.getAccountInfoByAddress(entry.getKey()).getData().length == 0) {
                         walletItems.add(new WalletItem(entry.getKey(), entry.getValue(), 0L));
                     } else {
                         Long balance = tronApi.getAccountInfoByAddress(entry.getKey()).getData()[0].getBalance();
                         walletItems.add(new WalletItem(entry.getKey(), entry.getValue(), balance));
                     }
                 }
             }
         }
         return walletItems;
     }

    @Override
    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByLoginOrEmail(String loginOrEmail) {
        return Optional.empty();
    }

    @Override
    public boolean isUserExist(String loginOrEmail) {
        return false;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void generateToken(User user) {

    }
}
