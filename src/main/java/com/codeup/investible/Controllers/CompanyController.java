package com.codeup.investible.Controllers;

<<<<<<< HEAD:src/main/java/com/codeup/investible/Controllers/CompanyController.java
import com.codeup.investible.Repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import com.codeup.investible.Models.Company;

import com.codeup.investible.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
>>>>>>> afa74ccb0215f5ff304ae63a3ada0f44b8c00b4b:src/main/java/com/codeup/investible/controllers/CompanyController.java

@Controller
public class CompanyController {
    private final CompanyRepository companyRepo;

    public CompanyController(CompanyRepository companyRepo){
        this.companyRepo = companyRepo;
    }

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

