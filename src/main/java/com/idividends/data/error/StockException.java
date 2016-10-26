package com.idividends.data.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockException extends RuntimeException {

	private static final long serialVersionUID = -455205535439905875L;

	public StockException(String message) {
		super(message);
	}
}
