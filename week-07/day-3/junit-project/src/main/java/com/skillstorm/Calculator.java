package com.skillstorm;

public class Calculator {
	
	public String type;
	
	public Calculator(String type) {
		super();
		this.type = type;
	}
	
	public Calculator() {
		super();
	}
	
	public long add(int x, int y) {
		return (long)x + y;
	}
	
	public int subtract(int x, int y) {
		return x - y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public double divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException("Can't divide by 0");
		
		return (double)x / y;
	}

}
