/**
 * 
 */
package com.dhirendra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhirendra.model.Stock;
import com.dhirendra.service.StockService;

/**
 * @author dhirendra
 *
 */
@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping(value = "api/stocks")
	public List<Stock> getAllStocks() {
		return stockService.getAllStocks();
	}

	@GetMapping(value = "api/stocks/{id}")
	public Optional<Stock> getStock(@PathVariable final Long id) {
		return stockService.getStock(id);
	}
	
	@PutMapping(value = "api/stocks/{id}")
	public Stock updateStock(@PathVariable final Long id, @RequestBody final Stock stock) {
		return stockService.updateStock(id, stock);
	}
	
	@PostMapping(value = "api/stocks")
	public Stock saveStock(@RequestBody final Stock stock) {
		return stockService.saveStock(stock);
	}
	

}
