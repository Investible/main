package com.codeup.investible.services;

import com.codeup.investible.Models.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    List<Company> companies = new ArrayList<>();

    public CompanyService(){
    }

    public Company findOne(long id) {
        return companies.get((int) id - 1);
    }

    public List<Company> findAll() {
        return companies;
    }

    public void save(Company post) {
        post.setId(companies.size() + 1);
        companies.add(post);
    }

//    private void createStarterPosts() {
//        posts.add(new Post(1,"My family","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos dolore exercitationem impedit, iure non nulla optio saepe sint soluta tenetur velit vero, voluptatem! Animi dignissimos eveniet incidunt?"));
//        posts.add(new Post(2, "My feelings","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos non nulla optio saepe sint soluta tenetur velit vero, voluptatem! Animi dignissimos eveniet incidunt?"));
//        posts.add(new Post(3,"My house","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos dolore exercitationem "));
//
//    }


}