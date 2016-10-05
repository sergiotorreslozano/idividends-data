package com.idividends.data.config;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idividends.data.domain.Stock;
import com.idividends.data.schemas.remote.StockQuote;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

	@Autowired
	private Mapper mapper;

	@Test
	public void mapTest() {
		Stock stock = new Stock("symbol", "market", "name");
		StockQuote stockQuote = createStockQuote();
		mapper.map(stockQuote, stock);
		assertEquals(stock.getChange(), stockQuote.getChange());
		assertEquals(stock.getChangePercent(), stockQuote.getChangePercent());
		assertEquals(stock.getChangePercentYTD(), stockQuote.getChangePercentYTD());
		assertEquals(stock.getHigh(), stockQuote.getHigh());
		assertEquals(stock.getLastPrice(), stockQuote.getLastPrice());
		assertEquals(stock.getLow(), stockQuote.getLow());
		assertEquals(stock.getMarketCap(), stockQuote.getMarketCap());
		assertEquals(stock.getmSDate(), stockQuote.getMSDate());
		assertEquals(stock.getOpen(), stockQuote.getOpen());
		assertEquals(stock.getName(), stockQuote.getName());
		assertEquals(stock.getSymbol(), stockQuote.getSymbol());
		assertEquals(stock.getTimestamp(), stockQuote.getTimestamp());
		assertEquals(stock.getVolume(), stockQuote.getVolume());
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

}
