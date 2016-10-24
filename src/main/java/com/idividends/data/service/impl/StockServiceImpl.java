package com.idividends.data.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idividends.data.client.Client;
import com.idividends.data.domain.Stock;
import com.idividends.data.dto.StockQuoteWrapper;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.dto.TaskResult;
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

	@Override
	public Stock findOne(Long id) {
		return stockRepository.findOne(id);
	}

	@Override
	public Stock save(Stock stock) {
		Stock toSave = new Stock(stock.getSymbol(), stock.getMarket(), stock.getName());
		return stockRepository.save(toSave);
	}

}
