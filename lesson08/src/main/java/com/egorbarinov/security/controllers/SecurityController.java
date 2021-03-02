package com.egorbarinov.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model mOdel){
        mOdel.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/authenticated")
    public String authenticatedPage(Principal principal, Model model) {
        model.addAttribute("principal", principal);

        return "authenticated-user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "/admin";
    }

    @GetMapping("/resource-sharing")
    private  String getSharingPage() {
        return "/resource-sharing";
    }
}
