package com.idividends.data.service;

import com.idividends.data.dto.TaskDto;

public interface StockService {

	/**
	 * Runs the batch
	 * 
	 * @return the result of the batch
	 */
	TaskDto run();

}
