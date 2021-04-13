package com.example.test.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.test.model.StockDetails;
import com.example.test.service.IStockService;

import Utils.OpenCsvUtil;


@RestController
public class StockController {

	@Autowired
	private IStockService stockService;
	
	
	//in future i would like to add year parameter as well
	@GetMapping("/{stock}/{quarter}")
	public ResponseEntity<List<StockDetails>> getStockDetailsByStockId(@PathVariable("stock") String stock, @PathVariable("quarter") int quarter) {
		
	  return stockService.getStockDetailsByStockId(stock, quarter);
	}
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addStockData(@RequestBody StockDetails stockDetail) {
		return stockService.addStockData(stockDetail);
	}
	
	@PostMapping(value = "/uploadFile")
	public ResponseEntity<String> addStockDoc(@RequestParam("file") MultipartFile file) {
		
		// Checking the upload-file's name before processing
		if (null != file && file.getOriginalFilename().isEmpty()) {
			return new ResponseEntity<>("No file present, cannot Save", HttpStatus.NO_CONTENT);
		}

		// checking the upload file's type is CSV or NOT
		
		if(null != file && !OpenCsvUtil.isCSVFile(file)) { 
			return new ResponseEntity<>("No file present, cannot Save", HttpStatus.NO_CONTENT);
		}

		try {
			if(null != file) {
			return stockService.addStockDoc(file.getInputStream());
			}
			return new ResponseEntity<>("No file present, cannot Save", HttpStatus.NO_CONTENT);
			
		} catch (IOException e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
