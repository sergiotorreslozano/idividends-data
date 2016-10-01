package com.idividends.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String symbol;

	@Column(nullable = false)
	private String marker;

	/**
	 * 
	 */
	public Stock() {
		super();
	}

	/**
	 * @param symbol
	 * @param marker
	 */
	public Stock(String symbol, String marker) {
		super();
		this.symbol = symbol;
		this.marker = marker;
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
	 * @return the marker
	 */
	public String getMarker() {
		return marker;
	}

	/**
	 * @param marker
	 *            the marker to set
	 */
	public void setMarker(String marker) {
		this.marker = marker;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

}
