package com.idividends.data.dto;

import org.springframework.http.HttpStatus;

import com.idividends.data.schemas.remote.StockQuote;

public class StockQuoteWrapper {

	private StockQuote stock;
	private HttpStatus status;
	private String customError;
	private String cause;
	private String detailedMessage;

	/**
	 * @return the stock
	 */
	public StockQuote getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(StockQuote stock) {
		this.stock = stock;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the customError
	 */
	public String getCustomError() {
		return customError;
	}

	/**
	 * @param customError
	 *            the customError to set
	 */
	public void setCustomError(String customError) {
		this.customError = customError;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @param cause
	 *            the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @return the detailedMessage
	 */
	public String getDetailedMessage() {
		return detailedMessage;
	}

	/**
	 * @param detailedMessage
	 *            the detailedMessage to set
	 */
	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

}
