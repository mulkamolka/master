package com.example.javaserver.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.javaserver.dto.object1Dto;
import com.example.javaserver.dto.object2Dto;
import com.example.javaserver.entity.AgricproductWholesale;
import com.example.javaserver.entity.Price;
import com.example.javaserver.entity.SearchList;
import com.example.javaserver.repository.AgricproductWholesaleRepository;
import com.example.javaserver.repository.MarketWholesaleRepository;
import com.example.javaserver.repository.ProductRepository;
import com.example.javaserver.repository.SearchListRepository;
import com.example.javaserver.service.Task1Service;

@Service
@Transactional
public class task1Impl implements Task1Service {

    @Autowired
    MarketWholesaleRepository marketWholesale;

    @Autowired
    AgricproductWholesaleRepository agriWholesaleRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    SearchListRepository listRepo;

    @PersistenceContext
    private EntityManager em;

    // 1. 버튼 클릭시 모든 상품 리스트 전달
    @Override
    @Transactional
    public List<object1Dto> searchButton() {

        List<AgricproductWholesale> productList = agriWholesaleRepo.findByisrepresented(true);

        Map<String, BigDecimal> setHashMap = new HashMap<>();

        for (int i = 0; productList.size() >= i + 1; i++) {
            try {

                BigDecimal dpr1 = new BigDecimal(
                        productList.get(i).getAgricProduct().get(0).getPrice().get(0).getPrice().toPlainString());

                if (productList.get(i).getAgricProduct().get(0).getPrice().get(1).getPrice() != null) {

                    BigDecimal dpr2 = new BigDecimal(
                            productList.get(i).getAgricProduct().get(0).getPrice().get(1).getPrice().toPlainString());

                    BigDecimal substract = dpr1.subtract(dpr2);

                    BigDecimal percentage = substract.divide(dpr1, 2, RoundingMode.CEILING);

                    setHashMap.put(productList.get(i).getPGroup(), percentage);

                } else {
                    BigDecimal exceptionNum = BigDecimal.ONE;

                    setHashMap.put(productList.get(i).getPGroup(), exceptionNum);
                }

            } catch (NullPointerException e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            } catch (NumberFormatException e) {
                BigDecimal exceptionNum = BigDecimal.ONE;

                BigDecimal dpr1 = new BigDecimal(
                        "pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice()");
                BigDecimal dpr2 = exceptionNum;

                BigDecimal percentage = dpr1.divide(dpr2);
                setHashMap.put(productList.get(i).getPGroup(), percentage);
            }

        }

        // Map의 value 값으로 정렬
        List<Map.Entry<String, BigDecimal>> entries = new ArrayList<>(setHashMap.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        List<object1Dto> getList = new ArrayList<>();

        BigDecimal ten = BigDecimal.TEN;

        for (int q = 0; entries.size() >= q + 1; q++) {

            object1Dto object1 = object1Dto.builder()
                    .rankNum(q + 1)
                    .pGroupName(entries.get(q).getKey())
                    .percentage(
                            (((entries.get(entries.size() - q - 1).getValue()).multiply(ten).toPlainString() + "%")))
                    .build();

            getList.add(object1);
        }

        return getList;
    }

    // 2. 농산물 도매 물가 리스트
    @Override
    @Transactional
    public List<object1Dto> getAgricPgroup() {

        List<AgricproductWholesale> productList = agriWholesaleRepo.findAll();

        HashSet<String> pGroupHashSet = new HashSet<>();
        for (int i = 0; productList.size() >= i + 1; i++) {
            pGroupHashSet.add(productList.get(i).getPGroup());
        }

        List<String> pGroupList = new ArrayList<>();
        pGroupList.addAll(pGroupHashSet);

        List<AgricproductWholesale> pGroupArray = new ArrayList<>();

        for (int u = 0; pGroupList.size() >= u + 1; u++) {
            List<AgricproductWholesale> productListgroupBy = agriWholesaleRepo.findBypGroup(pGroupList.get(u));
            pGroupArray.add(productListgroupBy.get(0));
        }

        Map<String, BigDecimal> returnButtonHashMap = new HashMap<>();

        for (int o = 0; pGroupArray.size() >= o + 1; o++) {
            try {

                BigDecimal dpr1 = new BigDecimal(
                        pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice().toPlainString());
                if (pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice() != null) {

                    BigDecimal dpr2 = new BigDecimal(
                            pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice().toPlainString());

                    BigDecimal substract = dpr1.subtract(dpr2);

                    BigDecimal percentage = substract.divide(dpr1, 2, RoundingMode.CEILING);

                    returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), percentage);

                } else {
                    BigDecimal exceptionNum = BigDecimal.ONE;

                    returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), exceptionNum);
                }

            } catch (NullPointerException e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            } catch (NumberFormatException e) {
                BigDecimal exceptionNum = BigDecimal.ONE;

                BigDecimal dpr1 = new BigDecimal(
                        "pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice()");
                BigDecimal dpr2 = exceptionNum;

                BigDecimal percentage = dpr1.divide(dpr2);
                returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), percentage);
            }

        }

        // Map의 value 값으로 정렬
        List<Map.Entry<String, BigDecimal>> entries = new ArrayList<>(returnButtonHashMap.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        List<object1Dto> asd = new ArrayList<>();

        BigDecimal ten = BigDecimal.TEN;

        for (int q = 0; entries.size() >= q + 1; q++) {

            object1Dto dd = object1Dto.builder()
                    .rankNum(q + 1)
                    .pGroupName(entries.get(q).getKey())
                    .percentage(
                            (((entries.get(entries.size() - q - 1).getValue()).multiply(ten).toPlainString() + "%")))
                    .build();

            asd.add(dd);
        }

        return asd;
    }

    // 3. 검색창에서, 상품 클릭시 카테고리만 먼저 전달
    @Override
    @Transactional
    public List<object2Dto> getCategoryList(String pGroup) {

        List<AgricproductWholesale> findAgrWhole = agriWholesaleRepo.findBypGroup(pGroup);

        List<object2Dto> reObject = new ArrayList<>();

        for (int i = 0; findAgrWhole.size() >= i + 1; i++) {

            object2Dto dd = object2Dto.builder()
                    .categoryCode(findAgrWhole.get(i).getCategoryCode())
                    .kind(findAgrWhole.get(i).getKind())
                    .description(findAgrWhole.get(i).getAgricProduct().get(0).getDescription())
                    .rank(findAgrWhole.get(i).getRank())
                    .unit(findAgrWhole.get(i).getUnit())
                    .categoryCode(findAgrWhole.get(i).getCategoryCode())
                    .pGroup(pGroup)
                    .build();

            reObject.add(dd);
        }

        return reObject;
    }

    // 3-1. 카테고리가 갖는 상품의 가격값 전체 전송

    @Override
    @Transactional
    public List<Price> getPrices(String cCode) {
        List<AgricproductWholesale> findAgrWhole = agriWholesaleRepo.findByCategoryCode(cCode);
        List<Price> returnPrice = new ArrayList<>();
        for (int i = 0; findAgrWhole.size() >= i + 1; i++) {
            returnPrice.addAll(findAgrWhole.get(0).getAgricProduct().get(0).getPrice());
        }

        return returnPrice;
    }





    
    // @@@@@@@@@@@@@@@@@@ 기타 테스트 코드 모음 @@@@@@@@@@@@@@@@@@
    // @@@@@@@@@@@@@@@@@@ 기타 테스트 코드 모음 @@@@@@@@@@@@@@@@@@

    @Override
    @Transactional
    public void setDb() {
        List<AgricproductWholesale> productList = agriWholesaleRepo.findAll();

        HashSet<String> pGroupHashSet = new HashSet<>();
        for (int i = 0; productList.size() >= i + 1; i++) {
            pGroupHashSet.add(productList.get(i).getPGroup());
            // System.out.print(agrList.get(i).getPGroup().toString());
        }

        List<String> pGroupList = new ArrayList<>();
        pGroupList.addAll(pGroupHashSet);

        List<AgricproductWholesale> pGroupArray = new ArrayList<>();

        for (int u = 0; pGroupList.size() >= u + 1; u++) {
            List<AgricproductWholesale> productListgroupBy = agriWholesaleRepo.findBypGroup(pGroupList.get(u));
            pGroupArray.add(productListgroupBy.get(0));
        }

        Map<String, BigDecimal> returnButtonHashMap = new HashMap<>();

        for (int o = 0; pGroupArray.size() >= o + 1; o++) {
            // pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice().toBigInteger();
            // System.out.println(aa);
            try {

                BigDecimal dpr1 = new BigDecimal(
                        pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice().toPlainString());
                if (pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice() != null) {

                    BigDecimal dpr2 = new BigDecimal(
                            pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice().toPlainString());

                    BigDecimal substract = dpr1.subtract(dpr2);

                    BigDecimal percentage = substract.divide(dpr1, 2, RoundingMode.CEILING);

                    returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), percentage);

                } else {
                    BigDecimal exceptionNum = BigDecimal.ONE;

                    returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), exceptionNum);
                }

            } catch (NullPointerException e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            } catch (NumberFormatException e) {
                BigDecimal exceptionNum = BigDecimal.ONE;

                BigDecimal dpr1 = new BigDecimal(
                        "pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice()");
                BigDecimal dpr2 = exceptionNum;

                BigDecimal percentage = dpr1.divide(dpr2);
                returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), percentage);
            }

        }

        // Map의 value 값으로 정렬
        List<Map.Entry<String, BigDecimal>> entries = new ArrayList<>(returnButtonHashMap.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        List<SearchList> asd = new ArrayList<>();

        BigDecimal ten = BigDecimal.TEN;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());

        for (int q = 0; entries.size() >= q + 1; q++) {

            SearchList dd = SearchList.builder()
                    .date(strToday)
                    .rankNum(q + 1)
                    .pgroupName(entries.get(q).getKey())
                    .percentage(
                            (((entries.get(entries.size() - q - 1).getValue()).multiply(ten).toPlainString() + "%")))
                    .build();

            asd.add(dd);
        }

        listRepo.saveAll(asd);

        // return asd;
    }

    @Override
    public void delDb() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, -1);
        String strYesterday = sdf.format(c1.getTime());

        listRepo.deleteBydate(strYesterday);
    }

    // @@@ get Table @@@
    @Override
    @Transactional
    public List<SearchList> getList(String date) {
        List<SearchList> getList = listRepo.findBydate(date);

        return getList;
    }

    @Override
    public List<Object> test() {
        // List<AgricproductWholesale> dd = agriWholesaleRepo.findByjpql();

        Query query = em.createQuery("SELECT m FROM AgricproductWholesale m where m.isrepresented = TRUE ");
        List<Object> dd = new ArrayList<>();

        List resultList = query.getResultList();
        for (Object o : resultList) {
            Object[] result = (Object[]) o;
            System.out.println(result);

            dd.add(o);
        }

        return dd;
    }

}
