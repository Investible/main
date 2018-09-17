package com.codeup.investible.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String loginForm(Model viewModel){
        System.out.println("hello");
        //viewModel.addAttribute("user", new User());
        return "user/login";
    }

}
