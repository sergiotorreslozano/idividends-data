package com.idividends.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idividends.data.domain.Stock;
import com.idividends.data.dto.TaskDto;
import com.idividends.data.repository.StockRepository;
import com.idividends.data.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public TaskDto run() {
		// TODO Auto-generated method stub
		List<Stock> stocks = stockRepository.findAll();
		return null;
	}


}
