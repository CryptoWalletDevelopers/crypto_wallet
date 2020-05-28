package com.cryptowallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

    @GetMapping
    public String exchangePage(){
        return "exchange";
    }
}
