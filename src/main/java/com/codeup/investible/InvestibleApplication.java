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
//
//        HttpClient httpclient = HttpClients.createDefault();
//
//        String[] seedTickers = {"GOOGL", "AAPL", "MSFT", "QLYS", "FEYE", "RPD", "TWLO", "W", "ROKU", "BOX", "PSTG", "GRPN"};
//
//        for (String ticker : seedTickers) {
//
//            Company currentCompany = new Company();
//

//Balance Sheet
//            try {
//                URIBuilder builder = new URIBuilder("https://services.last10k.com/v1/company/" + ticker + "/balancesheet");
//
//                builder.setParameter("formType", "10-K");
//                builder.setParameter("filingOrder", "0");
//
//                URI uri = builder.build();
//                HttpGet request = new HttpGet(uri);
//                request.setHeader("Ocp-Apim-Subscription-Key", ApiKey.getKey());
//
//                HttpResponse response = httpclient.execute(request);
//                HttpEntity entity = response.getEntity();
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode node = mapper.readTree(EntityUtils.toString(entity));
//
//                if (entity != null) {
//
////                    Java is converting numbers to exponential notation, may need to revisit this moving forward
//
//                    currentCompany.setName(node.findValue("Company").toString());
//                    currentCompany.setTicker(ticker);
//                    currentCompany.setTotalAssets(Double.parseDouble(node.findValue("Assets").toString()));
//                    currentCompany.setTotalLiabilities(Double.parseDouble(node.findValue("Liabilities").toString()));
//
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }

//            We have access to balance sheets, equity, ratios, prices, income, stock quote

//            try {
//                URIBuilder builder = new URIBuilder("https://services.last10k.com/v1/company/" + ticker + "/operations");
//
//                builder.setParameter("formType", "10-K");
//                builder.setParameter("filingOrder", "0");
//
//                URI uri = builder.build();
//                HttpGet request = new HttpGet(uri);
//                request.setHeader("Ocp-Apim-Subscription-Key", ApiKey.getKey());
//
//                HttpResponse response = httpclient.execute(request);
//                HttpEntity entity = response.getEntity();
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode node = mapper.readTree(EntityUtils.toString(entity));
//
//                if (entity != null) {

//                    currentCompany.setNetIncome(Double.parseDouble(node.findValue("NetIncomeLoss").toString()));
//                    currentCompany.setEps(Double.parseDouble(node.findValue("EarningsPerShareBasic").toString()));
//                    currentCompany.setSales(Double.parseDouble(node.findValue("SalesRevenueNet").toString()));

//                    System.out.println(node);
//
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
////            companyRepo.save(currentCompany);
//
//            try {
//                Thread.sleep(16000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//
    }
  }
