package com.wildcodeschool;

import com.wildcodeschool.authentification.service.authentication;
import com.wildcodeschool.authentification.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/register")
    public String getRegister() {
        return "register.html";
    }
}
