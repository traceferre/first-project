package com.example.demo.models;

public class Adder {
	
	private int x = 0;
	private double y = 0;
 
	public Adder(int first, double second) {
		x = first;
		y = second;
	}
	
	public double calculate() {
		return x + y;
	}
}
