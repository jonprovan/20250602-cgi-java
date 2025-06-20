package com.skillstorm;

public class Interfaces {

	public static void main(String[] args) {
		
		/*
		 * INTERFACES IN JAVA
		 * 
		 * generally, these ONLY have abstract methods
		 * they represent a contract saying that implementing classes MUST do various things
		 * 
		 * one big advantage is that you can implement MULTIPLE interfaces in a single class
		 * you can also extend one class AND implement one or more interfaces at the same time
		 */
		
		// this object IS-A SkillStormTrainer, it IS-AN Instructor, and it IS-A Developer
		SkillStormTrainer sst = new SkillStormTrainer();
		Instructor i = sst;
		Developer d = sst;
		
		sst.teach();
		sst.debug();
		
		// calling our class constant
		System.out.println(Instructor.CERTIFICATION_NUMBER);
		
		// calling our static method
		Instructor.sayCertificationNumber();
		
		// calling our method that had conflicting requirements from interfaces/abstract classes
		sst.upskill();
		
		// calling our default method
		sst.extraMethod();

	}

}

// to create an interface, just call it an interface instead of a class
interface Instructor {
	
	// properties of interfaces are public, static and final by default
	// this is called a "class constant"
	// usually, this is notated with all-caps variable names, using underscores
	int CERTIFICATION_NUMBER = 123;
	
	// you may also have static methods with implementation
	// they are public BY DEFAULT in interfaces
	// they work just like regular static methods
	static void sayCertificationNumber() {
		System.out.println("Certification Number: " + CERTIFICATION_NUMBER);
	}
	
	// abstract methods
	// ALL instance methods in interfaces are public and abstract BY DEFAULT!!
	void teach();
	void grade();
	
	// what if there's a conflict between interfaces?
	void upskill();
	
	// interfaces can have methods marked with the keyword "default" as well
	// these methods are NOT abstract!
	// they MUST provide implementation in the interface
	// this was added in Java 8
	// as a way to add functionality to interfaces without breaking existing code using those interfaces
	// adding a new default method DOES NOT require that that method is overridden in child classes
	// adding default functionality to a previously abstract method ALSO doesn't break the code
	// because if you were using that interface before, you ALREADY have an override in place
	// default methods, like other interface methods, are public BY DEFAULT
	default void extraMethod() {
		System.out.println("This does not require implementation in a child class.");
	}
	
}

interface Developer {
	
	void program();
	void debug();
	
	// what if there's a conflict between interfaces?
	void upskill();
	
}

// conflicts can arise from abstract classes with abstract methods as well
// you still ONLY need to override/implement them ONCE
// even if they conflict with interface methods
abstract class CuriousPerson {
	public abstract void upskill();
}

// to implement an interface, use the "implements" keyword
// if you implement multiple interfaces, separate them with a comma
class SkillStormTrainer extends CuriousPerson implements Instructor, Developer {
	
	// implementations of interface methods MUST be public, because the interface methods are public by default
	// and you CANNOT reduce visibility of an override!
	@Override
	public void teach() {
		System.out.println("Dad jokes first, then content.");
	}
	
	@Override
	public void grade() {
		System.out.println("YOU get and A! And YOU get an A! And...");
	}

	@Override
	public void program() {
		System.out.println("Tappita, tappita...");
	}

	@Override
	public void debug() {
		System.out.println("Arrrgghh!!!");
	}
	
	// there's a conflict here, since it's required by BOTH the Instructor AND Developer interfaces
	// HOWEVER, we only need to implement it ONCE
	// this satisfies the contracts for BOTH interfaces
	@Override
	public void upskill() {
		System.out.println("Learnin', learnin', learnin', keep that Trainer learnin'...");
	}
	
}







