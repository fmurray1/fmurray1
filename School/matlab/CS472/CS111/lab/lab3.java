/* Francis Murray CS111 Lab3 Friday January 27 2012 */

import java.util.*;
import java.io.*;

public class lab3
{
    
    static int[][] readA = new int [3][10];
    static int sum;
    public static void main(String [] args) throws Exception
    {
	Scanner sc = new Scanner(new FileReader("lab3.txt"));
	
	
	for(int i=0; i <3; i++)
	    {
		for(int j=0; j<10; j++)
		    {
			if(j==9)
			    {
				for(int k=0; k<9; k++)
				    {
					sum += readA[i][k];
				    }
				readA[i][j] = sum;
			    }
			else
			    {
				readA[i][j] = sc.nextInt();
			    }
		       
			
		    }
		sum = 0;
	    }
	print(readA);
	
	
    }
    
    
    public static void print(int aA[][])
    {
	for(int l=0; l<3; l++)
	    {
		for(int m= 0; m<10; m++)
		    {
			if(m==9)
			    {
				System.out.println(" " +aA[l][m]);
			    }
			else
			    {
				System.out.print(" " +aA[l][m]);
			    }
		    }
	    }
    }
}