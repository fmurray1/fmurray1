/* Francis Murray CS111 Lab 8 Friday March 2nd, 2012 */

public class lab8
{
    
    public static void main(String [] args)
    {
	try
	    {
		Adult a = new Adult("Corey","Hinkle", 23, "Advisor");
		Student s = new Student();
		CollegeStudent cs = new CollegeStudent("Francis", "Murray", 20, 2.5, 15, "WVU", a);
		
		System.out.println("The adult is:");
		a.printPerson();
		System.out.println();
		
		System.out.println("The Student is:");
		s.printPerson();
		System.out.println();
		
		System.out.println("The College Student is:");
		cs.printPerson();
		System.out.println();
	    }
	catch(Exception e)
	    {
		System.out.println();
		System.out.println("There was an error with your adult");
		System.out.println();
	    }
    }
}
