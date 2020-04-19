package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    public MainPageController() {
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
