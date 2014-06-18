/* Francis Murray CS111 Lab 2 Friday January 20, 2012 */

import java.util.Scanner;

public class lab2
{
    
    static String st;
    static Scanner sc;
    static double val1, val2;
    
    public static void main (String [] args)
    {
	Scanner sc = new Scanner(System.in);
	
	val1 = 0;
	val2 = 0;
	st = "yay";
	
	while(!st.equals("exit"))
	    {
		System.out.println();
		System.out.println("Please make a selection:");
		System.out.println("A) Add Two Numbers.");
		System.out.println("B) Subtract Two Numbers.");
		System.out.println("C) Multiply Two Numbers.");
		System.out.println("D) Divide Two Numbers.");
		System.out.println("Type 'exit' to exit.");
		st = sc.next();
		st.toLowerCase();
		
		
		if(st.equals("a"))
		    {
			
			System.out.println("Please enter the first number:");
			val1 = sc.nextDouble();
			System.out.println("Please enter the second number:");
			val2 = sc.nextDouble();
	       
	       System.out.println("The answer is: " +add(val1, val2));
	       st =""; 
		    }
		else if(st.equals("b"))
		    {
			System.out.println("Please enter the first number:");
			val1 = sc.nextDouble();
			System.out.println("Please enter the second number:");
			val2 = sc.nextDouble();
			
			System.out.println("The answer is: " +sub(val1, val2));
			st ="";
		    }
		else if(st.equals("c"))
		    {
			System.out.println("Please enter the first number:");
			val1 = sc.nextDouble();
			System.out.println("Please enter the second number:");
			val2 = sc.nextDouble();
			
			System.out.println("the anser is: " +mult(val1, val2));
			st = "";
		    }
		else if(st.equals("d"))
		    {
			System.out.println("Please enter the first number:");
			val1 = sc.nextDouble();
			System.out.println("Please enter the second number:");
			val2 = sc.nextDouble();
			
			System.out.println("The answer is: " +div(val1, val2));
			st ="";
		    }
		else if(st.equals("exit"))
		    {
		    }
		else
		    {
			System.out.println("Incorrect Selection please try again.");
		    }
	    }
    }
    public static double add(double input1, double input2)
    {
	
	double addans;
	addans = input1 + input2;
	return addans;
    }
		   
    public static double sub(double input1, double input2)
    {
	
	double subans;
	subans = input1 - input2;
	return subans;
    }
    
    public static double mult(double input1, double input2)
    {
	
	double divans;
	divans = input1 * input2;
	return divans;
    }
    
    public static double div(double input1, double input2)
    {
	double divans;
	divans = input1 / input2;
	return divans;
    }
    
}