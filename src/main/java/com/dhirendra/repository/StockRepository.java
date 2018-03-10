package com.dhirendra.repository;

/**
 * @author dhirendra
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhirendra.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
