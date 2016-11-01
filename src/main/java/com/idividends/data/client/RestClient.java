package com.idividends.data.client;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import com.idividends.data.dto.StockQuoteWrapper;
import com.idividends.data.schemas.remote.StockQuote;

@Component
public class RestClient implements Client {

	private final static String STOCK_URL = "STOCK_URL";

	private final static String SUCCESS = "SUCCESS";

	@Autowired
	private RestOperations restOperations;

	public StockQuoteWrapper findStock(String ticker) {
		StockQuoteWrapper quote = new StockQuoteWrapper();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		String url = System.getenv(STOCK_URL);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("symbol", ticker);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		try {
			ResponseEntity<StockQuote> response = restOperations.exchange(builder.build().encode().toUri(),
					HttpMethod.GET, entity, StockQuote.class);
			quote.setStock(response.getBody());
			if (SUCCESS.equals(quote.getStock().getStatus())) {
				quote.setStatus(response.getStatusCode());
			} else {
				quote.setStatus(HttpStatus.NOT_FOUND);
				for (Entry<String, Object> e : quote.getStock().getAdditionalProperties().entrySet()) {
					quote.setDetailedMessage("key: " + e.getKey() + " value: " + e.getValue());
					quote.setCustomError("Wrong information sent: " + ticker + " url: " + url);
				}
			}
		} catch (HttpClientErrorException httpException) {
			quote.setStatus(httpException.getStatusCode());
			quote.setDetailedMessage("Status text: " + httpException.getStatusText() + " response body: "
					+ httpException.getResponseBodyAsString());
			quote.setCustomError("Remote error for ticker: " + ticker + " url: " + url);
		} catch (RestClientException rce) {
			quote.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
			quote.setCause(rce.getCause());
			quote.setDetailedMessage(rce.getMessage());
			quote.setCustomError("Remote error for ticker: " + ticker + " url: " + url);
		}
		return quote;
	}

}
