package com.idividends.data.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.idividends.data.dto.StockQuoteWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientIntegrationTest {

	@Autowired
	private RestClient restClient;

	@Test
	public void findStockTest() {
		String ticker = "AAPL";
		StockQuoteWrapper wrapper = restClient.findStock(ticker);
		assertNotNull(wrapper);
		assertNotNull(wrapper.getStock());
		assertEquals(wrapper.getStatus(), HttpStatus.OK);
	}

	@Test
	public void findStockNotExistsTest() {
		String ticker = "DoesNotExists";
		StockQuoteWrapper wrapper = restClient.findStock(ticker);
		assertNotNull(wrapper);
		assertNotNull(wrapper.getStock());
		assertEquals(wrapper.getStatus(), HttpStatus.OK);
	}

}
