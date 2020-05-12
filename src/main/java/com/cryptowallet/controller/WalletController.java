package com.cryptowallet.controller;

import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.implementations.AddressServiceImpl;
import com.cryptowallet.services.implementations.CurrencyServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import com.cryptowallet.wallets.TronWallet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("wallet")
public class WalletController {
    private UserServiceImpl userService;
    private AddressServiceImpl addressService;
    private CurrencyServiceImpl currencyService;
    private Currency currency;
    private TronWallet tronWallet;

    public WalletController(UserServiceImpl userService, AddressServiceImpl addressService, CurrencyServiceImpl currencyService){
        this.userService = userService;
        this.addressService = addressService;
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String wallet(Principal principal, Model model){
        Optional<User> user = userService.findUserByEmail(principal.getName());
        ArrayList<Address> addresses = (ArrayList<Address>) user.get().getAddresses();
       if(!addresses.isEmpty()){
           for (int i= 0; i<addresses.size();i++){
               addresses.get(i).getCurrency();
//               addresses.get(i).getBalance();
           }
       }
       model.addAttribute("wallet", tronWallet);
       model.addAttribute("currency", currency);
        return "redirect:/wallet";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String getNewAddress(Principal principal, @ModelAttribute(name = "currency") Currency currency, Model model){
        User user = userService.findUserByEmail(principal.getName()).get();
        if (currency.getIndex()==195){
        String address = userService.getNewStringTronAddress(user,currency);
        model.addAttribute("address", address);
        }
        return "redirect://wallet/new";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getInfo(){
        return null;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String send(){
        return null;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getMoney(){
        return null;
    }

}
