package com.demo.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "product-service", url = "http://localhost:8088")
public interface ProductClient {
	@GetMapping(value = "/product")
	String getProduct();
	
	// Or, you can pass the header value dynamically
    @GetMapping("/product")
    String getProductWithHeader(@RequestHeader("Authorization") String authorization);
}
