package com.codeup.investible.controllers;

import com.codeup.investible.Repository.CompanyRepository;
import com.codeup.investible.Repository.UserRepository;
import com.codeup.investible.Services.CommentService;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    private final CommentService commentService;
    UserRepository userRepository;
    CompanyRepository companyRepository;

    public CommentController(CommentService commentService, UserRepository userRepository, CompanyRepository companyRepository){
        this.commentService = commentService;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

}
