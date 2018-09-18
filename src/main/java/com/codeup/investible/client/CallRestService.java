package com.codeup.investible.client;

import com.codeup.investible.Models.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject("https://services.last10k.com/v1/company/aapl/operations?formType=10-K", Company.class);
        System.out.println("The Company's Net Income is "+ company);
    }


    @Override
    public void run(String... strings) throws Exception {
        callRestService();
    }
}
