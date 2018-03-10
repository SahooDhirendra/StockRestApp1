/**
 * 
 */
package com.dhirendra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhirendra.model.Stock;
import com.dhirendra.repository.StockRepository;

/**
 * @author dhirendra
 *
 */
@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	
	public List<Stock> getAllStocks() {
		List<Stock> stockList = new ArrayList<>();
		Iterable<Stock> stocks = stockRepository.findAll();
		stocks.forEach(stockList::add);
		return stockList;
	}
	
	public Optional<Stock> getStock(final Long id) {
		return stockRepository.findById(id);
	}
	
	public Stock updateStock(final Long id, final Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Stock saveStock(final Stock stock) {
		return stockRepository.save(stock);
	}

}
