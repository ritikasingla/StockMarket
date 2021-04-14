package com.example.test.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.test.model.StockDetails;
import com.example.test.model.TickerDetails;
import com.example.test.repository.StockRepository;
import com.example.test.repository.TickerRepository;

import Utils.ApacheCommonsCsvUtil;


@Service
public class StockService implements IStockService {

	@Autowired
	  private StockRepository stockRepository;
	
	@Autowired
	  private TickerRepository tickerRepository;
	
	@Override
	public ResponseEntity<List<StockDetails>> getStockDetailsByStockId(String stockId, int quarter) {
		
		try {
				Optional<List<StockDetails>> stockList = Optional.empty();
				if(null != stockId) {
					stockList = stockRepository.findByStockIdAndQuarter(stockId, quarter);
					return new ResponseEntity<>(stockList.get(), HttpStatus.OK);
				}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Override
	public ResponseEntity<String> addStockData(StockDetails stockDetail) {
		
		try {
			if(null != stockDetail.getStock()) {
				stockRepository.save(stockDetail);
				return new ResponseEntity<>("Stock Saved", HttpStatus.OK);
			}
			return new ResponseEntity<>("No stock present, cannot Save", HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> addStockDoc(InputStream file) {
		try {
			// Using ApacheCommonsCsvUtil Utils to parse CSV file
			if(null != file) {
				List<StockDetails> stockDetail = ApacheCommonsCsvUtil.parseCsvFile(file);
				if(null != stockDetail) {
					stockRepository.saveAll(stockDetail);
					return new ResponseEntity<>("Stock document Saved", HttpStatus.OK);
				}
				return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			return new ResponseEntity<>("No data present, cannot Save", HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}	
		
	}
	
}
