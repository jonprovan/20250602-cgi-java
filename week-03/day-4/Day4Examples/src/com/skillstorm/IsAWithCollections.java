package com.skillstorm;

public class IsAWithCollections {

	public static void main(String[] args) {
		
		/*
		 * IS-A WITH COLLECTIONS
		 * 
		 * collections (arrays, Lists, Maps, Sets, etc.) are typed
		 * you can ONLY put into a collection something that matches the type
		 * BUT, since child classes have IS-A relationships with their parents, grandparents, etc.
		 * you CAN put child classes into a collection that's typed with the parent, etc.
		 */
		
		// we can place ANY subclass into this array, since it's typed with the top-level class
		Vehicle[] vehicles = new Vehicle[5];
		
		Vehicle v1 = new Vehicle();
		RoadVehicle rv1 = new RoadVehicle();
		Bus b1 = new Bus();
		Moped m1 = new Moped();
		SchoolBus sb1 = new SchoolBus();
		
		// if the instantiated array is not the same type as the reference type
		// we can run into RuntimeExceptions when we try to place in Vehicles, etc.
		// these are UNCHECKED Exceptions, meaning the compiler WILL NOT find them for you
//		vehicles = new Bus[5];
		
		vehicles[0] = v1;
		vehicles[1] = rv1;
		vehicles[2] = b1;
		vehicles[3] = m1;
		vehicles[4] = sb1;
		
		// we can loop through the collection and do common actions for each element
		// if we need access to variable or method that ONLY exists in a child class, we must CAST the Vehicle to the child class
		// e.g. ((Bus)v) instead of just v
		// casting will ONLY work for instances that have IS-A relationships with the casted type
		// so we CANNOT cast a Vehicle object as a Bus, for example, because a Vehicle IS NOT NECESSARILY a Bus
		// hence, we need to do some checks first
		
		// if you have overrides on a viable method for a object you've cast as a parent object (reference type)
		// it will STILL use the override most specific to the ACTUAL instance of the object itself
		for (Vehicle v : vehicles) {
			v.sayType();
			
			if (v instanceof Bus)
				((Bus)v).statePassengerNumber();
			
			if (v instanceof Moped)
				((Moped)v).statePassengerNumber();
			
			v.rev();
		}
		
		System.out.println();
		
		// instanceof vs. getClass()
		
		// getClass() returns the exact instance type of the instantiated object
		// so, it's DIFFERENT for a Bus object vs. a SchoolBus object
		// the reference/variable type holding it DOES NOT MATTER, only the actual instance on the Heap
		System.out.println(b1.getClass());
		System.out.println(sb1.getClass());
		
		// instanceof will return true if the object has an IS-A relationship with the type
		// a Bus IS-A Bus
		// a SchoolBus also IS-A Bus (in addition to being a SchoolBus)
		// so they both return true
		System.out.println(b1 instanceof Bus);
		System.out.println(sb1 instanceof Bus);
		
		// you CANNOT override static methods
		// the can be run before objects are even instantiated, so there's no IS-A to be found
		// you can see here that, when we call the static methods improperly
		// and cast the RoadVehicle as a Vehicle, it just runs the Vehicle version
		// regardless of the fact that rv1 is an instance of RoadVehicle
		// we're calling these on the CLASS, not the OBJECTS
		v1.staticMethod();
		((Vehicle)rv1).staticMethod();
		

	}

}

class Vehicle {
	
	public void rev() {
		System.out.println("Whizzzz!");
	}
	
	public void sayType() {
		System.out.println(this.getClass());
	}
	
	public static void staticMethod() {
		System.out.println("Vehicle Static Method");
	}
	
}

class RoadVehicle extends Vehicle {
	
	@Override
	public void rev() {
		System.out.println("Vroom!");
	}
	
	public static void staticMethod() {
		System.out.println("RoadVehicle Static Method");
	}
	
}

class Bus extends RoadVehicle {
	
	@Override
	public void rev() {
		System.out.println("Kachunka!");
	}
	
	public void statePassengerNumber() {
		System.out.println("55 Passengers");
	}
	
}

class SchoolBus extends Bus {
	
	@Override
	public void statePassengerNumber() {
		System.out.println("35 Kids");
	}
	
}

class Moped extends RoadVehicle {
	
	@Override
	public void rev() {
		System.out.println("Buzzzzz!");
	}
	
	public void statePassengerNumber() {
		System.out.println("1 Passenger");
	}
	
}
