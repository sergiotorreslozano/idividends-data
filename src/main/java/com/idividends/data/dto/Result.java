package com.idividends.data.dto;

import java.util.List;

import com.idividends.data.domain.Stock;

/**
 * Simple wrapper to return a JSON response
 * 
 * @author sergio.torres.lozano
 *
 */
public class Result {

	private List<Stock> stocks;

	/**
	 * @param stocks
	 */
	public Result(List<Stock> stocks) {
		super();
		this.stocks = stocks;
	}


	/**
	 * @return the stocks
	 */
	public List<Stock> getStocks() {
		return stocks;
	}

}
