package com.skillstorm;

import java.util.Random;

public class Calculator {
	
	public String type;
	
	public Calculator(String type) {
		super();
		this.type = type;
	}
	
	public Calculator() {
		super();
		this.type = "Default";
	}
	
	public long add(int x, int y) {
		return (long)x + y;
	}
	
	public long subtract(int x, int y) {
		return (long)x - y;
	}
	
	public long multiply(int x, int y) {
		return (long)x * y;
	}
	
	public double divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException("Can't divide by 0!");
		
		return (double)x / y;
	}
	
	public double mathClass(int x, int y, String function) {
		
		if (function == null)
			return 0.0;
		
		switch (function) {
			case "Random":
				return new Random(x).nextInt(y);
			case "Power":
				return Math.pow(x, y);
			default:
				return 0.0;
		}
		
	}
	
	

}
