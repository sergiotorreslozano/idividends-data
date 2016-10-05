package com.idividends.data.client;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import com.idividends.data.dto.StockQuoteWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientUnitTest {

	@InjectMocks
	private RestClient restClient;

	@Mock
	private RestOperations restOperations;

	@PostConstruct
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void findStockServiceUnavailable() {
		Mockito.when(restOperations.exchange(Matchers.isA(URI.class), Mockito.<HttpMethod> any(),
				Mockito.<HttpEntity<?>> any(), Mockito.<Class<?>> any()))
				.thenThrow(new RestClientException("Mocked Exception", new Throwable("Mocked throwable")));
		StockQuoteWrapper wrapper = restClient.findStock("AAPL");
		assertEquals(wrapper.getStatus(), HttpStatus.SERVICE_UNAVAILABLE);
		assertNotNull(wrapper.getCause());
		assertNotNull(wrapper.getCustomError());
		assertNotNull(wrapper.getDetailedMessage());
	}

	@Test
	public void findStockBadRequest() {
		Mockito.when(restOperations.exchange(Matchers.isA(URI.class), Mockito.<HttpMethod> any(),
				Mockito.<HttpEntity<?>> any(), Mockito.<Class<?>> any()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Mocked message"));
		StockQuoteWrapper wrapper = restClient.findStock("AAPL");
		assertEquals(wrapper.getStatus(), HttpStatus.BAD_REQUEST);
		assertNotNull(wrapper.getCustomError());
		assertNotNull(wrapper.getDetailedMessage());
	}
}
