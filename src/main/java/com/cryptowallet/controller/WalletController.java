package com.cryptowallet.controller;

import com.cryptowallet.services.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    private TempService tempService;

    @Autowired
    public void setTempService(TempService tempService) {
        this.tempService = tempService;
    }

    @GetMapping("/")
    public String showWallet(Model model) {
        model.addAttribute("wallets", tempService.getAllWallets());
        model.addAttribute("currencies", tempService.getAllCurrencies());
        return "wallet";
    }

    @GetMapping("/w")
    public String showNewWallet(Model model, @RequestParam(defaultValue = "") String address) {
        model.addAttribute("wallets", tempService.getAllWallets());
        model.addAttribute("currencies", tempService.getAllCurrencies());
        model.addAttribute("address", address);
        return "wallet";
    }

    @PostMapping("/add")
    public String addWallet(Model model, @RequestParam(name="currencyId") Long currencyId) {
        TempService.TempWallet newWallet = tempService.addWallet(currencyId - 1);
        return "redirect:/wallet/w?address=" + newWallet.getAddress();
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
