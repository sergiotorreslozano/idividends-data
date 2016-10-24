package com.idividends.data.client;

import com.idividends.data.dto.StockQuoteWrapper;

public interface Client {

	/**
	 * Finds a stock
	 * 
	 * @param ticker
	 *            the ticker (unique per stock)
	 * @return a StockQuoteWrapper with the information the stock information
	 */
	StockQuoteWrapper findStock(String ticker);

}