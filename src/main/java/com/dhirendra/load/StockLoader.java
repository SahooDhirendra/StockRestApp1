/**
 * 
 */
package com.dhirendra.load;

/**
 * @author dhirendra
 *
 */
import com.dhirendra.model.Stock;
import com.dhirendra.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockLoader {

	@Autowired
	StockRepository stockRepository;

	@PostConstruct
	@Transactional
	public void loadAll() {
		stockRepository.saveAll(getData());

	}

	private List<Stock> getData() {
		List<Stock> listStock = new ArrayList<>();
		listStock.add(new Stock(1L, "Dhirendra", new BigDecimal(15000), new Timestamp(System.currentTimeMillis())));
		listStock.add(new Stock(2L, "Sahoo", new BigDecimal(25000), new Timestamp(System.currentTimeMillis())));
		listStock.add(new Stock(3L, "Kumar", new BigDecimal(35000), new Timestamp(System.currentTimeMillis())));

		return listStock;
	}
}
