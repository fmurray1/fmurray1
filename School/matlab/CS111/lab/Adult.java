/* Francis Murray Adult Class CS111 Friday March 2nd 2012 */

public class Adult extends Person
{
    String job;
    
    public Adult()
    {
	super();
	job = "None";
    }
    
    public Adult(String f, String l, int a, String j) throws TooYoungException 
    {
	Adult b = new Adult();
	char c, d;
        c = f.charAt(0);
	d = l.charAt(0);
	if(a >=18 && a < 123 && Character.isUpperCase(c) && Character.isUpperCase(d))
	    {
		try
		    {
			super.setFirst(f);
			super.setLast(l);
			super.setAge(a);
			job = j;
		    }
		catch(Exception e)
		    {}
	    }
	else
	    {	      
		throw new TooYoungException();
	    }
    }
    
    class TooYoungException extends Exception
    {
	public TooYoungException()
	{
	    super();
	}
	 
	public TooYoungException(String in)
	{
	    super(in);
	}
    }

    public void setJob(String j)
    {
	job = j;
    }
    
    public String getJob()
    {
	return job;
    }

    public void printPerson()
    {
	super.printPerson();
	System.out.println("Occupation: " +job);
    }
}