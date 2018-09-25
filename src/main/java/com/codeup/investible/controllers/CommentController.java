package com.codeup.investible.controllers;

import com.codeup.investible.Models.Comment;
import com.codeup.investible.Models.Company;
import com.codeup.investible.Models.User;
import com.codeup.investible.Repository.CommentRepository;
import com.codeup.investible.Repository.CompanyRepository;
import com.codeup.investible.Repository.UserRepository;
//import com.codeup.investible.services.CommentService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;


@Controller
    public class CommentController {

    private final CommentRepository commentRepository;
        private final CompanyRepository companyRepo;
        private UserRepository userRepository;

        public CommentController(CommentRepository commentRepository, CompanyRepository companyRepo, UserRepository userRepository) {
            this.commentRepository = commentRepository;
            this.userRepository = userRepository;
            this.companyRepo = companyRepo;
        }

        @PostMapping("/company/{companyId}/comments")
        public String insertPost(@PathVariable Long companyId, @RequestParam(name = "body") String body, @ModelAttribute Comment comment, Model model) {
            System.out.println("get here");
            Company company = companyRepo.findOne(companyId);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("isLoggedIn", user != null);
            comment.setBody(body);
            comment.setTimeStamp(Date.from(Instant.now()));
            comment.setCompany(company);
            comment.setUser(user);
            commentRepository.save(comment);
            return "redirect:/company/${ticker}";
        }

        @GetMapping("/posts/{id}/edit")
        public String postEditForm(@PathVariable long id, Model model) {
            model.addAttribute("post", commentRepository.findOne(id));
            return "posts/edit";
        }

//        @PostMapping("/posts/{id}/edit")
//        public String updatePost(@ModelAttribute Comment comment) {
//            CommentRepository.save(comment);
//            return "redirect:/posts";
//        }

        @PostMapping("/posts/delete")
        public String deletePost(@RequestParam(name = "id") long id){
            commentRepository.delete(id);
            return "redirect:/posts";
        }

        @GetMapping("/find-user/{query}")
        @ResponseBody
        public String findUser(@PathVariable String query){

            User user = userRepository.findByUsername(query);

            System.out.println("user.getEmail() = " + user.getEmail());

            return "testing find by username";

        }

    }

