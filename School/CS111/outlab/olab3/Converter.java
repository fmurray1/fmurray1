/* Intfix to Postfix Converter */

import java.util.*;

public class Converter
{
    public static Queue <Character> expression = new LinkedList <Character>();
    public static Queue <Character> converted = new LinkedList <Character>();
    public static final char PLUS = '+', MINUS = '-', MULT = '*', DIV = '/';
    //public static 
    //public enum Operator {PLUS, MINUS, MULT, DIV};
    //public static Operator operator;

    public static void main (String [] args) throws Exception
    {
	Scanner sc = new Scanner(System.in);	
	String equationS;
	char last=' ', secondLast=' ';
	int pCount=0;
	Stack <Character> aStack = new Stack<Character>();

	System.out.println("This program converts an equation from infix to postfix");
	
	try
	    {
		do
		    {
			System.out.println("Enter an equation to convert or CTRL+D to end");
			equationS = sc.nextLine();
			
			for(int i = 0; i < equationS.length(); i++)
			    {
				expression.add(equationS.charAt(i));
			    }
			
			int el;
			el = expression.size();
			for(int j = 0; j < el; j++)
			    {
				switch(expression.element())
				    {
					
				    case PLUS:
				    case MINUS:
				    case MULT:
				    case DIV:
					if(last == ' '&& j == 0)
					    {
						throw new MissingOpperandException();
					    }
					else if(last == PLUS || last == MINUS || last == MULT || last == DIV && j !=0)
					    {
						throw new MissingOpperandException();
					    }
					else
					    {
						//System.out.println("found the operator");
						while(!aStack.isEmpty() && aStack.peek() != '(' && findPres(expression.element()) <= findPres(aStack.peek()))
						    { 
							converted.add(aStack.pop());
						    }
						last = expression.remove();
						aStack.push(last);
						
						if(expression.isEmpty())
						    {
							throw new MissingOpperandException();
						    }
						else if(expression.element() == PLUS || expression.element() == MINUS || expression.element() == MULT || expression.element() == DIV)
						    {
							throw new MissingOpperandException();
						    }
					    }
					break;
					
				    case '(':
					
					pCount++;
					aStack.push(expression.remove());
					break;
					
				    case ')':
					
					pCount--;
					if(pCount < 0) // checks to see if there are not enough open parentheses
					    {
						throw new MismatchedParenthesesException();
					    }
					while(aStack.peek() != '(')
					    {
						converted.add(aStack.pop());
					    }
					aStack.pop();
					expression.remove();
					last = ' ';
					break;
					
				    default:
					//System.out.println(last);
					//System.out.println(j);
					if(expression.element()==' ') //ignores spaces
					    {
						expression.remove();
					    }
					else if(last == PLUS || last == MINUS || last == MULT || last ==DIV || last == ' ')
					    {
						secondLast = last;
						last = expression.remove();
						//converted.add(last);
						if(secondLast == PLUS || secondLast == MINUS || secondLast == MULT || secondLast == DIV && findPres(secondLast) >= findPres(last))
						  {
							converted.add(secondLast);
							secondLast = ' ';
						  }
						else
						    {
							converted.add(last);
						    }
					    }
					else
					    {
						throw new MissingOpperatorException();
					    }
					break;
				    }
			    }
			if(pCount > 0)
			    {
				throw new MismatchedParenthesesException();
			    }
			else
			    {
				print();
			    }
			equationS = "";
			expression.clear();
			converted.clear();
		    }while(sc.hasNext());
	    }
	
	catch(MissingOpperandException moperand)
	    {
		System.out.println("You are missing an operand");
	    }
	catch(MissingOpperatorException moperator)
	    {
		System.out.println("You are missing an operator");
	    }
	catch(MismatchedParenthesesException mp)
	    {
		System.out.println("Your parentheses are mismatched");
	    }
    }

    public static int findPres(char op)
    {
	switch(op)
	    {
	    case '+':
		return 1;
	    case '-':
		return 1;
	    case '*':
		return 2;
	    case '/':
		return 2;
	    }
	return 0;
    }

    public static void print()
    {
	int ql;
	ql = converted.size();
	//System.out.println("Printing");
	for(int z = 0; z < ql; z++)
	    {
		System.out.print(converted.remove());
	    }
	System.out.println();
    }
}