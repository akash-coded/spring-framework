package com.example.ecommerce.productcatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private Map<String, Product> products = new HashMap<>();

	public List<Product> getAllProducts() {
		return new ArrayList<>(products.values());
	}
	
	public Product getProductById(String productId) {
		return products.get(productId);
	}
	
	public Product createProduct(Product product) {
		products.put(product.getId(), product);
		return product;
	}
	
	public Product updateProduct(String productId, Product product) {
		if (products.containsKey(productId)) {
			products.put(productId, product);
			return product;
		}
		return null;
	}
	
	public void deleteProduct(String productId) {
		products.remove(productId);
	}
}
