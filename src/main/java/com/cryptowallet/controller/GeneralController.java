package com.cryptowallet.controller;

import com.cryptowallet.entities.User;
import com.cryptowallet.entities.WalletItem;
import com.cryptowallet.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class GeneralController {

    private UserServiceImpl userService;

    @Autowired
    public GeneralController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/walletPage")
    public String getWalletPage(Principal principal, Model model) {
        if(!userService.isUserLoggedIn()){
            return "login";
        }
        User user = userService.findByLogin(principal.getName()).get();
        ArrayList<WalletItem> itemList = userService.getWalletItems(user);
        model.addAttribute("itemList", itemList);
        return "wallet";
    }

    @GetMapping("/explorer")
    public String getExplorerPage(){
        return "explorer";
    }
}
