package com.idividends.data.config;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idividends.data.dto.TaskDto;
import com.idividends.data.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTaskTest {

	@InjectMocks
	private StockTask stockTask;

	@Mock
	private StockService stockService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void updateStocksTest() {
		TaskDto value = new TaskDto();
		Mockito.when(stockService.run()).thenReturn(value);
		TaskDto result = stockTask.updateStocks();
		assertEquals(result.getResult(), value.getResult());
	}

}
