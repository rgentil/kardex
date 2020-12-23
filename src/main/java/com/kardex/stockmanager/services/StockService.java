package com.kardex.stockmanager.services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kardex.stockmanager.models.Stock;
import com.kardex.stockmanager.repositories.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class StockService {
Logger logger = LoggerFactory.getLogger(StockService.class);
	@Autowired
	private StockRepository stockRepository;

	public Collection<Stock> getAllStocks() {
		Collection<Stock> stocks = stockRepository.findAll();
		return stocks;
	}

	public Stock getStockById(Long id) {
		return stockRepository.findById(id);
	}

	public void saveStock(Stock stock) {
		stock.setId(null);
		int currentAmount = stock.getCurrentAmount();
		stock.setCurrentAmount(currentAmount);
		stock.setLastUpdatedAt(new Date());
		stockRepository.save(stock);
	}

	public void editStock(Stock editedStock) {
		editedStock.setLastUpdatedAt(new Date());
		stockRepository.saveAndFlush(editedStock);
	}

	public void deleteStock(Long id) {
		stockRepository.delete(id);
	}
	public void addItem(Stock stock){
		int currentAmount = stock.getCurrentAmount();
		stock.setCurrentAmount(currentAmount+1);
		stock.setLastUpdatedAt(new Date());
		stockRepository.saveAndFlush(stock);
	}
	public void deleteItem(Stock stock){
		int currentAmount = stock.getCurrentAmount();
		//System.out.println("currentAmount "+currentAmount);
		if(currentAmount>0){
			currentAmount = currentAmount -1;
		stock.setCurrentAmount(currentAmount);
		stock.setLastUpdatedAt(new Date());
		stockRepository.saveAndFlush(stock);
	}
	}
}
