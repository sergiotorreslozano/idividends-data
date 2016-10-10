package com.idividends.data.service;

import com.idividends.data.domain.Stock;
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
	Stock findOne(Long id);

}
