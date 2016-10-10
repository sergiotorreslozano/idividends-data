package com.idividends.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idividends.data.domain.Stock;
import com.idividends.data.service.StockService;

@RestController
public class StockController {

	private final static Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/api/stocks/{id}", method = RequestMethod.GET)
	public @ResponseBody Stock findById(@PathVariable Long id) throws Exception {
		logger.debug("Finding stock with id: " + id);
		return stockService.findOne(id);
	}


}
