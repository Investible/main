package com.codeup.investible.controllers;

import com.codeup.investible.Models.Comment;
import com.codeup.investible.Models.Company;
import com.codeup.investible.Repository.CommentRepository;
import com.codeup.investible.Repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class CompanyController {

    private final CompanyRepository companyRepo;
    private final CommentRepository commentsRepo;

    public CompanyController(CompanyRepository companyRepo, CommentRepository commentsRepo) {
        this.companyRepo = companyRepo;
        this.commentsRepo = commentsRepo;
    }

    @GetMapping("/home")
    public String companyIndex(Model viewModel) {
        List<Company> companies = (List<Company>) companyRepo.findAll();
        viewModel.addAttribute("companies", companies);
        for(Company company : companies) {
            List<Comment> comments = company.getComments();
            viewModel.addAttribute("comments", comments);
            System.out.println(comments);
        }
        return "home";
    }

    @GetMapping("/company/{id}")
    public String index(@PathVariable long id, Model viewModel) {
        Company company = companyRepo.findOne(id);
        List<Comment> comments = company.getComments();
        viewModel.addAttribute("company", company);
        viewModel.addAttribute("comments", comments);
        System.out.println(comments);
        Comment comment = new Comment();
        viewModel.addAttribute("comment", comment);
        return "company/view";
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

