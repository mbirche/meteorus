package com.mbf.meteorus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index"; // Carrega o template src/main/resources/templates/index.html
    }
}
