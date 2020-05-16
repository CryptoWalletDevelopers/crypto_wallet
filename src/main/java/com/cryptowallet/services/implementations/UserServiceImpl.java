package com.cryptowallet.services.implementations;

import com.cryptowallet.API.TronApi;
import com.cryptowallet.crypto.Hash;
import com.cryptowallet.entities.*;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.interfaces.UserService;
import com.cryptowallet.wallets.TronWallet;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {
    private UserRepository userRepository;
    @Autowired
    private TronWallet tronWallet;
    @Autowired
    private AddressServiceImpl addressService;
    private final int tronIndex = 195;
    @Autowired
    private TronApi tronApi;

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

     public HashMap<String, Integer> getAddressAndCurrency(@NonNull User user){
         ArrayList<Address> addresses = (ArrayList<Address>) user.getAddresses();
         HashMap<String, Integer> map = new HashMap<>();
         addresses.stream().forEach(address -> {
             map.put(address.getAddress(), address.getCurrency().getIndex());
         });
         return map;
     }

     @Override
     public ArrayList<WalletItem> getWalletItems(@NonNull  User user){
         ArrayList<WalletItem> walletItems= new ArrayList<>();
         HashMap<String, Integer> pairs = getAddressAndCurrency(user);
         for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
             if(entry.getValue()== tronIndex){
                 Long balance = tronApi.getAccountInfoByAddress(entry.getKey()).getData()[0].getBalance();
                 walletItems.add(new WalletItem(entry.getKey(), entry.getValue() ,balance));
             }
         }
         return walletItems;
     }
}
