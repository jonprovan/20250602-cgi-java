package com.skillstorm;

import java.util.Arrays;

public class Inheritance {

	public static void main(String[] args) {
		
		/*
		 * INHERITANCE IN JAVA
		 * 
		 * -- see whiteboard for main notes/concepts
		 * 
		 * IS A vs. HAS A
		 * if a class inherits from another class, an object of the child class IS AN object of the parent class
		 * however, if a class contains a property whose type is another class, the first class HAS AN object of the other class
		 */
		
		Person person = new Person("Jimi Alan", 55, "Male", null);
		
		System.out.println(person);
		
		Person[] people = { person };
		
		System.out.println(Arrays.toString(people));
		
		Person otherPerson = new Person("Ross Kantor", 50, "Male", person);
		person.setBestFriend(otherPerson);
		
		System.out.println(person);
		System.out.println(otherPerson);
		
		person.announceSelf();
		
		Employee employee1 = new Employee("Francine Poulet", 35, "Female", otherPerson, 12345, "Animal Control Officer");
		
		System.out.println(employee1);
		
		System.out.println(employee1.getAge());
		
		// this method is overridden
		// when called on a Person object, it uses the version written there
		// however, when called on an Employee object, it uses the override in the Employee class
		otherPerson.announceSelf();
		employee1.announceSelf();
		
		// regardless of how the compiler "views" an object/variable
		// the version of an overridden method that runs is based on the actual object type
		// this is runtime polymorphism at work -- until the object actually shows up and runs, you won't know which one gets selected
		Person testEmployee = employee1;
		testEmployee.announceSelf();
		
		String[] languages = { "Java", "JavaScript", "COBOL" };
		SoftwareEngineer se1 = new SoftwareEngineer("Millard Fillmore", 77, "Male", null, 8675309, "Full-Stack Developer", languages);
		
		se1.announceSelf();
		System.out.println(se1.getEmployeeId());
		System.out.println(se1.getAge());
		System.out.println(se1);
		
		Employee a = se1;
		Person b = se1;
		Object c = se1;

	}

}

// this class, like any class that doesn't have an explicit inheritance, inherits from Java's Object class
class Person {
	
	private String name;
	private int age;
	private String gender;
	
	// HAS A relationships
	// this has NOTHING to do with inheritance at all
	private Person bestFriend;
	
	public Person(String name, int age, String gender, Person bestFriend) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bestFriend = bestFriend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Person getBestFriend() {
		return bestFriend;
	}

	public void setBestFriend(Person bestFriend) {
		this.bestFriend = bestFriend;
	}
	
	// a method we'll override later
	public void announceSelf() {
		System.out.println("My name is " + this.name + ".");
	}

	// this is an override of Object's toString() method
	// without an override, when we print our object, it'll just print the class name plus a hashCode
	// with it, it'll print whatever we want
	// you can use source generation to create a good starting point for this
	// the @Override annotation indicates that this method overrides a method in some parent class
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + 
				", bestFriend=" + ((bestFriend != null) ? bestFriend.getName() : bestFriend) + "]";
	}
	
}

// this class inherits from Person, which of course inherits from Object
// we use the "extends" keyword to indicate which class it inherits DIRECTLY from
class Employee extends Person {
	
	// properties that Employee has but Person DOES NOT
	private int employeeId;
	private String jobTitle;
	
	public Employee(String name, int age, String gender, Person bestFriend, int employeeId, String jobTitle) {
		
		// we already wrote the constructor functionality for these fields
		// so we can just use the parent class's constructor
		// this is called "constructor chaining"
		super(name, age, gender, bestFriend);
		this.employeeId = employeeId;
		this.jobTitle = jobTitle;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Override
	public void announceSelf() {
		System.out.println("My name is " + this.getName() + ", and my job title is " + jobTitle + ".");
	}

	@Override
	public String toString() {
		return "Employee [name=" + getName() + ", age=" + getAge() + ", gender=" + getGender() + 
				", bestFriend=" + ((getBestFriend() != null) ? getBestFriend().getName() : getBestFriend()) + 
				", employeeId=" + employeeId + ", jobTitle=" + jobTitle + "]";
	}
	
}

// this class inherits from Employee, which inherits from Person, which inherits from Objects
class SoftwareEngineer extends Employee {
	
	private String[] languages;
	
	public SoftwareEngineer(String name, int age, String gender, Person bestFriend, int employeeId, String jobTitle, String[] languages) {
		
		// each class ONLY has access to whichever constructors are available in the parent for the super call
		// in our case, the ONLY constructor in Employee takes these six arguments
		super(name, age, gender, bestFriend, employeeId, jobTitle);
		this.languages = languages;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	@Override
	public void announceSelf() {
		System.out.println("My name is " + this.getName() + 
						   ", and my job title is " + this.getJobTitle() + 
						   ", and I'm proficient in " + Arrays.toString(this.languages) + ".");
	}
	
	@Override
	public String toString() {
		return "Employee: Languages = " + Arrays.toString(this.languages);
	}
	
	
	
}













