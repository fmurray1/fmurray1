/* Francis Murray CS111 Lab 12 Friday April 13th 2012 */

import java.util.*;

public class lab12
{
    public static LinkedList<Person> list = new LinkedList<Person>();

    public static void main(String [] args) throws Exception
    {
	int num = 0, a;
	Scanner sc = new Scanner(System.in);
	String f, l;
	 
	while(num <5)
	    {
		System.out.println("Please enter the Persons first name:");
		f = sc.nextLine();
		System.out.println("Please enter the persons last Name:");
		l = sc.nextLine();
		System.out.println("Please enter the persons age:");
		a = sc.nextInt();
		sc.nextLine();
		
		list.add(new Person(f,l,a));
		
		num++;
		
	    }
	ListIterator <Person> li = list.listIterator(list.size());
	
	while(li.hasPrevious())
	    {
		li.previous().printPerson();
	    }
    }
}
		