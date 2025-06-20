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
		
		SkillStormTrainer sst = new SkillStormTrainer();
		Instructor i = sst;
		Developer d = sst;
		
		sst.teach();
		sst.debug();
		
		System.out.println(Instructor.CERTIFICATION_NUMBER);

	}

}

// to create an interface, just call it an interface instead of a class
interface Instructor {
	
	// properties of interfaces are public, static and final by default
	// this is called a "class constant"
	// usually, this is notated with all-caps variable names, using underscores
	int CERTIFICATION_NUMBER = 123;
	
	// abstract methods
	// ALL instance methods in interfaces are public and abstract BY DEFAULT!!
	void teach();
	void grade();
	
}

interface Developer {
	
	void program();
	void debug();
	
}

// to implement an interface, use the "implements" keyword
// if you implement multiple interfaces, separate them with a comma
class SkillStormTrainer implements Instructor, Developer {
	
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
	
}







