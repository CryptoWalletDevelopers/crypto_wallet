package com.cryptowallet.controller;

import com.cryptowallet.services.AddressService;
import com.cryptowallet.services.CurrencyService;
import com.cryptowallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    AddressService addressService;
    CurrencyService currencyService;
    UserService userService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String wallet(Model model) {
//        model.addAttribute("wallets", userService.getAddreses);
        return "wallet";
    }

    @GetMapping("/get")
    public String get(Model model) {
        return "get";
    }

    @GetMapping("/send")
    public String send(Model model) {
        return "send";
    }
}
