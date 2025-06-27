package com.skillstorm;

import java.util.Objects;

public class CustomEquality {

	public static void main(String[] args) {
	
		// in the class tree below, we want people to be considered equal based on NAME ALONE
		
		Person person = new Person("Millie");
		Employee employee = new Employee("Millie", 12345);
		
		// this would not work if we didn't override the equals() method OR if we overrode it with default functionality
		// see Person class below for what we changed
		System.out.println(person.equals(employee));
		
		Student student = new Student("Millie", 67890);
		
		// this works now, even though NEITHER of these objects are instantiated as Person objects
		// note that it DOES give an unlikely argument warning when you hover over student below
		// because they seem unrelated in the class tree, but it compiles and works exactly how we want it to
		System.out.println(employee.equals(student));
		
	}

}

class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// we need to change this line from what it was, because it's now possible for objects of different instantiated classes to be equal
		// instanceof returns true here if an object IS-A Person (could be a Person, Employee or Student)
		// so, if that's NOT true, return false and exit, because they're NOT equal
		// otherwise, continue and check their names to see if they're considered equal
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}

}

class Employee extends Person {
	public int employeeID;
	
	public Employee(String name, int employeeID) {
		super(name);
		this.employeeID = employeeID;
	}
}

class Student extends Person {
	public int studentID;
	
	public Student(String name, int studentID) {
		super(name);
		this.studentID = studentID;
	}
}
