package com.idividends.data.domain;

import java.math.BigInteger;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.dozer.Mapping;

import com.idividends.data.dto.TaskResult;

@Entity(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String symbol;

	@Column(nullable = false)
	private String market;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String syncCode;

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
	@Mapping("mSDate")
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
	public Stock(String symbol, String market, String name) {
		super();
		this.symbol = symbol;
		this.market = market;
		this.name = name;
		syncCode = TaskResult.NOT_SYNC.getCode();
		instant = Instant.now();
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
	 * @return the id
	 */
	public Long getId() {
		return id;
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

	/**
	 * @return the syncCode
	 */
	public String getSyncCode() {
		return syncCode;
	}

	/**
	 * @param syncCode
	 *            the syncCode to set
	 */
	public void setSyncCode(String syncCode) {
		this.syncCode = syncCode;
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

}
