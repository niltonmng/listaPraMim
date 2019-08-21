package com.daca.listapramim.api.utils;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<ID, MODEL extends Model<ID>, REPOSITORY extends JpaRepository<MODEL,ID>> {
	
	@Autowired
	protected REPOSITORY repository;
	
	MODEL createTransaction(MODEL model) {
		try {
			return repository.save(model);
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}
	
}
