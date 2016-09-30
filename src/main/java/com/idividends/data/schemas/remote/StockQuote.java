
package com.idividends.data.schemas.remote;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Name",
    "Symbol",
    "LastPrice",
    "Change",
    "ChangePercent",
    "Timestamp",
    "MSDate",
    "MarketCap",
    "Volume",
    "ChangeYTD",
    "ChangePercentYTD",
    "High",
    "Low",
    "Open"
})
public class StockQuote {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Symbol")
    private String symbol;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastPrice")
    private Double lastPrice;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Change")
    private Double change;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ChangePercent")
    private Double changePercent;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Timestamp")
    private String timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MSDate")
    private Double mSDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MarketCap")
    private Integer marketCap;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Volume")
    private Integer volume;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ChangeYTD")
    private Double changeYTD;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ChangePercentYTD")
    private Double changePercentYTD;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("High")
    private Integer high;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Low")
    private Double low;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Open")
    private Double open;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     * @param name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The symbol
     */
    @JsonProperty("Symbol")
    public String getSymbol() {
        return symbol;
    }

    /**
     * 
     * (Required)
     * 
     * @param symbol
     *     The Symbol
     */
    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lastPrice
     */
    @JsonProperty("LastPrice")
    public Double getLastPrice() {
        return lastPrice;
    }

    /**
     * 
     * (Required)
     * 
     * @param lastPrice
     *     The LastPrice
     */
    @JsonProperty("LastPrice")
    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The change
     */
    @JsonProperty("Change")
    public Double getChange() {
        return change;
    }

    /**
     * 
     * (Required)
     * 
     * @param change
     *     The Change
     */
    @JsonProperty("Change")
    public void setChange(Double change) {
        this.change = change;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The changePercent
     */
    @JsonProperty("ChangePercent")
    public Double getChangePercent() {
        return changePercent;
    }

    /**
     * 
     * (Required)
     * 
     * @param changePercent
     *     The ChangePercent
     */
    @JsonProperty("ChangePercent")
    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The timestamp
     */
    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     * @param timestamp
     *     The Timestamp
     */
    @JsonProperty("Timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The mSDate
     */
    @JsonProperty("MSDate")
    public Double getMSDate() {
        return mSDate;
    }

    /**
     * 
     * (Required)
     * 
     * @param mSDate
     *     The MSDate
     */
    @JsonProperty("MSDate")
    public void setMSDate(Double mSDate) {
        this.mSDate = mSDate;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The marketCap
     */
    @JsonProperty("MarketCap")
    public Integer getMarketCap() {
        return marketCap;
    }

    /**
     * 
     * (Required)
     * 
     * @param marketCap
     *     The MarketCap
     */
    @JsonProperty("MarketCap")
    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The volume
     */
    @JsonProperty("Volume")
    public Integer getVolume() {
        return volume;
    }

    /**
     * 
     * (Required)
     * 
     * @param volume
     *     The Volume
     */
    @JsonProperty("Volume")
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The changeYTD
     */
    @JsonProperty("ChangeYTD")
    public Double getChangeYTD() {
        return changeYTD;
    }

    /**
     * 
     * (Required)
     * 
     * @param changeYTD
     *     The ChangeYTD
     */
    @JsonProperty("ChangeYTD")
    public void setChangeYTD(Double changeYTD) {
        this.changeYTD = changeYTD;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The changePercentYTD
     */
    @JsonProperty("ChangePercentYTD")
    public Double getChangePercentYTD() {
        return changePercentYTD;
    }

    /**
     * 
     * (Required)
     * 
     * @param changePercentYTD
     *     The ChangePercentYTD
     */
    @JsonProperty("ChangePercentYTD")
    public void setChangePercentYTD(Double changePercentYTD) {
        this.changePercentYTD = changePercentYTD;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The high
     */
    @JsonProperty("High")
    public Integer getHigh() {
        return high;
    }

    /**
     * 
     * (Required)
     * 
     * @param high
     *     The High
     */
    @JsonProperty("High")
    public void setHigh(Integer high) {
        this.high = high;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The low
     */
    @JsonProperty("Low")
    public Double getLow() {
        return low;
    }

    /**
     * 
     * (Required)
     * 
     * @param low
     *     The Low
     */
    @JsonProperty("Low")
    public void setLow(Double low) {
        this.low = low;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The open
     */
    @JsonProperty("Open")
    public Double getOpen() {
        return open;
    }

    /**
     * 
     * (Required)
     * 
     * @param open
     *     The Open
     */
    @JsonProperty("Open")
    public void setOpen(Double open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(symbol).append(lastPrice).append(change).append(changePercent).append(timestamp).append(mSDate).append(marketCap).append(volume).append(changeYTD).append(changePercentYTD).append(high).append(low).append(open).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StockQuote) == false) {
            return false;
        }
        StockQuote rhs = ((StockQuote) other);
        return new EqualsBuilder().append(name, rhs.name).append(symbol, rhs.symbol).append(lastPrice, rhs.lastPrice).append(change, rhs.change).append(changePercent, rhs.changePercent).append(timestamp, rhs.timestamp).append(mSDate, rhs.mSDate).append(marketCap, rhs.marketCap).append(volume, rhs.volume).append(changeYTD, rhs.changeYTD).append(changePercentYTD, rhs.changePercentYTD).append(high, rhs.high).append(low, rhs.low).append(open, rhs.open).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
