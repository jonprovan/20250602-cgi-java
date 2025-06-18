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