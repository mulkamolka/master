package com.example.javaserver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.javaserver.entity.AgricproductWholesale;
import com.example.javaserver.entity.SearchList;
import com.example.javaserver.repository.AgricproductWholesaleRepository;
import com.example.javaserver.repository.SearchListRepository;

@SpringBootApplication
public class JavaserverApplication {

	@Autowired
	SearchListRepository listRepo;

	public static void main(String[] args) {

		SpringApplication.run(JavaserverApplication.class, args);

		// Auto Set,Del
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR, 02);
		date.set(Calendar.AM_PM, Calendar.AM);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);

		Timer timer = new Timer();

		SimpleDateFormat Format = new SimpleDateFormat("HHmm");

		String HOUR = Format.format(date.getTime());

		// 02시가 되면 Update Table
		TimerTask TimerTask = new TimerTask() {

			@Autowired
			SearchListRepository listRepo;

			@Autowired
			AgricproductWholesaleRepository agriWholesaleRepo;

			@Override
			public void run() {
				if (HOUR.equals("0200")) {
					List<AgricproductWholesale> productList = agriWholesaleRepo.findAll();

					HashSet<String> pGroupHashSet = new HashSet<>();
					for (int i = 0; productList.size() >= i + 1; i++) {
						pGroupHashSet.add(productList.get(i).getPGroup());
					}

					List<String> pGroupList = new ArrayList<>();
					pGroupList.addAll(pGroupHashSet);

					List<AgricproductWholesale> pGroupArray = new ArrayList<>();

					for (int u = 0; pGroupList.size() >= u + 1; u++) {
						List<AgricproductWholesale> productListgroupBy = agriWholesaleRepo
								.findBypGroup(pGroupList.get(u));
						pGroupArray.add(productListgroupBy.get(0));
					}

					Map<String, BigDecimal> returnButtonHashMap = new HashMap<>();

					for (int o = 0; pGroupArray.size() >= o + 1; o++) {
						try {

							BigDecimal dpr1 = new BigDecimal(
									pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(0).getPrice()
											.toPlainString());
							if (pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice() != null) {

								BigDecimal dpr2 = new BigDecimal(
										pGroupArray.get(o).getAgricProduct().get(0).getPrice().get(1).getPrice()
												.toPlainString());

								BigDecimal substract = dpr1.subtract(dpr2);

								BigDecimal percentage = substract.divide(dpr1, 2, RoundingMode.CEILING);

								returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), percentage);

							} else {
								BigDecimal exceptionNum = BigDecimal.ONE;

								returnButtonHashMap.put(pGroupArray.get(o).getPGroup(), exceptionNum);
							}

						} catch (NullPointerException e) {
							System.out.println("@@@ NullPointerException Check @@@");

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
										(((entries.get(entries.size() - q - 1).getValue()).multiply(ten).toPlainString()
												+ "%")))
								.build();

						asd.add(dd);
					}

					listRepo.saveAll(asd);

				}else{
                    timer.cancel();
                }

			}

		};

			// 02시가 되면 Delete Data
		TimerTask TimerTask2 = new TimerTask() {

			@Autowired
			SearchListRepository listRepo;

			// 02시가 되면 fn_PVConnect 메소드 실행
			@Override
			public void run() {
				if (HOUR.equals("0200")) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar c1 = Calendar.getInstance();
					c1.add(Calendar.DATE, -1);
					String strYesterday = sdf.format(c1.getTime());
					listRepo.deleteBydate(strYesterday);
				}else{
                    timer.cancel();
                }
			}

		};
		// scheduleAtFixedRate(TimerTask 클래스의 run 메소드 실행, 수행시간, 수행주기)
		timer.scheduleAtFixedRate(TimerTask, 0, 10000);
		timer.scheduleAtFixedRate(TimerTask2, 30000, 10000);

		
	}

}
