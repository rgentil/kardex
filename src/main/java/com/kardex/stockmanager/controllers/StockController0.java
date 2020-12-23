package com.kardex.stockmanager.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kardex.stockmanager.models.Stock;
import com.kardex.stockmanager.services.StockService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/stocks0")
public class StockController0 {
	Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.POST, value="/{id}")
	public void deleteItem(@PathVariable("id") Long id){
		stockService.deleteItem(stockService.getStockById(id));
	}


}
