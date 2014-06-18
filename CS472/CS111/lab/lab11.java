/* Francis Murray CS111 Lab 11 Friday March 23rd 2012 */

import java.util.*;

public class lab11{

    public static Queue <Person> list = new LinkedList<Person>();
    
    public static void main (String [] args)
    {
	Scanner sc = new Scanner(System.in);
	int a = 0;
	boolean exit = false;

	//menu
	while(!exit)
	    {
		System.out.println("Would you like to:\n1.) Create a person\n2.) Display Queue\n3.) Remove the first person from the queue and display that person\n4.) Display the next person\n5.) Exit");
		a = sc.nextInt();
		
		switch(a)
		    {
		    case 1:
			god();
			exit = false;
			break;
		    case 2:
			display();
			exit = false;
			break;
		    case 3:
			remove();
			exit = false;
			break;
		    case 4:
			show();
			exit = false;
			break;
		    case 5:
			exit = true;
			break;
		    default:
			System.out.println("Incorrect selection");
			exit = false;
			break;
		    }	
	    }
    }


    public static void god()
    {
	String f,l;
	int age;
	Scanner sc2= new Scanner(System.in);
	
	System.out.println("Please enter the persons first name:");
	f = sc2.next();
	System.out.println("Please enter the persons last name:");
	l = sc2.next();
	System.out.println("Please enter the persons age:");
	age = sc2.nextInt();

	list.add(new Person(f,l,age));
    }

    public static void display()
    {
	Queue<Person> temp = new LinkedList<Person>();
	do
	    {
		temp.add(list.remove());
		temp.element().printPerson();
	    }
	while(!list.isEmpty());
	
	do
	    {
		list.add(temp.remove());
	    }
	while(!temp.isEmpty());
    }

    public static void remove()
    { 
	list.remove().printPerson();
    }

    public static void show()
    {
	list.element().printPerson();
    }
}
	    