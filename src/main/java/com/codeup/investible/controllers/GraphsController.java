package com.codeup.investible.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphsController {


    @GetMapping("/graph")
    public String showGraphs(){
        System.out.println("2");
        return "graphs";
    }

}