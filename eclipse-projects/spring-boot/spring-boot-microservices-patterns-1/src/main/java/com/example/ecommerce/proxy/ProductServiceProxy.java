package com.example.ecommerce.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecommerce.productcatalog.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/products/{productId}")
	Product getProductById(@PathVariable String productId);
}
