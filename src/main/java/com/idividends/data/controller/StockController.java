package com.idividends.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idividends.data.domain.Stock;
import com.idividends.data.dto.Result;
import com.idividends.data.dto.StockDto;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.service.StockService;

@RestController
public class StockController {

	private final static Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/api/stocks/{symbol}", method = RequestMethod.GET)
	public @ResponseBody Stock findBySymbol(@PathVariable String symbol) throws Exception {
		logger.debug("Finding stock with id: " + symbol);
		return stockService.findOne(symbol);
	}

	@RequestMapping(value = "/api/stocks", method = RequestMethod.GET)
	public @ResponseBody Result findAll() throws Exception {
		logger.debug("Finding all stocks");
		return new Result(stockService.findAll());
	}

	@RequestMapping(value = "/api/stocks", method = RequestMethod.POST)
	public @ResponseBody Stock addStock(@RequestBody StockDto stock) throws Exception {
		logger.debug("Adding stock with ticker: " + stock.getSymbol());
		return stockService.save(stock);
	}

	@RequestMapping(value = "/api/stocks/{symbol}", method = RequestMethod.PUT)
	public @ResponseBody Stock updateStock(@PathVariable String symbol, @RequestBody StockDto stock) throws Exception {
		logger.debug("Updating stock with ticker: " + stock.getSymbol());
		return stockService.update(symbol, stock);
	}

	@RequestMapping(value = "/api/stocks/{symbol}", method = RequestMethod.DELETE)
	public ResponseEntity<Stock> updateStock(@PathVariable String symbol) throws Exception {
		logger.debug("Deleting stock with ticker: " + symbol);
		stockService.delete(symbol);
		return new ResponseEntity<Stock>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/api/stocks/updateall", method = RequestMethod.POST)
	public @ResponseBody TaskDto updateAllStock()
			throws Exception {
		logger.debug("Updating all the stocks ");
		return stockService.run();
	}
}
