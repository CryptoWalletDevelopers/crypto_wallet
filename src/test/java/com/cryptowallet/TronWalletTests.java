package com.cryptowallet;

import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.AddressService;
import com.cryptowallet.services.CurrencyService;
import com.cryptowallet.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import com.cryptowallet.wallets.TronWallet;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.PostConstruct;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class TronWalletTests {
    @Autowired
    private TronWallet tronWallet;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private Environment env;

    @PostConstruct
    public  void setSecret() {
       tronWallet.secret = env.getProperty("secret");
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
        User user = new User("login","pass","email",true);
        userService.save(user);
        String address1 = tronWallet.getNewAddress(user);
        String address2 = tronWallet.getNewAddress(user);
        String address3 = tronWallet.getNewAddress(user);
        System.out.println(address3);
    }

    @Test
    public void getMaxTronAddressIndexTest(){
        User user = new User("login","pass","email",true);
        ArrayList<Address> ua = new ArrayList<>();
        user.setAddresses(ua);
        userService.save(user);
        Currency currency = new Currency();
        currency.setIndex(195);
        currencyService.save(currency);
        String address1 = tronWallet.getNewAddress(user);
        Address address_1 = new Address();
        address_1.setUser(user);
        address_1.setAddress(address1);
        address_1.setCurrency(currency);
        user.getAddresses().add(address_1);
        address_1.setIndex(tronWallet.getMaxTronAddressIndex(user)+1);
        addressService.save(address_1);
        String address2 = tronWallet.getNewAddress(user);
        Address address_2 = new Address();
        address_2.setUser(user);
        address_2.setAddress(address2);
        address_2.setCurrency(currency);
        user.getAddresses().add(address_2);
        address_2.setIndex(tronWallet.getMaxTronAddressIndex(user)+1);
        addressService.save(address_2);
        int max_index = tronWallet.getMaxTronAddressIndex(user);
        System.out.println(user.getAddresses().size());
        System.out.println(max_index);
    }

}
