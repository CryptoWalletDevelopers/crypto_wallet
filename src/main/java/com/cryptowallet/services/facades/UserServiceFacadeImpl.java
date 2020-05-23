package com.cryptowallet.services.facades;

import com.cryptowallet.API.TronApi;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.MailServiceDefault;
import com.cryptowallet.services.RoleServiceDefault;
import com.cryptowallet.services.UserServiceDefault;
import com.cryptowallet.services.implementations.AddressServiceImpl;
import com.cryptowallet.wallets.TronWallet;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Log4j2
@Service
public class UserServiceFacadeImpl implements UserServiceFacade {
    private final UserServiceDefault userServiceDefault;
    private final MailServiceDefault mailServiceDefault;
    private final RoleServiceDefault roleServiceDefault;
    private final PasswordEncoder passwordEncoder;

    private final AddressServiceImpl addressService;
    private final TronWallet tronWallet;
    private final TronApi tronApi;

    private final int tronIndex = 195;

    @Autowired
    public UserServiceFacadeImpl(UserServiceDefault userServiceDefault, MailServiceDefault mailServiceDefault, RoleServiceDefault roleServiceDefault, PasswordEncoder passwordEncoder
    , AddressServiceImpl addressService, TronWallet tronWallet, TronApi tronApi) {
        this.userServiceDefault = userServiceDefault;
        this.mailServiceDefault = mailServiceDefault;
        this.roleServiceDefault = roleServiceDefault;
        this.passwordEncoder = passwordEncoder;


        this.addressService = addressService;
        this.tronWallet = tronWallet;
        this.tronApi = tronApi;
    }

    public String passwordEncode (String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isUserExist(String login) {
        return userServiceDefault.isUserExist(login);
    }

    @Override
    public User findUser(String loginOrEmail) {
        return userServiceDefault.findByLoginOrEmail(loginOrEmail.toLowerCase()).orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return userServiceDefault.findByLogin(login).orElse(null);
    }

    @Override
    public User findByToken(String token) {
        return userServiceDefault.findByToken(token).orElse(null);
    }

    @Override
    public void createNewUser(User user, String password, HttpServletRequest request) {
        user.setLogin(user.getLogin().toLowerCase());
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(passwordEncode(user.getPassword()));
        user.setRole(roleServiceDefault.getUserRole());
        userServiceDefault.save(user);
        sendActiveCodeToMail(user);
        loginToSite(user.getLogin(), password, request);
    }

    @Override
    public void sendActiveCodeToMail (User user) {
        if(!user.isApproved()) {
            userServiceDefault.generateToken(user);
            mailServiceDefault.sendActiveCodeToMail(user);
        }
    }

    @Override
    public void restorePassword(String login) {
        User user = findUser(login);
        userServiceDefault.generateToken(user);
        mailServiceDefault.sendRestorePasswordMail(user);
    }

    @Override
    public void updatePassword(User user, String password) {
        user.setPassword(passwordEncode(password));
        activateUser(user);
    }

    public void activateUser(User user) {
        user.setApproved(true);
        user.setToken(null);
        user.setDateExpired(null);
        userServiceDefault.save(user);
    }

    public void clearFields(User user) {
        user.setEmail("");
        user.setLogin("");
        user.setPassword("");
    }

    @Override
    public void loginToSite(String login, String password, HttpServletRequest request) {
        try {
            request.login(login, password);
        } catch (ServletException e) {
            log.info("Cant authority User with login = " + login);
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findUserByEmail(@NonNull String email) {
        return userServiceDefault.findByEmail(email);
    }

    //    ////////////////////////////////////////////

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
    public void saveUser(User user) {
        userServiceDefault.save(user);
    }
}
