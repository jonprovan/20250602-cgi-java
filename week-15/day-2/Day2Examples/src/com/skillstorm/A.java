package com.skillstorm;

public class A {
    public void doA(int k) throws Exception {  // 0 -- this tells any calling method that it MUST handle a checked Exception when calling
        for(int i=0; i< 10; i++) {
            if(i == k) throw new Exception("Index of k is "+i); // 1
        }
    }
    
    public void doB(boolean f) { //2 -- you COULD put throws Exception here and pass the buck to the main method
    									// you could ALSO try/catch it here, handle it, and then you would NOT need to add throws to the main method!
        if(f) {
            // doA(15); //3 -- commented out for compilability -- ADD BACK TO SEE THE PROBLEM!!
        }
        else return;
    }
    
    public static void main(String[] args) { //4 -- if the buck is passed from doB up, we either need to catch the Exception here or add throws
        A a = new A();
        a.doB(args.length>0); //5
    }
}

// Which of the following statements are correct?
