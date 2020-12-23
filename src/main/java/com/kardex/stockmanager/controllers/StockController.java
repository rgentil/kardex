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
@RequestMapping("/stocks")
public class StockController {
	Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Stock> getAllstocks(){
		return this.stockService.getAllStocks();
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Stock getStockById(@PathVariable("id") Long id){
	    return stockService.getStockById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveStock(@RequestBody Stock stock){
		stock.setId(null);
		stockService.saveStock(stock);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void editStock(@RequestBody Stock editedStock ,@PathVariable("id") Long id){
		editedStock.setId(id);
		stockService.editStock(editedStock);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteStock(@PathVariable("id") Long id){
		stockService.deleteStock(id);
	}
	@RequestMapping(method = RequestMethod.POST, value="/{id}")
	public void addItem(@PathVariable("id") Long id){
		stockService.addItem(stockService.getStockById(id));
	}
@RequestMapping(method = RequestMethod.PATCH)
	public void deleteItem(@RequestParam(value="delete") Long id){
		logger.info("id --->"+id);
		stockService.deleteItem(stockService.getStockById(id));
	}

}
