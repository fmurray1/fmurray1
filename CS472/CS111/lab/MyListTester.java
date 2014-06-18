/* My List Tester */

public class MyListTester
{
    public static void main(String [] args)
    {
	MyList<String> ml = new MyList<String>();
	
	System.out.println("Is the list empty? " +ml.empty());
	
	ml.add("World");
	ml.add("Hello");
	
	ml.display();

	System.out.println("Is the list empty? " +ml.empty());
	
	ml.remove();
	
	ml.display();
	
	ml.remove();
	
	System.out.println("Is the list empty? " +ml.empty());
    }
}