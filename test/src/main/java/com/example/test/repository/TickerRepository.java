package com.example.test.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.test.model.TickerDetails;


public interface TickerRepository extends MongoRepository<TickerDetails, String>{

	@Query("{'stock' : ?0}")
	public Optional<TickerDetails> findByStock(String stock);
}
