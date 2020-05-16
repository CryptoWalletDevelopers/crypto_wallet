package com.cryptowallet.controller;
import com.cryptowallet.API.TronApi;
import com.cryptowallet.entities.*;
import com.cryptowallet.services.implementations.TronTransactionServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TronTransactionServiceImpl tronTransactionService;
    @Autowired
    private TronApi tronApi;
    private final int tronIndex = 195;

    public WalletController(UserServiceImpl userService, TronTransactionServiceImpl tronTransactionService, TronApi tronApi) {
        this.userService = userService;
        this.tronTransactionService = tronTransactionService;
        this.tronApi = tronApi;
    }

    @GetMapping(value = "/")
    public String wallet(Principal principal, Model model){
        User user = userService.findUserByEmail(principal.getName()).get();
        model.addAttribute("userWallet", new UserWallet(userService.getWalletItems(user)));
        return "redirect:/wallet";
    }

    @PostMapping(value = "/new")
    public String getNewAddress(Principal principal, @ModelAttribute(name = "currency") Currency currency, Model model){
        User user = userService.findUserByEmail(principal.getName()).get();
        if (currency.getIndex()==tronIndex)
        model.addAttribute("address", userService.getNewStringTronAddress(user,currency));
        return "redirect:/wallet/new";
    }

    @GetMapping(value = "/update")
    public String getInfo(@ModelAttribute(name = "address") String address, Model model){
        model.addAttribute("balance", tronApi.getAccountInfoByAddress(address).getData()[0].getBalance());
        return "/wallet";
    }

    @GetMapping(value = "/send")
    public String send(){
        return "send";
    }

    @PostMapping(value = "/transfer")
    public String send(@ModelAttribute(name = "address_to") String address_to, @ModelAttribute(name = "address_from") String address_from, @ModelAttribute(name= "amount") int amount) throws InvalidProtocolBufferException {
        if (tronTransactionService.TransferTransaction(address_to,address_from,amount).isResult()==true)
        {return "redirect:/wallet/";}
        else
            return null;
    }

    @GetMapping(value = "/get")
    public String getMoney(){
        return "get";
    }

    @PostMapping(value = "/confirm")
    public String confirmPurchase(@ModelAttribute(name = "address") String address, @ModelAttribute(name = "amount") int amount) throws InvalidProtocolBufferException {
        String address_from ="";
        if (tronTransactionService.TransferTransaction(address,address_from,amount).isResult()==true){
            return "redirect:/wallet/";}
        else
            return null;
    }
}
