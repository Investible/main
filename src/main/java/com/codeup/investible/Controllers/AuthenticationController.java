package com.codeup.investible.controllers;

import com.codeup.investible.Models.User;
import com.codeup.investible.Repository.UserRepository;
import com.codeup.investible.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    private UserRepository users;
    private UserService userSvc;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationController(UserRepository users, UserService userSvc, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.userSvc = userSvc;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, @RequestParam(name ="confirmPassword") String confirmPassword){
        if(users.findByUsername(user.getUsername()) != null){
            return "redirect:/edit?username";
        }
        if(users.findByEmail(user.getEmail()) != null){
            return "redirect:/edit?email";
        }
        if(     !user.getUsername().matches("[a-zA-Z0-9]+") ||
                !user.getPassword().matches("[a-zA-Z0-9]+") ||
                !user.getFirstName().matches("[a-zA-Z0-9]+") ||
                !user.getLastName().matches("[a-zA-Z0-9]+")
                ){
            return "redirect:/edit?char";
        }
        if(!confirmPassword.equals(user.getPassword())){
            return "redirect:/edit?mismatch";
        }
        if(user.getUsername().equals(user.getPassword())){
            return "redirect:/edit?userpass";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile/{id}/edit")
    public String profileEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", users.findOne(id));
        return "user/edit";
    }

    @PostMapping("/profile/{id}/edit")
    public String updatePost(@PathVariable(name = "id") long id,
                             @ModelAttribute User user,
                             @RequestParam(name ="confirmPassword") String confirmPassword,
                             @RequestParam(name = "firstName") String firstName,
                             @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "email") String email
                             ) {

        User existingUser = users.findOne(id);


        user.setId(id);
        user.setUsername(existingUser.getUsername());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        System.out.println(user.getPassword());
        user.setPassword(user.getPassword());
        users.save(user);
        userSvc.authenticate(user);

        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profileView(){
        return "user/profile";
    }

//    public String formChecklist(User user, String confirmPassword){
//        if(users.findByUsername(user.getUsername()) != null){
//            return "redirect:/register?username";
//        }
//        if(users.findByEmail(user.getEmail()) != null){
//            return "redirect:/register?email";
//        }
//        if(     !user.getUsername().matches("[a-zA-Z0-9]+") ||
//                !user.getPassword().matches("[a-zA-Z0-9]+") ||
//                !user.getFirstName().matches("[a-zA-Z0-9]+") ||
//                !user.getLastName().matches("[a-zA-Z0-9]+")
//                ){
//            return "redirect:/register?char";
//        }
//        if(!confirmPassword.equals(user.getPassword())){
//            return "redirect:/register?mismatch";
//        }
//        if(user.getUsername().equals(user.getPassword())){
//            return "redirect:/register?userpass";
//        }
//    }


}

