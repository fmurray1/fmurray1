/* Francis Murray CS111 Lab4 Friday February 3, 2012 */

import java.util.*;

public class lab4
{


    public static void main(String [] args)
    {

	int in;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Please enter an integer to take the even factorial of:");
	in = sc.nextInt();
	
	System.out.println(fact(in));
    }



    public static int fact(int n)
    {
	if(n==2)
	    {
		return 2;
	    }
	else if(n%2==0)
	    {
		return n * fact(n-2);
	    }
	else
	    {
		return fact(n-1);
	    }
    }

}