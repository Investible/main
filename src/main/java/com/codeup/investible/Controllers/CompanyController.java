package com.codeup.investible.controllers;

import com.codeup.investible.Models.Comment;
import com.codeup.investible.Models.Company;
import com.codeup.investible.Repository.CommentRepository;
import com.codeup.investible.Repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyController {

    private final CompanyRepository companyRepo;

    public CompanyController(CompanyRepository companyRepo, CommentRepository commentsRepo) {
        this.companyRepo = companyRepo;
    }

    @GetMapping("/companies")
    public String companyIndex(Model viewModel) {

        viewModel.addAttribute("companies", companyRepo.findAll());
        return "company/index";
    }

//    @GetMapping("/companies/{id}")
//    public String index(@PathVariable long id, Model viewModel) {
//        Company company = companyRepo.findOne(id);
//        List<Comment> comments = company.getComments();
//        viewModel.addAttribute("company", company);
//        viewModel.addAttribute("comments", comments);
//        System.out.println(comments);
//        Comment comment = new Comment();
//        viewModel.addAttribute("comment", comment);
//        return "company/view";
//    }

    @GetMapping("/company/{ticker}")
    public String show(@PathVariable String ticker, Model viewModel) {

        Company thisCompany = companyRepo.findByTicker(ticker);

        viewModel.addAttribute("company", thisCompany);
        viewModel.addAttribute("comments", thisCompany.getComments());
        viewModel.addAttribute("comment", new Comment());

        return "company/view";
    }
}

