package com.codeup.investible;

import java.net.URI;
import com.codeup.investible.Models.Company;
import com.codeup.investible.Repository.CompanyRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class InvestibleApplication {

    static CompanyRepository companyRepo;
    public InvestibleApplication(CompanyRepository companyRepo){
        this.companyRepo = companyRepo;
    }

    public static void main(String[] args) {
        run(InvestibleApplication.class, args);

        seed();


    }

    public static void seed(){
        HttpClient httpclient = HttpClients.createDefault();

        String[] seedTickers = {"gpro", "aapl", "qlys", "newr", "feye", "rpd", "lc", "twlo", "roku", "quot", "run", "sq"};

        for (String ticker : seedTickers) {

            Company currentCompany = new Company();


            try {
                URIBuilder builder = new URIBuilder("https://services.last10k.com/v1/company/" + ticker + "/operations");

                builder.setParameter("formType", "10-K");
                builder.setParameter("filingOrder", "0");

                URI uri = builder.build();
                HttpGet request = new HttpGet(uri);
                request.setHeader("Ocp-Apim-Subscription-Key", ApiKey.getKey());

                HttpResponse response = httpclient.execute(request);
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(EntityUtils.toString(entity));

                if (entity != null) {

//                    Java is converting numbers to exponential notation, may need to revisit this moving forward

                    currentCompany.setName(node.findValue("Company").toString().substring(1, node.findValue("Company").toString().length() - 1 ));

                    currentCompany.setTicker(ticker);
                    currentCompany.setNetIncome(Double.parseDouble(node.findValue("NetIncomeLoss").toString()));
                    if(node.findValue("EarningsPerShareBasic") != null){
                        currentCompany.setEps(Double.parseDouble(node.findValue("EarningsPerShareBasic").toString()));
                    }
                    else if(node.findValue("EarningsPerShareBasicAndDiluted") != null){
                        currentCompany.setEps(Double.parseDouble(node.findValue("EarningsPerShareBasicAndDiluted").toString()));
                    }


                    if(node.findValue("SalesRevenueNet") != null){currentCompany.setSales(Double.parseDouble(node.findValue("SalesRevenueNet").toString()));}
                    else if(node.findValue("Revenues") != null){
                        currentCompany.setSales(Double.parseDouble(node.findValue("Revenues").toString()));
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            try {
                URIBuilder builder = new URIBuilder("https://services.last10k.com/v1/company/" + ticker + "/balancesheet");

                builder.setParameter("formType", "10-K");
                builder.setParameter("filingOrder", "0");

                URI uri = builder.build();
                HttpGet request = new HttpGet(uri);
                request.setHeader("Ocp-Apim-Subscription-Key", ApiKey.getKey());

                HttpResponse response = httpclient.execute(request);
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(EntityUtils.toString(entity));

                if (entity != null) {

                    currentCompany.setTotalAssets(Double.parseDouble(node.findValue("Assets").toString()));
                    currentCompany.setTotalLiabilities(Double.parseDouble(node.findValue("Liabilities").toString()));

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            companyRepo.save(currentCompany);

            try {
                Thread.sleep(31000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}