package com.example.javaserver.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.javaserver.service.ApiWholesale;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class ApiWholsaleImpl implements ApiWholesale{

    @Override
    public ArrayList wholeSalePricesVeg() {

        ArrayList returnList = new ArrayList<>();

        try {

            URL url = new URL(
                    "https://www.kamis.or.kr/service/price/xml.do?action=dailyPriceByCategoryList&p_product_cls_code=02&p_country_code=1101&p_regday=2022-06-02&p_convert_kg_yn=N&p_item_category_code=200&p_cert_key=f08f57bd-4699-4da7-a29f-1f6fa6c1692d&p_cert_id=2535&p_returntype=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            int resCode = conn.getResponseCode();
            // http코드가 301(영구이동), 302(임시 이동), 303(기타 위치 보기) 이면 또다시 이 함수를 태운다. 재귀함수)

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                returnList.add(output);
            }

            // Array => json 변환 과정 필요
            // JSONPObject json = new JSONPObject(function, value)



            conn.disconnect();
        } catch (MalformedURLException e) {
            e.toString();
        } catch (IOException e) {
            e.toString();
        }
        System.out.println(returnList);

        return returnList;

    }



    @Override
    public ArrayList wholeSalePricesMeat() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public ArrayList wholeSalePricesSea() {
        // TODO Auto-generated method stub
        return null;
    }




}
