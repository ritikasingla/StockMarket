package com.example.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.test.model.StockDetails;


public interface StockRepository extends MongoRepository<StockDetails, String>{

	@Query("{'stock' : ?0 , 'quarter' : ?1}")
	public Optional<List<StockDetails>> findByStockIdAndQuarter(String stockId, int quarter);
}
