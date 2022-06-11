package com.example.javaserver.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.javaserver.service.ApiSeoul;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class ApiSeoulImple implements ApiSeoul {

    @Override
    public ArrayList seoulMarketVeg() {

        ArrayList returnVeg = new ArrayList<>();

        try {

            URL url = new URL(
                    "http://openapi.seoul.go.kr:8088/4c63564f71726c6136384147526f4d/json/ListNecessariesPricesService/1/5/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                returnVeg.add(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.toString();
        } catch (IOException e) {
            e.toString();
        }
        System.out.println(returnVeg.toArray().getClass());

        // 데이터 파싱
        
        
        return returnVeg;

    };

    @Override
    public ArrayList seoulMarketMeat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList seoulMarketSea() {
        // TODO Auto-generated method stub
        return null;
    }

}
