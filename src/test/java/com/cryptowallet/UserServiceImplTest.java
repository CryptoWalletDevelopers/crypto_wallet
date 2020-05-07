package com.cryptowallet;

import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.AddressServiceImpl;
import com.cryptowallet.services.CurrencyServiceImpl;
import com.cryptowallet.services.UserServiceImpl;
import com.cryptowallet.wallets.TronWallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class UserServiceImplTest {
    @Autowired
    private TronWallet tronWallet;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private CurrencyServiceImpl currencyService;

    private User user1;
    private Currency currency;
    private Address address_1;

    @Before
    public void init(){
        user1 = new User("login1","pass1","email1",true);
        user1.setAddresses(new ArrayList<>());
        userService.save(user1);
        currency = new Currency();
        currency.setIndex(195);
        currencyService.save(currency);
    }

    @Test
    public void getNewStringTronAddressTest(){
        String address = userService.getNewStringTronAddress(user1, currency);
        Assert.assertTrue(address.equals("TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn"));
    }

    @Test
    public void getTronAddressIndex(){
        int index = userService.getTronAddressIndex(user1);
        Assert.assertTrue(index==-1);
    }



}
