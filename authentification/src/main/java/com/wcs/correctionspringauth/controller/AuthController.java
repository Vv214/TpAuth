package com.wcs.correctionspringauth.controller;

import com.wcs.correctionspringauth.controller.entity.UserLogin;
import com.wcs.correctionspringauth.controller.entity.UserRegister;
import com.wcs.correctionspringauth.service.AuthService;
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
    public String register(@RequestBody UserRegister user) {
        boolean isRegisted = authService.register(
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getCpassword()
        );
        return isRegisted ? user.getLogin() + " is registed !" : "Register Failed ....";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLogin user) {
        var isLogin = authService.login(user.getLogin(), user.getPassword());
        return isLogin ? user.getLogin() + " is connected" : "Authentication Failed !";
    }
}
