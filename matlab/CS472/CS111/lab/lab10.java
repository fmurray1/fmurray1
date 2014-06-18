/* Francis Murray CS111 Lab 10 Friday March 16th 2012 */

import java.util.Scanner;
import java.util.Stack;

public class lab10
{
    public static void main(String [] args)
    {
	Stack<Character> a = new Stack<Character>();
	String word;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Please enter a word: ");
	word = sc.nextLine();
	
	for(int i = 0; i < word.length(); i++)
	{
	    a.push(word.charAt(i));
	}
	
	if(isPalindrome(a, word))
	    {
		System.out.println(word +" is a palindrome!");
	    }
	else
	    {
		System.out.println(word +" is not a palindrome :(");
	    }
    }

    public static boolean isPalindrome(Stack<Character> b, String original)
    {
	String rWord="";
	for(int j = 0; j < original.length(); j++)
	    {
		rWord += b.pop();
	    }
	if(original.equals(rWord))
	    {
		return true;
	    }
	return false;
    }
}
