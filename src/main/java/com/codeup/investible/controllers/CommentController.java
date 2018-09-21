package com.codeup.investible.controllers;

import com.codeup.investible.Models.Comment;
import com.codeup.investible.Models.User;
import com.codeup.investible.Repository.CommentRepository;
import com.codeup.investible.Repository.UserRepository;
//import com.codeup.investible.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
    public class CommentController {

        private final CommentRepository commentRepository;
        private UserRepository userRepository;

        public CommentController(CommentRepository commentRepository, UserRepository userRepository) {
            this.commentRepository = commentRepository;
            this.userRepository = userRepository;
        }

        @GetMapping("/home")
        public String index(Model viewModel) {
            viewModel.addAttribute("comments",commentRepository.findAll() );
            return "comments/comments";
        }

        @GetMapping("/comments/{id}")
        public String show(@PathVariable long id, Model viewModel) {
            viewModel.addAttribute("comment", commentRepository.findOne(id));
            return "comments/show";
        }

        @GetMapping("/posts/create")
        public String postCreateForm(Model model) {
            model.addAttribute("comment", new Comment(id));
            return "posts/create";
        }

//        @PostMapping("/posts/create")
//        public String insertPost(@ModelAttribute Comment comment) {
//            comment.setUser(userRepository.findOne(2L));
//            CommentRepository.save(comment);
//            return "redirect:/posts";
//        }

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

