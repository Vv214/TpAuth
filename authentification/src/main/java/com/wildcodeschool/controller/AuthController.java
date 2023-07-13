package com.wildcodeschool.controller;

import com.wildcodeschool.controller.entity.UserLogin;
import com.wildcodeschool.controller.entity.UserRegister;
import com.wildcodeschool.service.AuthService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request, @RequestBody UserRegister user) {

        request.getSession();

        boolean isRegisted = authService.register(
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getCpassword());
        return isRegisted ? user.getLogin() + " is registed !" : "Register Failed ....";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLogin user) {
        var isLogin = authService.login(user.getLogin(), user.getPassword());
        return isLogin ? user.getLogin() + " is connected" : "Authentication Failed !";
    }

    @Controller
    public class indexController {
        // handler method to handle home page request
        @GetMapping("/")
        public String home() {
            return "index";
        }
    }
}
