package com.cryptowallet.controller;


import com.cryptowallet.services.implementations.CryptoPriceServiceImpl;
import com.cryptowallet.util.SchedulingTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CryptoPriceController {

    @Autowired
    private CryptoPriceServiceImpl priceService;

    @GetMapping(value = "/exchange")
    public String getCryptoCoinsList(@RequestParam Map<String,String> params, Model model) {
        model.addAttribute("coins", priceService.getData(params));
        return "exchange";
    }
}
