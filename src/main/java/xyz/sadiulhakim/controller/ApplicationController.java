package xyz.sadiulhakim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/login_page")
    String loginPage() {
        return "login_page";
    }

    @GetMapping("/register_page")
    String registerPage() {
        return "register_page";
    }
}
