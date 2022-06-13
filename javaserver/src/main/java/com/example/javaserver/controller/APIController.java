package com.example.javaserver.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaserver.service.ApiSeoul;
import com.example.javaserver.service.ApiWholesale;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIController {
    
    @Autowired
    ApiWholesale apiWholesale;
    @Autowired
    ApiSeoul apiSeoul;

    // 서울 가격
    @GetMapping("/1")
    public ArrayList seoul() {
        return apiSeoul.seoulMarketVeg();
    }

    // 도,소매 가격 - 채소 200
    @GetMapping("/vegprices")
    public ArrayList vegAPI() {
        return apiWholesale.wholeSalePricesVeg();
    }

    // 도,소매 가격 - ''
    @GetMapping("/meatprices")
    public ArrayList meatAPI() {
        return apiWholesale.wholeSalePricesMeat();
    }

    // 도,소매 가격 - 수산물 600
    @GetMapping("/seaprices")
    public ArrayList seaAPI() {
        return apiWholesale.wholeSalePricesSea();
    }

    // post code 
    @RequestMapping(value = "netPost")
    public void netPost() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"title\":\"test title\",\"body\":\"test body\",\"userId\":1}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            
        }

    }

}