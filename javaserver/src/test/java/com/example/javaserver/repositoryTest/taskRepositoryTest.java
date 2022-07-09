package com.example.javaserver.repositoryTest;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;

import com.example.javaserver.dto.AgricproductRetailDto;
import com.example.javaserver.entity.AgricproductRetail;
import com.example.javaserver.entity.AgricproductWholesale;
import com.example.javaserver.entity.MarketRetail;
import com.example.javaserver.entity.MarketWholesale;
import com.example.javaserver.entity.Price;
import com.example.javaserver.entity.Product;
import com.example.javaserver.repository.AgricproductRetailRepository;
import com.example.javaserver.repository.AgricproductWholesaleRepository;
import com.example.javaserver.repository.MarketRetailRepository;
import com.example.javaserver.repository.MarketWholesaleRepository;
import com.example.javaserver.repository.PriceRepository;
import com.example.javaserver.repository.ProductRepository;

@SpringBootTest
public class taskRepositoryTest {

    @Autowired
    AgricproductRetailRepository agrRepo;

    @Autowired
    AgricproductWholesaleRepository agrWRepo;

    @Autowired
    ProductRepository proRepo;

    @Autowired
    PriceRepository priceRepo;

    @Autowired
    MarketRetailRepository marketRetailRepo;

    @Autowired
    MarketWholesaleRepository marketWholeRepo;

    @Test
    @DisplayName("AgricproductRetail")
    public void test1() {
        AgricproductRetail agricproductRetail = AgricproductRetail.builder()
                .categoryCode("1")
                .pGroup("pGroup")
                .unit("unit")
                .build();

        agrRepo.save(agricproductRetail);

    }

    @Test
    @DisplayName("product")
    public void test2() {
        Product product = Product.builder()
                .pCode("pCode")
                .pName("pName")
                .description("description")
                .build();

        proRepo.save(product);

    }

    @Test
    @DisplayName("price")
    public void test3() {
        Price price = Price.builder()
                .id(1L)
                .date("2000-01-01")
                .build();

        priceRepo.save(price);

    }

    @Test
    @DisplayName("marketRetail")
    public void test4() {

        MarketRetail marketR = MarketRetail.builder()
                .mCode("mCode")
                .mName("mName")
                .mType(2)
                // .x(1234.1234)
                // .y(412312.512413)
                // .loc(x y)
                .build();

        marketRetailRepo.save(marketR);

    }

    @Test
    @DisplayName("marketWholesale")
    public void test5() {

        MarketWholesale marketW = MarketWholesale.builder()
                .mCode("mCode")
                .mOrigin("mOrigin")
                .build();

        marketWholeRepo.save(marketW);
    }

    // @@@@ 소매 테이블 값 입력 Test @@@@

    @Test
    @DisplayName("Retail")
    public void Retail() {

        // 소매 값 입력 순서

        // 1-1. 상품 카테고리 생성
        AgricproductRetail agricproductRetail1 = AgricproductRetail.builder()
                .categoryCode("1")
                .pGroup("사과")
                .unit("1Kg")

                .build();

        AgricproductRetail agricproductRetail2 = AgricproductRetail.builder()
                .categoryCode("2")
                .pGroup("배")
                .unit("1Kg")

                .build();

        // AgricproductRetail agricproductRetail3 = AgricproductRetail.builder()
        // .categoryCode("3")
        // .pGroup("상추")
        // .unit("3Kg")
        // .build();

        // AgricproductRetail agricproductRetail4 = AgricproductRetail.builder()
        // .categoryCode("4")
        // .pGroup("오이")
        // .unit("3Kg")
        // .build();

        // 2. 일별 가격 목록 생성
        ArrayList<Price> prices1 = new ArrayList<>();
        ArrayList<Price> prices2 = new ArrayList<>();

        Price price1 = Price.builder()
                .id(1L)
                .date("2000-01-01")
                .price(BigDecimal.valueOf(11111.111111))
                .build();

        Price price2 = Price.builder()
                .id(2L)
                .date("2000-01-02")
                .price(BigDecimal.valueOf(22222.222222))
                .build();

        Price price3 = Price.builder()
                .id(3L)
                .date("2000-01-01")
                .price(BigDecimal.valueOf(33333.333333))
                .build();

        Price price4 = Price.builder()
                .id(4L)
                .date("2000-01-02")
                .price(BigDecimal.valueOf(44444.444444))
                .build();

        prices1.add(price1);
        prices1.add(price2);

        prices2.add(price3);
        prices2.add(price4);

        // 3. 상품 생성

        ArrayList<Product> products = new ArrayList<>();

        Product product1 = Product.builder()
                .pCode("상품 코드")
                .pName("상품 이름")
                .description("상품 설명")
                .agriRetail(agricproductRetail1)
                .price(prices1)

                .build();

        Product product2 = Product.builder()

                .pCode("상품 코드2")
                .pName("상품 이름2")
                .description("상품 설명2")
                .agriRetail(agricproductRetail2)
                .price(prices2)
                .build();

        products.add(product1);
        products.add(product2);

        // 4. 마켓 생성

        MarketRetail market1 = MarketRetail.builder()
                .mCode("시장 코드")
                .mName("시장 이름")
                .mType(2)
                .productR(products)
                // .x(1234.1234)
                // .y(412312.512413)
                // .loc(x y)
                .build();

        // ___________ 저장 _________

        // lv.1 저장

        // priceRepo.save(price1);
        // priceRepo.save(price2);
        // priceRepo.save(price3);
        // priceRepo.save(price4);

        // proRepo.save(product1);

        marketRetailRepo.save(market1);
        agrRepo.save(agricproductRetail1);

        // lv.2 저장

    }
    // 도매 테이블 값 입력 Test

    @Test
    @DisplayName("Wholesale")
    public void wholesale() {

        // 도매 값 입력 순서

        // 3. 일별 가격 목록 생성

        ArrayList<Price> prices1 = new ArrayList<>();
        ArrayList<Price> prices2 = new ArrayList<>();

        Price price1 = Price.builder()
                .id(5L)
                .date("2000-03-01")
                .price(BigDecimal.valueOf(11111.111111))
                .build();

        Price price2 = Price.builder()
                .id(6L)
                .date("2000-03-02")
                .price(BigDecimal.valueOf(22222.222222))
                .build();

        Price price3 = Price.builder()
                .id(7L)
                .date("2000-03-01")
                .price(BigDecimal.valueOf(33333.333333))
                .build();

        Price price4 = Price.builder()
                .id(8L)
                .date("2000-03-02")
                .price(BigDecimal.valueOf(44444.444444))
                .build();

        prices1.add(price1);
        prices1.add(price2);

        prices2.add(price3);
        prices2.add(price4);

        // 4. 상품 생성

        ArrayList<Product> products = new ArrayList<>();

        Product product1 = Product.builder()
                .pCode("pCode333")
                .pName("상품 333")
                .description("상품 설명333")
                .price(prices1)
                .build();

        Product product2 = Product.builder()
                .pCode("pCode444")
                .pName("상품 444")
                .description("상품 설명444")
                .price(prices2)
                .build();

        products.add(product1);
        products.add(product2);

        MarketWholesale marketWholesale1 = MarketWholesale.builder()
                .mCode("mCode333")
                .mOrigin("mOrigin")
                .productW(products)
                .build();

        // 1. 상품 카테고리 생성
        AgricproductWholesale agricproductWholesale1 = AgricproductWholesale.builder()
                .categoryCode("cCode111")
                .kind("kind1")
                .pGroup("pGroup1")
                .rank("rank1")
                .unit("unit1")
                .agricProduct(products)
                .build();

        AgricproductWholesale agricproductWholesale2 = AgricproductWholesale.builder()
                .categoryCode("cCode222")
                .kind("kind2")
                .pGroup("pGroup2")
                .rank("rank2")
                .unit("unit2")
                .agricProduct(products)
                .build();

        // 4. 마켓 생성
        MarketWholesale marketWholesale2 = MarketWholesale.builder()
                .mCode("mCode333")
                .mOrigin("mOrigin")
                .build();
        // ___________ 저장 _________

        // marketRetailRepo.save(market1);
        // agrRepo.save(agricproductRetail1);
        marketWholeRepo.save(marketWholesale1);
        agrWRepo.save(agricproductWholesale1);

    }

    @Test
    @DisplayName("TestName")
    public void test() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
    }

}
