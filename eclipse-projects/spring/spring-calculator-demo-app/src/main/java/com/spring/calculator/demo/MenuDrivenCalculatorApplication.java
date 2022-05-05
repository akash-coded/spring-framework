package com.spring.calculator.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.calculator.demo.beans.AdditionOperation;

public class MenuDrivenCalculatorApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context-config.xml");

		AdditionOperation adder = context.getBean("additionOperation", AdditionOperation.class);
		adder.showOperands();
		System.out.println("Sum of initial numbers = " + adder.add());
		
		System.out.println("Sum of other numbers = " + adder.add(3,4,5,6,7));

		context.close();
	}

}
