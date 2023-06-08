package com.example.ecommerce.proxy;

import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "aggregator-service")
public interface AggregatorServiceProxy {
	
	@GetMapping("/aggregate")
	AggregateData getAggregatedData();
}
