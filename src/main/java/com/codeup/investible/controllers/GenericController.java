package com.codeup.investible.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/**")
    public String redirectHome(){
        return "redirect:/";
    }

    @GetMapping("/glossary")
    public String glossary(){
        return "glossary";
    }

    @GetMapping("/about-us")
    public String about(){
        return "about";
    }
}
