package com.sparadrap.webapp.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class PageController {

    @GetMapping("/")
    public String loginHome() {
        return "home";
    }

    @GetMapping("/home")
    public String Home() {
        return "home";
    }


    @GetMapping("/connexion")
    public String Connexion(){
        return "connexion";
    }

}
