package com.example.test.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.opencsv.bean.CsvBindByName;

@Document(collection="stock-data")
public class StockDocument {

	@Id
    private ObjectId _id;
	
    private int quarter;
	
    private Date date;
	
    private String open;
	
    private String high;
	
    private String low;
	
    private String close;
	
    private String percent_change_next_weeks_price;
	
    private String next_weeks_close;
	
    private Integer volume;
	
    private Integer percent_change_price;
	
    private Integer percent_change_volume_over_last_wk;
	
    private Integer previous_weeks_volume;
	
    private Integer next_weeks_open;
	
    private Integer days_to_next_dividend;
	
    private Integer percent_return_next_dividend;
    
    private ObjectId stock_Id;
	
	
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
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getPercent_change_price() {
		return percent_change_price;
	}
	public void setPercent_change_price(Integer percent_change_price) {
		this.percent_change_price = percent_change_price;
	}
	public Integer getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}
	public void setPercent_change_volume_over_last_wk(Integer percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}
	public Integer getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}
	public void setPrevious_weeks_volume(Integer previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}
	public Integer getNext_weeks_open() {
		return next_weeks_open;
	}
	public void setNext_weeks_open(Integer next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}
	public Integer getDays_to_next_dividend() {
		return days_to_next_dividend;
	}
	public void setDays_to_next_dividend(Integer days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}
	public Integer getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}
	public void setPercent_return_next_dividend(Integer percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
	public ObjectId getStock_Id() {
		return stock_Id;
	}
	public void setStock_Id(ObjectId stock_Id) {
		this.stock_Id = stock_Id;
	}
    
}
