package com.codeup.investible.controllers;

import com.codeup.investible.Models.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CompanyController {

    @GetMapping("/company")
    public String companyIndex(Model model){


//        List<Company> companies = (We need a method for finding a list of companies)
//        model.addAttribute("companies", companies);

        return "company/index";
    }



    @GetMapping("/company/{id}") //Might be better to request by name/ticker
    public String companyShowPage(@PathVariable long id, Model model){

//        Company company = (We need a way of searching for a company by id or name)
//        Model.addAttribute("company", company)

        return "company/view";
    }

}
