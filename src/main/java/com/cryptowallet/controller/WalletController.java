package com.cryptowallet.controller;
import com.cryptowallet.API.TronApi;
import com.cryptowallet.entities.*;
import com.cryptowallet.services.implementations.CurrencyServiceImpl;
import com.cryptowallet.services.implementations.TronTransactionServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import com.cryptowallet.wallets.TronWallet;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private UserServiceImpl userService;
    private TronTransactionServiceImpl tronTransactionService;
    private CurrencyServiceImpl currencyService;
    private TronApi tronApi;
    private TronWallet tronWallet;
    private final int TRONINDEX = 195;

    @Autowired
    public WalletController(UserServiceImpl userService, TronTransactionServiceImpl tronTransactionService, CurrencyServiceImpl currencyService, TronApi tronApi, TronWallet tronWallet) {
        this.userService = userService;
        this.tronTransactionService = tronTransactionService;
        this.currencyService = currencyService;
        this.tronApi = tronApi;
        this.tronWallet = tronWallet;
    }

    @GetMapping(value = "/")
    public String wallet(Principal principal, Model model){
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("userWallet", new UserWallet(userService.getWalletItems(user)));
        model.addAttribute("currency", currencyService.findAll());
        return "redirect:/wallet";
    }

    @PostMapping(value = "/new")
    public String getNewAddress(Principal principal, @RequestParam(name = "currencyTitle") String currencyTitle, Model model){
        User user = userService.findUserByEmail(principal.getName());
        Currency currency = currencyService.findCurrencyByTitle(currencyTitle);
        if (currency.getIndex()==TRONINDEX)
        model.addAttribute("address", userService.getNewStringTronAddress(user,currency));
        return "redirect:/wallet/new";
    }

    @PostMapping(value = "/update")
    public String getInfo(@RequestParam(name = "address") String address, Model model){
        model.addAttribute("balance", tronApi.getAccountInfoByAddress(address).getData()[0].getBalance());
        return "/wallet";
    }

    @GetMapping(value = "/send")
    public String send(){
        return "send";
    }

    @PostMapping(value = "/transfer")
    public String send(@RequestParam(name = "address_to") String address_to, @RequestParam(name = "address_from") String address_from, @RequestParam(name= "amount") int amount) throws InvalidProtocolBufferException {
        if (tronTransactionService.TransferTransaction(address_to,address_from,amount).isResult()==true)
        {return "redirect: /";}
        else
            return null;
    }

    @GetMapping(value = "/get")
    public String getMoney(){
        return "get";
    }

    @PostMapping(value = "/confirm")
    public String confirmPurchase(@RequestParam(name = "address") String address, @RequestParam(name = "amount") int amount) throws InvalidProtocolBufferException {
        String address_from ="TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn";
        if (tronTransactionService.TransferTransaction(address,address_from,amount).isResult()==true){
            return "redirect:/wallet/";}
        else
            return null;
    }
}
