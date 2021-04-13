package com.example.test.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.opencsv.bean.CsvBindByName;

@Document(collection="stock-data")
public class TickerDetails {

	@Id
    private ObjectId _id;
	
	@CsvBindByName(column = "stock")
    private String stock;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public TickerDetails(ObjectId _id, String stock) {
		super();
		this._id = _id;
		this.stock = stock;
	}
	
	    
}
