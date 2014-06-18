/* Francis Murray CS111 Lab 7 Friday February 24th 2012 */

import java.util.*;

public class lab7
{
    
    public static void main(String [] args)
    {
	boolean valid;
	Scanner sc = new Scanner(System.in);
	Person p = new Person();
	valid = false;

	while(!valid)
	    {
		try
		    {
			System.out.println("Please enter the person's first name");
			p.setFirst(sc.nextLine());
			System.out.println("Please enter the person's Last name");
			p.setLast(sc.nextLine());
			System.out.println("Please enter the persons age");
			p.setAge(sc.nextInt());
			valid = true;
		    }
		catch(Person.TooOldException e)
		    {
			sc.nextLine();
			System.out.println("That age is not realistic please reenter all the person's information");
			valid = false;
		    }
		catch(Person.CapErrorException e)
		    {
			System.out.println("You did not capitolize the first letter in the person's name pleaze reenter all the persons's information");
			valid = false;
		    }
	    }
	System.out.println();
	p.printPerson();
    }
}