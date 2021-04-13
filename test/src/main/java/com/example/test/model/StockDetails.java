package com.example.test.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="stock-data")
public class StockDetails {

	@Id
    private ObjectId _id;
	
	@JsonProperty("quarter")
    private int quarter;
	
	@JsonProperty("stock")
    private String stock;
	
	@JsonProperty("date")
    private Date date;
	
	@JsonProperty("open")
    private String open;
	
	@JsonProperty("high")
    private String high;
	
	@JsonProperty("low")
    private String low;
	
	@JsonProperty("close")
    private String close;
	
	@JsonProperty("percent_change_next_weeks_price")
    private String percent_change_next_weeks_price;
	
	@JsonProperty("next_weeks_close")
    private String next_weeks_close;
	
	@JsonProperty("volume")
    private Double volume;
	
	@JsonProperty("percent_change_price")
    private Double percent_change_price;
	
	@JsonProperty("percent_change_volume_over_last_wk")
    private Double percent_change_volume_over_last_wk;
	
	@JsonProperty("previous_weeks_volume")
    private Double previous_weeks_volume;
	
	@JsonProperty("next_weeks_open")
    private Double next_weeks_open;
	
	@JsonProperty("days_to_next_dividend")
    private Double days_to_next_dividend;
	
	@JsonProperty("percent_return_next_dividend")
    private Double percent_return_next_dividend;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}

	public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}

	public String getNext_weeks_close() {
		return next_weeks_close;
	}

	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getPercent_change_price() {
		return percent_change_price;
	}

	public void setPercent_change_price(Double percent_change_price) {
		this.percent_change_price = percent_change_price;
	}

	public Double getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}

	public void setPercent_change_volume_over_last_wk(Double percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}

	public Double getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}

	public void setPrevious_weeks_volume(Double previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}

	public Double getNext_weeks_open() {
		return next_weeks_open;
	}

	public void setNext_weeks_open(Double next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}

	public Double getDays_to_next_dividend() {
		return days_to_next_dividend;
	}

	public void setDays_to_next_dividend(Double days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}

	public Double getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}

	public void setPercent_return_next_dividend(Double percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	public StockDetails(ObjectId _id, int quarter, String stock, Date date, String open, String high, String low,
			String close, String percent_change_next_weeks_price, String next_weeks_close, Double volume,
			Double percent_change_price, Double percent_change_volume_over_last_wk, Double previous_weeks_volume,
			Double next_weeks_open, Double days_to_next_dividend, Double percent_return_next_dividend) {
		super();
		this._id = _id;
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
		this.next_weeks_close = next_weeks_close;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
		this.previous_weeks_volume = previous_weeks_volume;
		this.next_weeks_open = next_weeks_open;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
    
}
