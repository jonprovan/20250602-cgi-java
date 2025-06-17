package com.skillstorm;

public class FullEncapsulation {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(3, 4);
		
		System.out.println(r1.getHeight() + " " + r1.getWidth() + " " + r1.getArea() + " " + r1.isSquare());
		
//		System.out.println(r1.height + " " + r1.width + " " + r1.area + " " + r1.square);
//		
//		r1.height = 7;
//		r1.square = true;
//		
//		System.out.println(r1.height + " " + r1.width + " " + r1.area + " " + r1.square);
		
		System.out.println(r1.getHeight());
		r1.setHeight(4);
		System.out.println(r1.getArea());
		System.out.println(r1.isSquare());
		
		r1.setWidth(9);
		System.out.println(r1.getArea());
		System.out.println(r1.isSquare());
		
		Rectangle r2 = new Rectangle();
		
		System.out.println(r2.getHeight() + " " + r2.getWidth() + " " + r2.getArea() + " " + r2.isSquare());

	}

}

class Rectangle {
	
	// all properties are now private, so we need getters/setters to access or change them
	private int height;
	private int width;
	private int area;
	private boolean square;
	
	// remember to error-check your constructor as well!
	// with our original 4-arg constructor, we had the same problems
	public Rectangle(int height, int width) {
		super();
		this.setHeight(height);
		this.setWidth(width);
	}
	
	public Rectangle() {
		super();
		this.setHeight(1);
		this.setWidth(1);
	}
	
	// getters and setters
	// a getter method will retrieve the value for a property
	// a setter method will change the value for a property
	// any validation/logic you need goes inside the methods
	// NAMING CONVENTION = get<Name> for getters, set<Name> for setters -- EXCEPT BOOLEANS!! (see below)
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		if (height <= 0 || height > 100)
			throw new IllegalArgumentException("Height must be 1 and 100.");
			
		this.height = height;
		this.calculateArea();
		this.checkForSquare();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		if (width <= 0 || width > 100)
			throw new IllegalArgumentException("Width must be 1 and 100.");
			
		this.width = width;
		this.calculateArea();
		this.checkForSquare();
	}
	
	// you DO NOT need setters for properties unless you want them!
	public int getArea() {
		return this.area;
	}
	
	// boolean getters are called is<Name>, NOT get<Name>
	// this is CRITICAL when you get to Spring Boot -- you MUST name your getters/setters properly!!!
	public boolean isSquare() {
		return this.square;
	}
	
	
	
	private void calculateArea() {
		this.area = this.height * this.width;
	}
	
	private void checkForSquare() {
		this.square = (this.height == this.width) ? true : false;
	}
	
}









