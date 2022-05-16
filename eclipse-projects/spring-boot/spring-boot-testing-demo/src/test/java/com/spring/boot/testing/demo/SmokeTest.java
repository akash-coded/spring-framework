package com.spring.boot.testing.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.testing.demo.controllers.HomeController;

/**
 * To check that the context is creating the controller
 * 
 * @author akash
 *
 */
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private HomeController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
