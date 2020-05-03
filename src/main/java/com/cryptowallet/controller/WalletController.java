package com.cryptowallet.controller;

import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.AddressService;
import com.cryptowallet.services.CurrencyService;
import com.cryptowallet.services.UserService;
import com.cryptowallet.utils.TronWallet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;
import java.util.ArrayList;


@Controller("/wallet")
public class WalletController {
    private UserService userService;
    private AddressService addressService;
    private CurrencyService currencyService;
    private Currency currency;
    private TronWallet tronWallet;

    public WalletController(UserService userService, AddressService addressService, CurrencyService currencyService){
        this.userService = userService;
        this.addressService = addressService;
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String wallet(Principal principal, Model model){
        User user = userService.findByLogin(principal.getName());
        ArrayList<Address> addresses = (ArrayList<Address>) user.getAddresses();
       if(!addresses.isEmpty()){
           for (int i= 0; i<addresses.size();i++){
               addresses.get(i).getCurrency();
//               addresses.get(i).getBalance();
           }
       }
       model.addAttribute("wallet", tronWallet);
       model.addAttribute("currency", currency);
        return "redirect:/";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String getNewAddress(Principal principal, @ModelAttribute(name = "currency") Currency currency, Model model){
        User user = userService.findByLogin(principal.getName());
        int index = tronWallet.getMaxTronAddressIndex(user);
        String address = tronWallet.getNewAddress(user);
        Address newAddress = new Address();
        newAddress.setUser(user);
        newAddress.setIndex(index+1);
        newAddress.setAddress(address);
        newAddress.setCurrency(currency);
        addressService.save(newAddress);
        model.addAttribute("address", address);
        return "redirect:/";
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