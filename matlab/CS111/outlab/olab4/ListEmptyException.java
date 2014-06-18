//List Empty Exception class

public class ListEmptyException extends Exception
{

    public ListEmptyException()
    {
	super();
    }

    public ListEmptyException(String s)
    {
	super(s);
    }
}