package com.example.javaserver.serviceTest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.javaserver.dto.AgricproductWholesaleDto;
import com.example.javaserver.entity.AgricproductRetail;
import com.example.javaserver.entity.AgricproductWholesale;


@SpringBootTest
@ComponentScan
public class taskServiceTest {

    @Autowired
    AgricproductWholesaleDto agrw;

    @Autowired
    AgricproductWholesale agrw1;

    @DisplayName(value = "jpqlTest")
    @Test
    public void test1(EntityManager em) {// Dto 사용 ( new 명령어 )
        
            String jpql = "select m from AgricproductWholesale m where isrepresented = 1";
            TypedQuery<AgricproductWholesale> query = em.createQuery(jpql, AgricproductWholesale.class);
            List<AgricproductWholesale> list = query.getResultList();
            for (AgricproductWholesale dto : list) {
                System.out.println("dto : " + dto);
            }
    }


    // - 물가 정보 1일 전 / 금일 데이터 비교 등락율 전달 / 축산물
    // - 해당 항목 포함된 도매 물가 데이터 전달
    @Test
    @DisplayName("List/2")
    public void test2() {

    }

    @Test
    @DisplayName("List/3")
    // - 물가 정보 1일 전 / 금일 데이터 비교 등락율 전달 / 수산물
    // - 해당 항목 포함된 도매 물가 데이터 전달
    public void test3() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
    }

    @Test
    @DisplayName("List/4")
    // - 모든 도매 상품 카테고리 전일 대비 가격 등락률 전달
    public void test4() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
    }

    @Test
    @DisplayName("TestName")
    // - 모든 도매 상품 카테고리 전일 대비 가격 등락률 전달
    public void test5() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
    }

}
