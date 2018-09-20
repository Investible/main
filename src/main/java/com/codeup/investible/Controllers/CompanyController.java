package com.codeup.investible.controllers;

import com.codeup.investible.Repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CompanyController {

    private final CompanyRepository companyRepo;

    public CompanyController(CompanyRepository companyRepo) {this.companyRepo = companyRepo;}

    @GetMapping("/companies")
    public String index(Model viewModel) {
        viewModel.addAttribute("companies", companyRepo.findAll());
        return "company/index";
    }

    @GetMapping("/companies/{ticker}")
    public String show(@PathVariable String ticker, Model viewModel) {
        viewModel.addAttribute("company", companyRepo.findByTicker(ticker));
        return "company/view";
    }
}

