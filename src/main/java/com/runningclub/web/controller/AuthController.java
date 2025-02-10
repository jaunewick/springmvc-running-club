package com.runningclub.web.controller;

import com.runningclub.web.dto.RegistrationDto;
import com.runningclub.web.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
}
