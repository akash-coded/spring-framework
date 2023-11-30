package com.example.stock.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	@Autowired
	private StockRepo repo;

	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stock) {

		List<Stock> existingStockList = repo.findByName(stock.getName());

		if (existingStockList != null && existingStockList.size() > 0) {

			Stock existingStock = existingStockList.get(0);

			int newQuantity = existingStock.getQuantity() + stock.getQuantity();

			existingStock.setQuantity(newQuantity);
			existingStock.setAddedBy(stock.getAddedBy());
			repo.save(existingStock);

		} else {

			repo.save(stock);
		}

	}

	@DeleteMapping("/stock")
	public void removeStock(@RequestBody Stock stock) {

		int newQuantity = 0;

		List<Stock> existingStockList = repo.findByName(stock.getName());

		if (existingStockList != null && existingStockList.size() > 0) {

			Stock existingStock = existingStockList.get(0);

			newQuantity = existingStock.getQuantity() - stock.getQuantity();

			if (newQuantity <= 0) {
				

				repo.delete(existingStock);
			} else {
				existingStock.setQuantity(newQuantity);
				existingStock.setAddedBy(stock.getAddedBy());
				repo.save(existingStock);
			}
		}

	}

	@GetMapping("/stock")
	public List<Stock> getStock(@RequestParam("name") String name) {

		return repo.findByName(name);

	}

}
