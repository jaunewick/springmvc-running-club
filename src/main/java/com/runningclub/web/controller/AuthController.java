package com.runningclub.web.controller;

import com.runningclub.web.dto.RegistrationDto;
import com.runningclub.web.models.UserEntity;
import com.runningclub.web.service.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model) {
        UserEntity existingEmail = userService.findUserByEmail(user.getEmail());
        if (existingEmail != null
        && existingEmail.getEmail() != null
        && !existingEmail.getEmail().isEmpty()) {
            result.rejectValue("email", "There is already a user registered with that email");
        }

        UserEntity existingUsername = userService.findUserByUsername(user.getUsername());
        if (existingUsername != null
        && existingUsername.getUsername() != null
        && !existingUsername.getUsername().isEmpty()) {
            result.rejectValue("username", "There is already a user registered with that username");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/clubs?success=true";
    }
}
