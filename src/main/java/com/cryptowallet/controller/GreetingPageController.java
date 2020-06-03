package com.cryptowallet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingPageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
