package com.skillstorm;

// What will the following code print when compiled and run?  

public class TestClass2 {    
	public static void main(String[] args){         
		int[] arr = { 1, 2, 3, 4, 5, 6 };         
		int counter = 0;         
		for (int value : arr) {            
			if (counter >= 5) {    // this part is the crux of the question -- we either do one or the other, so we never make it past this fork            
				break;                
			} else {             
				continue;                
			}            
//			if (value > 4) {              
//				arr[counter] = value + 1;                
//			}               
//			counter++;         
		}         
		System.out.println(arr[counter]);    
	}  
}