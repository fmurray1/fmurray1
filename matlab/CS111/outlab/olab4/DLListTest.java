/* Doubly Linked List Tester Program */

public class DLListTest
{
    public static void main(String [] args) throws Exception
    {
	DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
	DoublyLinkedList<String> list2;
	DoublyLinkedList<Integer> list3 = new DoublyLinkedList<Integer>();
	
	try
	    {
		//add something to list1
		list1.insert("Hello");
	
		//set list2 equal to list1 -not working
		list2 = new DoublyLinkedList<String>(list1);
		
		//testing some functions on list1
		list1.insert("World");
		list1.begin();
		list1.retreat();
		System.out.print(list1.current() +" ");
		list1.retreat();
		System.out.println(list1.current());
	       
		//testing list empty exception
		list1.remove("Hello");
		//list1.remove("World");
		list1.advance();
		
		//testing other functions on list2 -not working
		list2.advance();
		System.out.println(list2.current());
		list2.remove("Hello");
		list2.advance(); 
			
	    }
	
	catch(ListEmptyException e)
	    {
		System.out.println("The ListEmptyException worked");
	    }

	try
	    {
		//adding things to list3 for testing
		list3.insert(1);
		list3.insert(2);
		list3.insert(3);
		list3.insert(4);

		//print out the list forward 
		list3.begin();
		list3.advance();
		while(!list3.end())
		    {
			System.out.println(list3.current());
			list3.advance();
		    }
		System.out.println(list3.current());

		//print out the list backwards
		list3.begin();
		list3.retreat();
		while(!list3.end())
		    {
			System.out.println(list3.current());
			list3.retreat();
		    }
		
		//testing the rest of the functions on list3
		System.out.println("The size of list 3 is: " +list3.size());
		list3.remove(3);
		System.out.println("The size of the list after 1 element was removed is: " +list3.size());
		//tsting not in list exception
		list3.remove(5);
	    }

	catch(NotInListException e)
	    {
		System.out.println("Your NotInListException Worked");
	    }
    }
}