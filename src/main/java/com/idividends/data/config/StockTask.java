package com.idividends.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.idividends.data.dto.TaskDto;
import com.idividends.data.service.StockService;

@Configuration
@EnableScheduling
public class StockTask {

	private final static Logger logger = LoggerFactory.getLogger(StockTask.class);

	@Autowired
	private StockService stockService;

	// it is fired each day at 07:05 UTC and at 21:05.
	@Scheduled(cron = "0 5 7,21 * * ?", zone = "UTC")
	public TaskDto updateStocks() {
		logger.info("Starting batch process ");
		TaskDto batch = stockService.run();
		logger.debug("Batch result: " + batch);
		return batch;
	}
}
