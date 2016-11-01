package com.idividends.data.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.idividends.data.client.Client;
import com.idividends.data.domain.Stock;
import com.idividends.data.dto.StockDto;
import com.idividends.data.dto.StockQuoteWrapper;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.dto.TaskResult;
import com.idividends.data.error.StockException;
import com.idividends.data.repository.StockRepository;
import com.idividends.data.schemas.remote.StockQuote;
import com.idividends.data.service.impl.StockServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceUnitTest {

	@InjectMocks
	private StockServiceImpl stockService;

	@Mock
	private Client restClient;

	@Mock
	private StockRepository stockRepository;

	@Mock
	private Mapper mapper;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(stockRepository.findAll()).thenReturn(createdMockedList());
		Mockito.when(stockRepository.save(Matchers.any(Stock.class))).thenReturn(createMockedStock());
		Mockito.doNothing()
			.when(mapper).map(Mockito.any(StockQuote.class),
				Mockito.any(Stock.class));
	}

	@Test
	public void runOkTest() {
		Mockito.when(restClient.findStock("symbol")).thenReturn(createMockedStockQuoteWrapper(HttpStatus.OK));
		TaskDto tasks = stockService.run();
		assertEquals(tasks.getResult(), TaskResult.SUCCESS);
		assertEquals(tasks.getResult().getMessage(), "Success");
	}

	@Test
	public void runNoResultTest() {
		Mockito.when(restClient.findStock("symbol"))
				.thenReturn(createMockedStockQuoteWrapper(HttpStatus.INTERNAL_SERVER_ERROR));
		TaskDto tasks = stockService.run();
		assertEquals(tasks.getResult(), TaskResult.ERROR_NO_RESULT);
	}

	@Test
	public void updateInformationTest() {
		Stock stock = new Stock("symbol", "market", "name");
		StockQuote remote = createStockQuote();
		stock = stockService.updateInformation(stock, remote);
		assertNotNull(stock);
	}

	@Test
	public void findOneTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString()))
				.thenReturn(new Stock("symbol", "market", "name"));
		assertNotNull(stockService.findOne("something"));
	}

	@Test(expected = StockException.class)
	public void findOneExceptionTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString())).thenReturn(null);
		stockService.findOne("something");
	}

	@Test
	public void saveTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString())).thenReturn(null);
		Mockito.when(stockRepository.save(Matchers.any(Stock.class))).thenReturn(createMockedStock());
		Stock stock = stockService.save(new StockDto("symbol", "market", "name"));
		assertNotNull(stock.getSymbol());
		assertNotNull(stock.getMarket());
		assertNotNull(stock.getName());
	}

	@Test(expected = StockException.class)
	public void saveExceptionTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString())).thenReturn(createMockedStock());
		stockService.save(new StockDto("symbol", "market", "name"));
	}

	@Test
	public void updateTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString())).thenReturn(createMockedStock());
		Mockito.when(stockRepository.save(Matchers.any(Stock.class))).thenReturn(createMockedStock());
		Stock stock = stockService.update("symbol", new StockDto("symbol", "market", "name"));
		assertNotNull(stock.getSymbol());
		assertNotNull(stock.getMarket());
		assertNotNull(stock.getName());
	}

	@Test(expected = StockException.class)
	public void updateExceptionTest() {
		Mockito.when(stockRepository.findBySymbol(Matchers.anyString())).thenReturn(null);
		stockService.update("symbol", new StockDto("symbol", "market", "name"));
	}

	@Test
	public void delete() {
		Mockito.doNothing().when(stockRepository).deleteBySymbol(Mockito.any(String.class));
		stockService.delete("symbol");
	}

	private Stock createMockedStock() {
		return new Stock("symbol", "market", "name");
	}

	private StockQuoteWrapper createMockedStockQuoteWrapper(HttpStatus status) {
		StockQuoteWrapper wrapper = new StockQuoteWrapper();
		wrapper.setStatus(status);
		return wrapper;
	}

	private StockQuote createStockQuote() {
		StockQuote remote = new StockQuote();
		remote.setChange(1.0d);
		remote.setChangePercent(1.0d);
		remote.setChangePercentYTD(1.0d);
		remote.setChangeYTD(1.0d);
		remote.setHigh(1);
		remote.setLastPrice(1.d);
		remote.setLow(1.0d);
		remote.setMarketCap(new BigInteger("1"));
		remote.setMSDate(1.0d);
		remote.setOpen(1.0d);
		remote.setName("name");
		remote.setSymbol("symbol");
		remote.setTimestamp("timestamp");
		remote.setVolume(1);
		return remote;
	}

	private List<Stock> createdMockedList() {
		List<Stock> stocks = new ArrayList<>();
		Stock stock = new Stock("symbol", "market", "name");
		stocks.add(stock);
		return stocks;
	}

}
