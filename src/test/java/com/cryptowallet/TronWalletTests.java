package com.cryptowallet;

import com.cryptowallet.crypto.ECKey;
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
public class TronWalletTests {
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
        address_1 = new Address();
        address_1.setCurrency(currency);
        addressService.save(address_1);
        address_1.setUser(user1);
        user1.getAddresses().add(address_1);
    }

    @Test()
    public void testEckey(){
       ECKey key1 = tronWallet.getECkey(1,0);
       ECKey key2 =  tronWallet.getECkey(3,2);
       Assert.assertTrue(key1.toString().equals("pub:04de327150021b965f0a2e3a7377c3e5e450fc2fa5e6064ee2cf17d390878fa38afe707835222fa59c2d7fe346ade529c68b2006a59b8a1c9b5dc7931ae6578ac7"));
       Assert.assertTrue(key2.toString().equals("pub:043836745abeb3554bc37c564fa19bc4076ca0264a4c3e87fb369adbe013d6fe8e3825d466a008575d783c6d91ffedc0a20436d1f0610d5682728c9a4d37e89ee8"));
    }

    @Test
    public void getPrivateKeyBytesTest(){
        ECKey key1 = tronWallet.getECkey(1,0);
        ECKey key2 =  tronWallet.getECkey(3,2);
        String priv1 = tronWallet.getPrivateKeyBytes(key1);
        String priv2 = tronWallet.getPrivateKeyBytes(key2);
        Assert.assertTrue(priv1.equals("74707276386b36785234414261764832744d4633684163376f526e7842774376"));
        Assert.assertTrue(priv2.equals("74707276386a4b72503738777057647446316a6447575045555a4b314d68426e"));
    }

    @Test
    public void getStringAddressTest(){
        ECKey key1 = tronWallet.getECkey(1,0);
        ECKey key2 =  tronWallet.getECkey(3,2);
        String address1 = tronWallet.getStringAddress(key1);
        String address2 = tronWallet.getStringAddress(key2);
        Assert.assertTrue(address1.equals("TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn"));
        Assert.assertTrue(address2.equals("TPUPh49r9pooibFTJQcFWKQAren6Uo1FDX"));
    }

    @Test
    public void getNewAddressTest(){
        String address1 = tronWallet.getNewAddress(user1);
        address_1.setAddress(address1);
        address_1.setIndex(tronWallet.getMaxAddressIndex(user1)+1);
        String address2 = tronWallet.getNewAddress(user1);
        address_1.setAddress(address2);
        address_1.setIndex(tronWallet.getMaxAddressIndex(user1)+1);
        String address3 = tronWallet.getNewAddress(user1);
        address_1.setAddress(address3);
        address_1.setIndex(tronWallet.getMaxAddressIndex(user1)+1);
        Assert.assertTrue(!address1.equals(address3));
    }

    @Test
    public void getMaxTronAddressIndexTest(){
        String address1 = tronWallet.getNewAddress(user1);
        address_1.setUser(user1);
        address_1.setAddress(address1);
        address_1.setCurrency(currency);
        user1.getAddresses().add(address_1);
        address_1.setIndex(tronWallet.getMaxAddressIndex(user1)+1);
        String address2 = tronWallet.getNewAddress(user1);
        Address address_2 = new Address();
        address_2.setUser(user1);
        address_2.setAddress(address2);
        address_2.setCurrency(currency);
        user1.getAddresses().add(address_2);
        address_2.setIndex(tronWallet.getMaxAddressIndex(user1)+1);
        int max_index = tronWallet.getMaxAddressIndex(user1);
        Assert.assertTrue(max_index==2);
    }
}
