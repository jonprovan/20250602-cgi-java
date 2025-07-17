package com.skillstorm;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
	
	private String name;
	private int age;
	private String product;
	
	public Customer(String name, int age, String product) {
		super();
		this.name = name;
		this.age = age;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", product=" + product + "]";
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(product, other.product);
	}

	@Override
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	
}
