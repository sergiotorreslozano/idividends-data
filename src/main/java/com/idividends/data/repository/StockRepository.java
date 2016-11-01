package com.idividends.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.idividends.data.domain.Stock;

@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {

	/**
	 * Finds one Stock by its symbol
	 * 
	 * @param symbol
	 *            the stock symbol
	 * @return a Stock
	 */
	Stock findBySymbol(String symbol);

	/**
	 * Deletes an Stock by its symbol
	 * 
	 * @param symbol
	 *            the stock symbol
	 */
	void deleteBySymbol(String symbol);

}
