package com.codeup.investible.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.codeup.investible.services.CompanyService;


@Controller
public class CompanyController {

    private final CompanyService companySvc;

    public CompanyController(CompanyService companySvc) {this.companySvc = companySvc;
    }

    @GetMapping("/companies")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", companySvc.findAll());
        return "companies/index";
    }

    @GetMapping("/companies/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("company", companySvc.findOne(id));
        return "companies/show";
    }
}

