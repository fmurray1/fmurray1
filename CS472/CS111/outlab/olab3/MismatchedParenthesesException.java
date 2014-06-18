/* Mismatched Parentheses Exception */

public class MismatchedParenthesesException extends Exception
{
    public MismatchedParenthesesException()
    {
	super();
    }
    
    public MismatchedParenthesesException(String s)
    {
	super(s);
    }
}