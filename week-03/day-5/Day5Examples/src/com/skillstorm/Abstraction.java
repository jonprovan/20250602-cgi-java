package com.skillstorm;

public class Abstraction {

	public static void main(String[] args) {
		
		/*
		 * ABSTRACTION IN JAVA
		 * 
		 * - concealing details of implementation
		 * - abstract classes
		 * - interfaces
		 */
		
		// can't do this -- Customer is abstract and CANNOT be instantiated
//		Customer customer = new Customer();
		
		// but we CAN do this
		RestaurantCustomer rc1 = new RestaurantCustomer("Larry", "Traveler's Check", "Cajun");
		rc1.stateNameAndPaymentPreference();
		
		// we can do this, too, because a RestaurantCustomer IS-A Customer
		Customer rc2 = new RestaurantCustomer("Marcy", "Bitcoin", "Japanese");
		System.out.println(rc2 instanceof Customer);  // instanceof returns true if the object noted IS-A(N) class on the right
		rc2.stateNameAndPaymentPreference();
		
		Customer oc1 = new OnlineCustomer("Wilhelmina", "Doubloons", "NewEgg.com");
		
		rc1.order();
		rc2.order();
		oc1.order();
		
		rc1.order(5);
		rc2.order(2);
		oc1.order(10);

	}

}

// to make a class abstract, just use the abstract keyword
abstract class Customer {
	
	// you can have regular properties, just like a regular class
	public String name;
	public String paymentPreference;
	
	// you can have constructors, too!
	public Customer(String name, String paymentPreference) {
		this.name = name;
		this.paymentPreference = paymentPreference;
	}
	
	// you can have regular static/instance methods, as well
	public void stateNameAndPaymentPreference() {
		System.out.println("My name is " + name + ", and I prefer to pay via " + paymentPreference + ".");
	}
	
	// for order(), we may not have a generic implementation
	// we MAY want to pass on the burden of implementing order() to the extending class(es)
	// we use the abstract keyword for this
	
	// abstract methods CANNOT provide implementation -- you just use a semicolon after the parentheses
	// now, our inheriting class(es) MUST implement this method
	public abstract void order();
	
	// you can overload abstract methods as well (same rules apply)
	// when you implement them in the subclass, you need to match the parameters, etc.
	public abstract void order(int quantity);
	
}

// you can inherit from an abstract class in ANOTHER abstract class
// if you do so, you DO NOT have to implement the abstract methods here!
abstract class RetailCustomer extends Customer {

	public RetailCustomer(String name, String paymentPreference) {
		super(name, paymentPreference);
	}
	
	// if you provide implementation for an abstract method from a parent class
	// NO further subclasses must implement the method -- it is NO LONGER abstract!
//	public void order() {
//		System.out.println("Implemented!");
//	}
	
	// ALL abstract methods in the inheritance chain MUST be implemented SOMEWHERE before we reach the end of the chain
	public abstract void returnProduct();
	
}

// this class inherits from Customer, just like inheriting from a concrete class
class RestaurantCustomer extends RetailCustomer {
	
	public String favoriteCuisine;
	
	public RestaurantCustomer(String name, String paymentPreference, String favoriteCuisine) {
		super(name, paymentPreference);
		this.favoriteCuisine = favoriteCuisine;
	}
	
	// since this class extends Customer, we MUST implement the order() method
	// it's an override, so ALL regular rules of overriding apply, re: access modifier, signature, etc.
	// if we had multiple abstract methods in the abstract parent class, we MUST implement ALL of them!
	@Override
	public void order() {
		System.out.println("I'd like some " + favoriteCuisine + " food, please.");
	}

	@Override
	public void order(int quantity) {
		System.out.println("I'd like " + quantity + " orders of " + favoriteCuisine + " food, please.");
	}

	// this requirement is coming from the RetailCustomer class
	@Override
	public void returnProduct() {}
	
}

class OnlineCustomer extends RetailCustomer {
	
	public String favoriteSite;

	public OnlineCustomer(String name, String paymentPreference, String favoriteSite) {
		super(name, paymentPreference);
		this.favoriteSite = favoriteSite;
	}

	@Override
	public void order() {
		System.out.println("I'd like something from " + favoriteSite + ", please.");
	}

	@Override
	public void order(int quantity) {
		System.out.println("I'd like " + quantity + " things from " + favoriteSite + ", please.");
	}

	@Override
	public void returnProduct() {}
	
}





