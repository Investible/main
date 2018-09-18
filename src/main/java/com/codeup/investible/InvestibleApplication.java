package com.codeup.investible;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class InvestibleApplication {

    public static void main(String[] args) {
        run(InvestibleApplication.class, args);
    }



}
