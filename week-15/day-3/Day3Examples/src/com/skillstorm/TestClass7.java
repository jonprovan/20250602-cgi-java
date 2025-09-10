package com.skillstorm;

import java.math.BigDecimal;

// What will the following code print when run?  
public class TestClass7 {
	
	public static void main(String[] args) throws Exception {
		String[] sa = { "a", "b", "c" };
		
		for (String s : sa) {
			if ("b".equals(s))	// for Strings stored as literals or Objects, this works for ANY comparison
				continue;		// this moves to the next iteration of the loop, so the prints and break for "b" never happen!
			System.out.println(s);
			if ("b".equals(s))
				break;
			System.out.println(s + " again");
		}
		
		// for another question...
		// default values for primitives are 0 or 0.0
		double[] da = new double[3];
		
		for (double d : da)
			System.out.println(d);
		
		// default value for Object types is null
		Double[] da2 = new Double[3];
		
		for (Double d : da2)
			System.out.println(d);
		
		BigDecimal[] bds = new BigDecimal[3];
		
		for (BigDecimal bd : bds)
			System.out.println(bd);
		
	}
}