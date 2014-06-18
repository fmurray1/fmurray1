/* Francis Murray CS111 Lab 9 Friday March 9th 2012 */

public class lab9
{
    public static void main(String [] args)
    {
	Person per [] = new Person [4];
	try
	    {
		per[0]= new Adult("John", "Doe", 25, "None");
		per[1]= new Student("Francis", "Murray", 20, 3.0, 13);
		per[2]= new CollegeStudent("Corey", "Hinkle", 23, 4.0, 15, "WVU", (Adult)per[0]);
		per[3]= new Student("Blah", "Blah", 80, 4.0, 19);
	    }
	catch(Exception e)
	    {
		System.err.print(e);
	    }
	//System.out.println(per[1].compareTo(per[2]));
	//per[3].printPerson();

	print(sort(per));
	
    }

    public static Person[] sort(Person [] p)
    {
	Person temp;
	    
	for(int i = 0; i < (p.length-2); i++)
	    {
		//System.out.println(i);
		if(p[i].compareTo(p[i+1])>0)
		    {
			temp = p[i];
			p[i]=p[i+1];
			p[i+1]=temp;
		
		    }
	    }

	return p;
    }


    public static void print(Person [] p)
    {
	//System.out.println(p.length);
	for(int i = 0; i< p.length; i++)
	    {
		System.out.println(p[i].first() +" " +p[i].last() +" " +p[i].age());
	    }
    }
}
