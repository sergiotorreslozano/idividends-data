package com.idividends.data.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idividends.data.client.Client;
import com.idividends.data.domain.Stock;
import com.idividends.data.dto.StockDto;
import com.idividends.data.dto.StockQuoteWrapper;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.dto.TaskResult;
import com.idividends.data.error.StockException;
import com.idividends.data.repository.StockRepository;
import com.idividends.data.schemas.remote.StockQuote;
import com.idividends.data.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private Mapper mapper;

	@Autowired
	private Client restClient;

	public TaskDto run() {
		TaskDto result = new TaskDto();
		List<Stock> stocks = stockRepository.findAll();
		StockQuoteWrapper wrapper = null;
		for (Stock stock : stocks) {
			wrapper = restClient.findStock(stock.getSymbol());
			switch (wrapper.getStatus()) {
			case OK:
				result.setResult(TaskResult.SUCCESS);
				stock.setSyncCode(TaskResult.SUCCESS.getCode());
				updateInformation(stock, wrapper.getStock());
				break;

			default:
				result.setResult(TaskResult.ERROR_NO_RESULT);
				break;
			}
		}
		return result;
	}

	public Stock updateInformation(Stock stock, StockQuote remote) {
		mapper.map(remote, stock);
		return stockRepository.save(stock);
	}

	public Stock findOne(String symbol) {
		Stock result = stockRepository.findBySymbol(symbol);
		if(result == null){
			throw new StockException("Stock not found by symbol: " + symbol);
		}
		return result;
	}

	public Stock save(StockDto stock) {
		Stock result = stockRepository.findBySymbol(stock.getSymbol());
		if (result != null) {
			throw new StockException("The stock already exists: " + stock.getSymbol());
		}
		Stock toSave = new Stock(stock.getSymbol(), stock.getMarket(), stock.getName());
		return stockRepository.save(toSave);
	}

	public Stock update(String symbol, StockDto stockDto) {
		Stock result = stockRepository.findBySymbol(symbol);
		if (result == null) {
			throw new StockException("Stock not found by symbol: " + symbol);
		}
		result.setName(stockDto.getName());
		result.setMarket(stockDto.getMarket());
		return stockRepository.save(result);
	}

}
