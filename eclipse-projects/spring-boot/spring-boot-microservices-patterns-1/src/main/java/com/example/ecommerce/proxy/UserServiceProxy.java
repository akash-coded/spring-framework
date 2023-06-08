package com.example.ecommerce.proxy;

import org.springframework.stereotype.Component;

@Component
public class UserServiceProxy {

	private static final String USER_CATALOG_SERVICE_NAME = "user-service";
	private static final String USER_CATALOG_SERVICE_URL = "http://" + USER_CATALOG_SERVICE_NAME + "/users";
	
	private LoadBalancerClient loadBalancerClient;
}
