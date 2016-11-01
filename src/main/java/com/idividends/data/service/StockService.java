package com.idividends.data.service;

import com.idividends.data.domain.Stock;
import com.idividends.data.dto.StockDto;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.schemas.remote.StockQuote;

public interface StockService {

	/**
	 * Runs the taks
	 * 
	 * @return the result of the batch
	 */
	TaskDto run();

	/**
	 * updates an stock with the remote information
	 * 
	 * @param stock
	 *            stock to update
	 * @param remote
	 *            remote information
	 * @return an updated stock
	 */
	Stock updateInformation(Stock stock, StockQuote remote);

	/**
	 * Finds one stock
	 * 
	 * @param id
	 *            the id of the stock to find
	 * @return an stock
	 */
	Stock findOne(String symbol);

	/**
	 * Adds a stock
	 * 
	 * @param stockDto
	 *            the stock
	 * 
	 * @return The saved stock
	 */
	Stock save(StockDto stockDto);

	/**
	 * Updates a stock
	 * 
	 * @param symbol
	 *            the symbol to find the stock
	 * @param stockDto
	 *            the new information
	 * @return and updated stock
	 */
	Stock update(String symbol, StockDto stockDto);

	/**
	 * Deletes a stock
	 * 
	 * @param symbol
	 *            symbol of the stock to delete
	 */
	void delete(String symbol);

}
