package com.skillstorm;

import java.util.Arrays;

public class MultiDimensionalArrays {

	public static void main(String[] args) {
		
		/*
		 * MULTI-DIMENSIONAL ARRAYS IN JAVA
		 * 
		 * you can store arrays within arrays
		 * you can even store arrays within arrays within arrays, etc.
		 * 
		 * for instance, a chess board might look like a 2-D array with 8 rows and 8 columns
		 * - something like String[8][8]
		 * - one side of a Rubik's Cube might be char[3][3]
		 * - if February started on a Sunday, that calendar month might look like int[4][7]
		 * 
		 * this is very useful for modeling matrix data, like coordinates on a plane, points in 3D space, anything grid-based, etc.
		 */
		
		// declaring one
		int[][] numGrid1;
		
		// declaring and initializing one
		// numGrid2 has three total slots, each of which holds an int[] -- the sizes of the int[]s are NOT SPECIFIED this way
		int[][] numGrid2 = new int[3][];
		
		System.out.println(Arrays.toString(numGrid2));
		
		numGrid2[0] = new int[5];
		numGrid2[1] = new int[2];
		numGrid2[2] = new int[7];
		
		System.out.println(Arrays.toString(numGrid2[0]));
		System.out.println(Arrays.toString(numGrid2[1]));
		System.out.println(Arrays.toString(numGrid2[2]));
		
		// this instantiates all the inner arrays as well, in this case, 3 rows, each of which is a 3-slot int[] with default values
		int[][] numGrid3 = new int[3][3];
		
		System.out.println(Arrays.toString(numGrid3[0]));
		System.out.println(Arrays.toString(numGrid3[1]));
		System.out.println(Arrays.toString(numGrid3[2]));
		
		// we can still reassign one of the inner arrays to a new array of any length
		// we're not fixed to a specific length because of the initialization above
		numGrid3[1] = new int[5];
		
		System.out.println(Arrays.toString(numGrid3[0]));
		System.out.println(Arrays.toString(numGrid3[1]));
		System.out.println(Arrays.toString(numGrid3[2]));
		
		numGrid3[1] = new int[3];
		
		System.out.println("\n" + Arrays.toString(numGrid3[0]));
		System.out.println(Arrays.toString(numGrid3[1]));
		System.out.println(Arrays.toString(numGrid3[2]));
		
		// assigning values to individual slots/cells
		numGrid3[0][0] = 1;
		numGrid3[0][1] = 2;
		numGrid3[0][2] = 3;
		
		System.out.println("\n" + Arrays.toString(numGrid3[0]));
		System.out.println(Arrays.toString(numGrid3[1]));
		System.out.println(Arrays.toString(numGrid3[2]));
		
		numGrid3[2][0] = 7;
		numGrid3[2][1] = 8;
		numGrid3[2][2] = 9;
		
		System.out.println("\n" + Arrays.toString(numGrid3[0]));
		System.out.println(Arrays.toString(numGrid3[1]));
		System.out.println(Arrays.toString(numGrid3[2]));
		
		// typing is done at both the inner and outer array level
		// in our case, each inner array can ONLY hold ints
		// each outer array can ONLY hold int[]s
		
		// can't do this
//		numGrid3[0][0] = "abc";
		
		// can't do this, either
//		numGrid3[0] = new String[];
		
		// looping through -- will return to this later
		
		// for a 1-D array
		for (int i : numGrid3[0])
			System.out.println(i);
		
		// for a 2-D array
		for (int i = 0; i < numGrid3.length; i++) {
			for (int j = 0; j < numGrid3[i].length; j++) {
				System.out.println(numGrid3[i][j]);
			}
		}
		

	}

}
