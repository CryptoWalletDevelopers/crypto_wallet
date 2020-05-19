package com.cryptowallet.controller;


import com.cryptowallet.services.interfaces.CryptoPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoPriceController {

    @Autowired
    private CryptoPriceService cryptoPriceService;


    @GetMapping(value = "/exchange")
    public String getCryptoCoinsList(Model model) {
        model.addAttribute("coins", cryptoPriceService.getData());
        return "exchange";
    }
}
