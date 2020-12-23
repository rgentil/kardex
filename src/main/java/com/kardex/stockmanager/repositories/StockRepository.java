package com.kardex.stockmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kardex.stockmanager.models.Stock;



public interface StockRepository extends JpaRepository<Stock, Long> {

	public List<Stock> findAll();

	public Stock findById(Long id);

}
