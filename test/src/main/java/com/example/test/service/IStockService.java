package com.example.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.test.model.StockDetails;

public interface IStockService {

	public ResponseEntity<List<StockDetails>> getStockDetailsByStockId(String stockId, int quarter);
	
	public ResponseEntity<String> addStockData(StockDetails stockDetail);
	
	public ResponseEntity<String> addStockDoc(InputStream file);
}
