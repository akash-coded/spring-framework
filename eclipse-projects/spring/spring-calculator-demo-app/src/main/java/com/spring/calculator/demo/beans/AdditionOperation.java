package com.spring.calculator.demo.beans;

import java.util.Arrays;

public class AdditionOperation {
	private int num1;
	private int num2;

	public AdditionOperation() {
		super();
	}

	public AdditionOperation(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public void showOperands() {
		System.out.println("Operands for addition [num1=" + num1 + ", num2=" + num2 + "]");
	}
	
	public int add() {
		return num1 + num2;
	}
	
	public int add(int...numbers) {
//		int sum = 0;
//		
//		for(int num: numbers) {
//			sum += num;
//		}
//		
//		return sum;
		
		return Arrays.stream(numbers).reduce(0, (sum, num) -> sum + num);
	}
	
}
