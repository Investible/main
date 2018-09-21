package com.codeup.investible.controllers;

import com.codeup.investible.Models.Company;
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

        Company thisCompany = companyRepo.findByTicker(ticker);

        viewModel.addAttribute("company", thisCompany);

//        If statement for altering view for positive or negative company

//        if(thisCompany.getEps() <= 0){
//            viewModel.addAttribute("direction", "down");
//        }else{viewModel.addAttribute("direction", "up");}

        return "company/view";
    }
}

