//Not in list exception class

public class NotInListException extends Exception
{
    public NotInListException()
    {
	super();
    }	

    public NotInListException(String s)
    {
	super(s);
    }
}