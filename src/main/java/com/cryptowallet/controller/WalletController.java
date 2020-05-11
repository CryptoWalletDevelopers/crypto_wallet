package com.cryptowallet.controller;

import com.cryptowallet.services.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    private TempService tempService;

    @Autowired
    public void setTempService(TempService tempService) {
        this.tempService = tempService;
    }

    @GetMapping("/")
    public String wallet(Model model) {
        model.addAttribute("users", tempService.getAllUsers());
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
