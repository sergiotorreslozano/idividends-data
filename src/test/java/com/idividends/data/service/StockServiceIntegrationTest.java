package com.idividends.data.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
import com.idividends.data.error.StockException;
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

	@Test(expected = StockException.class)
	public void findOneExceptionTest() {
		stockService.findOne("nothing");
	}

	@Test
	public void findOneTest() {
		stockRepository.save(new Stock("symbol", "market", "name"));
		assertEquals(stockService.findOne("symbol").getName(), "name");
	}

	@Test
	public void findAllTest() {
		List<Stock> expected = stockService.findAll();
		assertEquals(0, expected.size());
		stockRepository.save(new Stock("symbol", "market", "name"));
		stockRepository.save(new Stock("symbol2", "market2", "name2"));
		expected = stockService.findAll();
		assertEquals(2, expected.size());
	}

}
