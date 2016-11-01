package com.idividends.data.dto;

public class StockDto {

	private String symbol;

	private String market;

	private String name;

	public StockDto() {

	}

	/**
	 * @param symbol
	 * @param market
	 * @param name
	 */
	public StockDto(String symbol, String market, String name) {
		super();
		this.symbol = symbol;
		this.market = market;
		this.name = name;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the market
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * @param market
	 *            the market to set
	 */
	public void setMarket(String market) {
		this.market = market;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
