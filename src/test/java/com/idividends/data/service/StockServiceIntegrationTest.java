package com.idividends.data.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.idividends.data.domain.Stock;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.dto.TaskResult;
import com.idividends.data.repository.StockRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class StockServiceIntegrationTest {

	@Autowired
	private StockService stockService;

	@Autowired
	private StockRepository stockRepository;

	@Test
	public void runOkTest() {
		Stock stock = new Stock("AAPL", "NYSE", "Apple");
		stock = stockRepository.save(stock);
		TaskDto tasks = stockService.run();
		assertEquals(tasks.getResult(), TaskResult.SUCCESS);
		assertEquals(tasks.getResult().getMessage(), "Success");
		assertEquals(stockRepository.findOne(stock.getId()).getName(), "Apple Inc");
	}

}
