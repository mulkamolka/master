package com.example.javaserver.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.example.javaserver.dto.object1Dto;
import com.example.javaserver.dto.object2Dto;
import com.example.javaserver.entity.AgricproductWholesale;
import com.example.javaserver.entity.Price;
import com.example.javaserver.entity.SearchList;

@Service
public interface Task1Service {

    // (구현) 1. 검색 버튼 클릭시 상위 5개, 하위 5개 품목
    public List<object1Dto> searchButton();

    // Test . 테이블 삽입 테스트
    public void setDb();

    // Test . 테이블 삽입 테스트
    public void delDb();

    // (구현) 1-1. 자동화된 테이블에서 get
    public List<SearchList> getList(String date);

    // (구현) 2. 농산물 도매 물가 리스트
    public List<object1Dto> getAgricPgroup();

    // (구현) 3. 검색창에서, 상품 클릭시 카테고리만 먼저 전달
    public List<object2Dto> getCategoryList(String pGroup);

    // (구현) 3-1. 카테고리가 갖는 상품의 가격값 전체 전송
    public List<Price> getPrices(String cCode);

    // (미구현) 4. 농산물 도매 물가 상품 동네 정보


    // Test 
    public List<Object> test();
}
