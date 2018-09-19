package com.codeup.investible.controllers.;

import com.blog.blog.models.Post;
import com.blog.blog.services.PostService;
import com.codeup.investible.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/posts/create")
    public String postCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String postEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
        // postSvc.save(post);
        System.out.println("Post updated!");
        return "redirect:/posts";
    }

}
