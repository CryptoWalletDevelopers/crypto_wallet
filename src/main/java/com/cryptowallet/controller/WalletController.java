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
    private ArrayList<Currency> currencyList;

    @Autowired
    public WalletController(UserServiceImpl userService, TronTransactionServiceImpl tronTransactionService, CurrencyServiceImpl currencyService, TronAPI tronApi) {
        this.userService = userService;
        this.tronTransactionService = tronTransactionService;
        this.currencyService = currencyService;
        this.tronApi = tronApi;
    }

    @GetMapping
    public String walletPage(Principal principal, Model model){
        model.addAttribute("itemList", getTableContent(principal));
        return "wallet";
    }

    @PostMapping(value = "/new")
    public String getNewAddress(Principal principal, @RequestParam("title") String  title, Model model){
        String address = userService.getNewStringTronAddress(userService.findByLogin(principal.getName()).get(), currencyService.findCurrencyByShortTitle(title).get());
        model.addAttribute("itemList", getTableContent(principal));
        model.addAttribute("address", address);
        return "wallet";
    }

    @GetMapping(value = "/update")
    public String updateInfo(Principal principal, Model model){
        model.addAttribute("itemList", getTableContent(principal));
        return "wallet";
    }

    @PostMapping(value = "/transfer")
    public String send(Principal principal, @RequestParam(name = "addressTo") String addressTo, @RequestParam(name = "addressFrom") String addressFrom, @RequestParam(name= "amount") int amount, Model model) throws InvalidProtocolBufferException {
        model.addAttribute("itemList", getTableContent(principal));
        tronTransactionService.TransferTransaction(addressTo,addressFrom,amount);
        return "wallet";
    }

    @PostMapping(value = "/acquire")
    public String confirmPurchase(Principal principal, @RequestParam(name = "address") String address, @RequestParam(name = "amount") int amount, Model model) throws InvalidProtocolBufferException {
        String address_from ="TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn";
        tronTransactionService.TransferTransaction(address,address_from,amount);
        model.addAttribute("itemList", getTableContent(principal));
        return "wallet";
    }

    private ArrayList<WalletItem> getTableContent(Principal principal){
        User user = userService.findByLogin(principal.getName()).get();
        return userService.getWalletItems(user);
    }
}
