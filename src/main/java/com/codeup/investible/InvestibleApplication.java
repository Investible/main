package com.codeup.investible;

//import java.util.Arrays;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.client.RestTemplate;
//
//
//import com.codeup.investible.Models.Company;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.client.RestTemplate;


import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class InvestibleApplication {

    public static void main(String[] args) {
        run(InvestibleApplication.class, args);


//    }
////package com.coinmarket.rest.application;
//
//
//    //import com.coinmarket.rest.domain.Coin;
//
//    public static class Application {
//
//        private static final Logger log = LoggerFactory.getLogger(Application.class);
//
//        public static void main(String[] args) {
//            RestTemplate restTemplate = new RestTemplate();
//            Company[] companies = restTemplate.getForObject("https://services.last10k.com/v1/company/aapl/operations?formType=10-K&filingOrder=0\n", Company[].class);
//
//
//            // APPLE
//            Object[] appleArray = Arrays.stream(companies).filter(x -> x.getName().equalsIgnoreCase("Apple")).toArray();
//            log.info("Name :" + ((Company) appleArray[0]).getName());
//
//            //log.info(" Price USD :" + Double.valueOf(((Company) appleArray[0]).getNetIncome()));
//
//            //log.info("-------------------------------------------------");
//
////            // DIGIBYTE
////            Object[] digibyteArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("digibyte")).toArray();
////            log.info("Name :" + ((Coin) digibyteArray[0]).getName());
////
////            log.info(" Price USD :" + Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()));
////
////
////            log.info("-------------------------------------------------");
//
//
////            // CARDANO
////            Object[] cardanoArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("cardano")).toArray();
////            log.info("Name :" + ((Coin) cardanoArray[0]).getName());
////
////            log.info(" Price USD :" + Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()));
////
////
////            log.info("-------------------------------------------------");
////
////            // STREAMR
////            Object[] streamRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("streamr DataCoin"))
////                    .toArray();
////            log.info("Name :" + ((Coin) streamRArray[0]).getName());
////
////            log.info(" Price USD :" + Double.valueOf(((Coin) streamRArray[0]).getPrice_usd()));
////
////
////            log.info("----------------------------------------------------");
////
////            //BTC
////            Object[] btcRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin"))
////                    .toArray();
////            log.info("Name :" + ((Coin) btcRArray[0]).getName());
////
////            log.info(" Price USD :" + Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()));
//
//
//        }
//
  }
}