package com.codeup.investible.client;// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import com.codeup.investible.Models.Company;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class RestClient
{
    public static void main(String[] args)
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://services.last10k.com/v1/company/aapl/operations");

            builder.setParameter("formType", "10-K");
            builder.setParameter("filingOrder", "0");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "72eec0339d724c9bb456bd5b3ae180bc");


            // Request body
//            StringEntity reqEntity = new StringEntity("{body}");
//            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity statementOfOperations = response.getEntity();

            if (statementOfOperations != null)
            {
                System.out.println(EntityUtils.toString(statementOfOperations));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

