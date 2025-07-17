package com.skillstorm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CustomerTests {
	
	private static List<Customer> customersInitial = new LinkedList<>(List.of(
				new Customer("Gary", 45, "Pet Supplies"),
				new Customer("Lisa", 27, "SCUBA Gear"),
				new Customer("Elvin", 85, "Cheese")
			));
	
	private static List<Customer> customers = new LinkedList<>();	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BEFORE ALL");
		customers.addAll(customersInitial);
		System.out.println(customers);
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BEFORE EACH");
		customers.clear();
		customers.addAll(customersInitial);
		System.out.println(customers);
	}

	@Test
	void sortTest() {
		System.out.println("SORT TEST");
		Collections.sort(customers);
		System.out.println(customers);
		assertEquals("Elvin", customers.get(0).getName());
	}
	
	// this annotation will skip this test
	// if you're using JUnit4, it's @Ignore
	@Disabled
	@Test
	void lastOneTest() {
		System.out.println("LAST ONE TEST");
		assertEquals("Elvin", customers.get(customers.size() - 1).getName());
	}

	@AfterEach
	void tearDown() throws Exception {
		// could just as easily do our list reset here
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AFTER ALL");
		customersInitial = null;
		customers = null;
	}

}
