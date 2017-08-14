package com.example.demo.models;

public class Calculator {
	
	private double x = 0;
	private double y = 0;
 
	public Calculator(double first, double second) 
	{		
		x = first;
		y = second;		
	}
	
	public double addTwoNumbers() 
	{
		return x + y;
	}
	
	public double subtractTwoNumbers() {
		return x - y;
	}
	
	public double divideTwoNumbers() {
		return x / y;
	}
	
	public double multipyTwoNumbers() {
		return x * y;
	}
	
	public double modTwoNumbers() {
		return x % y;
	}
	
	public double powerTwoNumbers() {
		return Math.pow(x, y);
	}
}
