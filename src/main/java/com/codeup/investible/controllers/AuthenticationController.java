package com.codeup.investible.controllers;

import com.codeup.investible.Models.User;
import com.codeup.investible.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    private UserRepository users;
    private PasswordEncoder passwordEncoder;

    public AuthenticationController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, @RequestParam(name ="confirmPassword") String confirmPassword){
        if(users.findByUsername(user.getUsername()) != null){
            return "redirect:/register?username";
        }
        if(users.findByEmail(user.getEmail()) != null){
            return "redirect:/register?email";
        }
        if(     !user.getUsername().matches("[a-zA-Z0-9]+") ||
                !user.getPassword().matches("[a-zA-Z0-9]+") ||
                !user.getFirstName().matches("[a-zA-Z0-9]+") ||
                !user.getLastName().matches("[a-zA-Z0-9]+")
                ){
            return "redirect:/register?char";
        }
        if(!confirmPassword.equals(user.getPassword())){
            return "redirect:/register?mismatch";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        return "redirect:/login";
    }

}
