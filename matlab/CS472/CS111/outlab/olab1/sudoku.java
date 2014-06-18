/* Francis Murray CS111 Out of Lab Project 1 */

import java.util.*;
import java.io.*;


public class sudoku
{
    
    public static int puzzle [][] = new int [6][6];
    
    
    
    public static void main(String [] args) throws Exception
    {
	
	FileReader infile = new FileReader("puzzle.txt");
	Scanner sc = new Scanner(infile);
	
	
	for(int i=0; i<6; i++)  
	    {
		for(int j=0; j<6; j++)
		    {
			puzzle[i][j] = sc.nextInt();
		    }
	    }

	sc.close();
	
	
	System.out.println("The Original Puzzle was:");
	print(puzzle);
	
	if(solve(0,0))
	    {
		System.out.println("");
		System.out.println("");
		System.out.println("The Solved Puzzle is:");
		print(puzzle);
	    }
    }
    
    
    public static void print(int a [][])
    {
	for(int b=0; b<6; b++)
	    {
		for(int c=0; c<6; c++)
		    {
			if(c==5)
			    {
				System.out.println(a[b][c]);
			    }
			else
			    {
				System.out.print(a[b][c]+" ");
			    }
		    }
	    }
    }
    
    
    
    public static boolean solve(int row, int col)
    {
	//System.out.println("Entering");
	
	if(row==6)
	    {
		row =0;
		col++;
		if(col==6)
		    {
			return true;
		    }
	    }
	if(puzzle[row][col]!=0)
	    {
		//System.out.println("Moving over a row");
		return solve(row+1,col);
	    }
	
	for(int trying =1; trying <7; trying++)
	    {
		//System.out.println("Entering " +row +"," +col);
		if(row(row,trying) && column(col,trying) && box(row,col,trying))
		    {
			//System.out.println("Trying" +trying);
			
			puzzle[row][col]=trying;
			
			if(solve(row+1, col))
			    {
				return true;
			    }
			
		    }
	    }
	puzzle[row][col]=0;
	return false;  	
    }
    
    
    
    public static boolean row(int d, int num)
    {
	for(int a=0; a<6; a++)
	    {
		if(puzzle[d][a]==num)
		    {
			return false;
		    }
     	    }
	return true;
    }
    
    public static boolean column(int d, int num)
    {
	for(int a = 0; a<6; a++)
	    {
		if(puzzle[a][d]==num)
		    {
			return false;
		    }
		
	    }
	return true;
	
    }
    
    public static boolean box(int d, int e, int num)
    {
	
	int l=0, m=0, r, c;
	
	
	l=d/2;
	r = l*2;
	
	m = e/3;
	c = m*3;
	
	for(int a=0; a<2; a++)
	    {
		for(int b=0; b<3; b++)
		    {
			if(puzzle[a+r][b+c]==num)
			    {
				return false;
			    }
		    }
	    }	
	return true;	     
    }
}