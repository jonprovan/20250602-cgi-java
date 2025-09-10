package com.skillstorm;

// (Similar to previous one we did but this one’s answer changed) 
// What will the following code print when compiled and run?  
public class Account {     
	double balance;     
	
	public void update(int[] balances2) {    
		// here, as opposed to the previous example, we're using the array reference
		// to change the ACTUAL values at the ACTUAL indexes in the referenced object!!
		balances2[0] = 100;         
		balances2[1] = 200; 
//		balances2[2] = 300; // this would throw an ArrayIndexOutOfBoundsException (a RuntimeException) because the referenced array only has 2 slots!
		
		// in the previous example, they did this
		// this DOES NOT change the values in the array itself
		// it creates a local variable called bal that holds the value of that index
		// if we change the value of the local variable, it does not change the value in the array itself
//		for (int bal : balances2) {
//			bal = 100;
//		}
	}          
	
	public static void main(String[] args) {         
		int[] balances1 = new int[2];         
		balances1[0] = 10;         
		balances1[1] = 20;    
		
		for(int bal : balances1) {             
			System.out.print(bal+" ");         
		}      
		
		Account a = new Account();         
		a.update(balances1);  
		
		// now, when we get here, the balances1 reference points to the same object that balances2 did in the method
		// so we get the updated values, since we changed them on the actual array object itself
		for(int bal : balances1) {             
			System.out.print(bal+" ");         
		}     
	} 
}