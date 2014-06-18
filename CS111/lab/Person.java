/* Francis Murray Lab 6 Person Class */

public class Person implements Cloneable, Comparable
{
    private String first, last;
    private int age;


    public Person()
    {
	first= "John";
	last = "Doe";
	age = 0;
    }
    
    public Person(String f, String l, int a)
    {
	first = f;
	last = l;
	age = a;
    }

    public void setAge(int a) throws TooOldException
    {
	if(a > 123)
	    {
		throw new TooOldException();
	    }
	else
	    {
		age = a;
	    }
    }

    public void setFirst(String f) throws CapErrorException
    {
	char c = f.charAt(0);
	if(Character.isUpperCase(c))
	    {
		first = f;
	    }
	else
	    {
		throw new CapErrorException();
	    }
    }
    
    public void setLast(String l) throws CapErrorException
    {

	char c = l.charAt(0);
	if(Character.isUpperCase(c))
	    {
		last = l;
	    }
	else
	    {
		throw new CapErrorException();
	    }
    }

    public int age()
    {
	return age;
    }
    
    public String first()
    {
	return first;
    }
    
    public String last()
    {
	return last;
    }

    public void printPerson()
    {
	System.out.println("Name: " +last +", " +first);
	System.out.println("Age: " +age);
    }

    public boolean equals (Object p)
    {
	return (p instanceof Person && ((Person)p).first.equals(first) && ((Person)p).last.equals(last) && ((Person)p).age == age);
    }

    public int compareTo(Object p)
    {
	if(p instanceof Person)
	    {
		if(((Person)p).age < age)
		    {
			return 1;
		    }
		else
		    {
			return -1;
		    }
	    }
	return 0;
    }

    public Object clone()
    {
	Person cloned = new Person(first, last, age);
	return cloned;
    }

    class TooOldException extends Exception
    {

	public TooOldException()
	{
	    super();
	}

	public TooOldException(String in)
	{
	    super(in);
	}
    }

    class CapErrorException extends Exception
    {
	public CapErrorException()
	{
	    super();
	}
	public CapErrorException(String in)
	{
	    super(in);
	}
    }

}