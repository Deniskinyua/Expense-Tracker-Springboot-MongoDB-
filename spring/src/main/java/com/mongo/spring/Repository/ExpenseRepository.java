package com.mongo.spring.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.mongo.spring.Service.ExpenseService;
import com.mongo.spring.model.Expense;



public interface ExpenseRepository extends MongoRepository<Expense, String> {
	@Query("{'name': ?0}")
	Optional<Expense> findByName(String name);

}
