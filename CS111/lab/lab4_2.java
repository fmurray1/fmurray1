/* Francis Murray Lab4 part 2 Friday February 3, 2012 */

public class lab4_2
{

    public static void main(String [] args)
    {
	int [] anA = {5,6,7,8,9};
	
	System.out.println(mult(anA, 0, (anA.length-1)));

    }

    
    public static int mult(int [] a, int f, int l)
    {	
	if(f==l)
	    {
		return a[f];
	    }
	else
	    return a[f] * mult(a, (f+1), l);
    }
}