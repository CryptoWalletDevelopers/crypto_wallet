package com.cryptowallet.controller;
import com.cryptowallet.API.blockchain.TronAPI;
import com.cryptowallet.entities.*;
import com.cryptowallet.services.implementations.CurrencyServiceImpl;
import com.cryptowallet.services.implementations.TronTransactionServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.ArrayList;

@Log4j2
@Controller
@RequestMapping("/wallet")
public class WalletController {
    private UserServiceImpl userService;
    private TronTransactionServiceImpl tronTransactionService;
    private CurrencyServiceImpl currencyService;
    private TronAPI tronApi;
    private UserWallet userWallet;
    private ArrayList<Currency> currencyList;
    private final int INDEX = 195;

    @Autowired
    public WalletController(UserServiceImpl userService, TronTransactionServiceImpl tronTransactionService, CurrencyServiceImpl currencyService, TronAPI tronApi, UserWallet userWallet) {
        this.userService = userService;
        this.tronTransactionService = tronTransactionService;
        this.currencyService = currencyService;
        this.tronApi = tronApi;
        this.userWallet = userWallet;
    }

    @GetMapping
    public String walletPage(Principal principal, Model model){
        User user = userService.findByLogin(principal.getName()).get();
        ArrayList<WalletItem> itemList = userService.getWalletItems(user);
        model.addAttribute("itemList", itemList);
        return "wallet";
    }

    @PostMapping(value = "/new")
    public String getNewAddress(Principal principal, @RequestParam("title") String  title, Model model){
        User user = userService.findByLogin(principal.getName()).get();
        String address = userService.getNewStringTronAddress(user, currencyService.findCurrencyByShortTitle(title).get());
        ArrayList<WalletItem> itemList = userService.getWalletItems(user);
        model.addAttribute("itemList", itemList);
        model.addAttribute("address", address);
        return "wallet";
    }

    @PostMapping(value = "/update")
    public String getInfo(@RequestParam(name = "address") String address, Model model){
        model.addAttribute("balance", tronApi.getAccountInfoByAddress(address).getData()[0].getBalance());
        return "wallet";
    }

    @PostMapping(value = "/transfer")
    public String send(Principal principal, @RequestParam(name = "address_to") String address_to, @RequestParam(name = "address_from") String address_from, @RequestParam(name= "amount") int amount, Model model) throws InvalidProtocolBufferException {
        User user = userService.findByLogin(principal.getName()).get();
        ArrayList<WalletItem> itemList = userService.getWalletItems(user);
        model.addAttribute("itemList", itemList);
        tronTransactionService.TransferTransaction(address_to,address_from,amount);
        System.out.println(tronTransactionService.TransferTransaction(address_to,address_from,amount).isResult());
        return "wallet";
    }

    @PostMapping(value = "/acquire")
    public String confirmPurchase(@RequestParam(name = "address") String address, @RequestParam(name = "amount") int amount) throws InvalidProtocolBufferException {
        String address_from ="TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn";
        tronTransactionService.TransferTransaction(address,address_from,amount);
        return "wallet";
    }
}
