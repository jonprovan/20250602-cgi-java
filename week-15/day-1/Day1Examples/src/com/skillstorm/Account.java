package com.skillstorm;

// What will the following code print when compiled and run?  

public class Account {  
	
	double balance;     
	
	public void update(int[] balances){         
		for(int bal : balances){             
			bal = 100;         
		}
		
		// to change the actual array values, we'd have to do something like this...
//		for (int i = 0; i < balances.length; i++) {
//			balances[i] = 100;
//		}
	}          
	
	public static void main(String[] args) {         
		int[] balances = new int[2];         
		balances[0] = 10;         
		balances[1] = 20; 
		
		for(int bal : balances){             
			System.out.print(bal+" ");         
		}       
		
		Account a = new Account();         
		a.update(balances);         
		
		for(int bal : balances){             
			System.out.print(bal+" ");         
		}
		
		System.out.println();
	
		int x = 1;
		
		System.out.println(x);
		
		changeNumber(x);
		
		System.out.println(x);
		
	}
	
	public static void changeNumber(int x) {
		x = 1000000;
	}
}






