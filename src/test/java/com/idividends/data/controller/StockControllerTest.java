package com.idividends.data.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idividends.data.domain.Stock;
import com.idividends.data.dto.StockDto;
import com.idividends.data.repository.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private StockRepository stockRepository;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void cleanUp() {
		// cleaning the data stored
		stockRepository.deleteAll();
	}

	@Test
	public void findOneTest() throws Exception {
		Stock stock = stockRepository.save(new Stock("symbol", "market", "name"));
		mvc.perform(MockMvcRequestBuilders.get("/api/stocks/" + stock.getSymbol()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.name").value("name"));
	}

	@Test
	public void findOneFailTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/stocks/" + 1000).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void addOneTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/stocks")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new StockDto("symbol", "market", "name"))))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id").exists());
	}

	@Test
	public void updateOneTest() throws Exception {
		Stock stock = stockRepository.save(new Stock("symbol", "market", "name"));
		StockDto stockdto = new StockDto("symbol", "newMarket", "newName");
		mvc.perform(MockMvcRequestBuilders.put("/api/stocks/" + stock.getSymbol())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(stockdto))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("newName"))
				.andExpect(jsonPath("$.market").value("newMarket"));
	}

}
