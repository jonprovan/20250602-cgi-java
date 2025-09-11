package com.skillstorm;

import java.util.Random;

public class RandomExamples {

	public static void main(String[] args) {
		
		// you can generate random numbers with Math.random()
		double d = Math.random(); // this always generates a double between 0.0 (inclusive) and 1.0 (exclusive)
		
		// you have much more functionality with the java.util.Random class
		Random r = new Random();
		
		// this generates a random int between 10 (incl.) and 40 (excl.) -- much easier than manipulating the raw output of Math.random()
		int i = r.nextInt(10, 40);
		
		// with Math.random()...much worse and harder to understand!
		// i = (int)(Math.floor(Math.random() * 30) + 10);
		
		System.out.println(i);
		
		double d2 = r.nextDouble(1.5, 7.5);
		
		System.out.println(d2);

	}

}
