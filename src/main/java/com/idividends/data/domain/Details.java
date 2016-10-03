package com.idividends.data.domain;

import java.math.BigInteger;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Instant instant;

	@Column
	private Double lastPrice;

	@Column
	private Double change;

	@Column
	private Double changePercent;

	@Column
	private String timestamp;

	@Column
	private Double mSDate;

	@Column
	private BigInteger marketCap;

	@Column
	private Integer volume;

	@Column
	private Double changeYTD;

	@Column
	private Double changePercentYTD;

	@Column
	private Integer high;

	@Column
	private Double low;

	@Column
	private Double open;

	@ManyToOne
	@JoinColumn(name = "stock_id", nullable = false)
	private Stock stock;

	/**
	 * 
	 */
	public Details() {
		super();
	}

	/**
	 * @param instant
	 * @param stock
	 */
	public Details(Instant instant, Stock stock) {
		super();
		this.instant = instant;
		this.stock = stock;
	}


	/**
	 * @return the instant
	 */
	public Instant getInstant() {
		return instant;
	}

	/**
	 * @param instant
	 *            the instant to set
	 */
	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	/**
	 * @return the lastPrice
	 */
	public Double getLastPrice() {
		return lastPrice;
	}

	/**
	 * @param lastPrice
	 *            the lastPrice to set
	 */
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * @return the change
	 */
	public Double getChange() {
		return change;
	}

	/**
	 * @param change
	 *            the change to set
	 */
	public void setChange(Double change) {
		this.change = change;
	}

	/**
	 * @return the changePercent
	 */
	public Double getChangePercent() {
		return changePercent;
	}

	/**
	 * @param changePercent
	 *            the changePercent to set
	 */
	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the mSDate
	 */
	public Double getmSDate() {
		return mSDate;
	}

	/**
	 * @param mSDate
	 *            the mSDate to set
	 */
	public void setmSDate(Double mSDate) {
		this.mSDate = mSDate;
	}

	/**
	 * @return the marketCap
	 */
	public BigInteger getMarketCap() {
		return marketCap;
	}

	/**
	 * @param marketCap
	 *            the marketCap to set
	 */
	public void setMarketCap(BigInteger marketCap) {
		this.marketCap = marketCap;
	}

	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * @return the changeYTD
	 */
	public Double getChangeYTD() {
		return changeYTD;
	}

	/**
	 * @param changeYTD
	 *            the changeYTD to set
	 */
	public void setChangeYTD(Double changeYTD) {
		this.changeYTD = changeYTD;
	}

	/**
	 * @return the changePercentYTD
	 */
	public Double getChangePercentYTD() {
		return changePercentYTD;
	}

	/**
	 * @param changePercentYTD
	 *            the changePercentYTD to set
	 */
	public void setChangePercentYTD(Double changePercentYTD) {
		this.changePercentYTD = changePercentYTD;
	}

	/**
	 * @return the high
	 */
	public Integer getHigh() {
		return high;
	}

	/**
	 * @param high
	 *            the high to set
	 */
	public void setHigh(Integer high) {
		this.high = high;
	}

	/**
	 * @return the low
	 */
	public Double getLow() {
		return low;
	}

	/**
	 * @param low
	 *            the low to set
	 */
	public void setLow(Double low) {
		this.low = low;
	}

	/**
	 * @return the open
	 */
	public Double getOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(Double open) {
		this.open = open;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
