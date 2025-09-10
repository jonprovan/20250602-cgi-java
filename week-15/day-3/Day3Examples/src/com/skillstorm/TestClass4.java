package com.skillstorm;

public class TestClass4 {

	public static void main(String[] args) {

		// What will the following program snippet print?
		int i = 0, j = 11;
		
		do {
			if (i > j) {
				break;		// even if nested inside some other block within the loop, break will break the loop it's in (without a label)
			}
			j--;			// this runs on its own, so the pre/post part doesn't matter
		} while (++i < 5);	// this one increments BEFORE the check, so it fails after the iteration where i was 4 (goes to five, then fails)
		
		System.out.println(i + "  " + j);

	}

}
