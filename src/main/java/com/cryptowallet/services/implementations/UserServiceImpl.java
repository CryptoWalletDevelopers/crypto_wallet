package com.cryptowallet.services.implementations;

import com.cryptowallet.API.blockchain.TronAPI;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.interfaces.UserService;
import com.cryptowallet.utils.PasswordGenerator;
import com.cryptowallet.wallets.TronWallet;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private AddressServiceImpl addressService;
    private TronWallet tronWallet;
    private TronAPI tronApi;
    private final int tronIndex = 195;
    public static final int TOKEN_LENGTH = 50;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddressServiceImpl addressService, TronWallet tronWallet, TronAPI tronApi) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.tronWallet = tronWallet;
        this.tronApi = tronApi;
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
    public void saveUser(User user) {
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
        saveUser(user);
    }

    @Override
    public Optional<User> findUserByEmail(@NonNull String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void save(@NonNull User user) {
        userRepository.save(user);
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
}
