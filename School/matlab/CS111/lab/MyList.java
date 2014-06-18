/* Francis Murray CS111 MyList file Lab 13 Friday April 20 2012 */

public class MyList<T>
{
    private Node<T> head;
    private int numElements;

    private static class Node<T>
    {
	private T data;
	private Node<T> next;
	
	private Node (T d)
	{
	    data =d;
	    next= null;
	}
    }
   
    public MyList()
    {
	head = null;
	numElements = 0;
    }

    public void add(T it)
    {
	if(head == null)
	    {
		head = new Node<T>(it);
	    }
	else
	    {
		Node<T> ptr = head;
		while(ptr.next != null)
		    {
			ptr = ptr.next;
		    }
		ptr.next = new Node<T>(it);
	    }
	numElements++;
    }
    public T front()
    {
	if(head == null)
	    {
		return null;
	    }
	return head.data;
    }
    
    public T remove()
    {
	Node<T> temp;
	
	temp = head;
	head = head.next;
	numElements--;
	return temp.data;
    }

    public boolean empty()
    {
	if(head == null)
	    {
		return true;
	    }
	return false;
    }
    
    public void display()
    {
	Node<T> temp;
	temp = head;
	for(int i =0; i < numElements; i++)
	    {
		System.out.println(temp.data);
		temp=temp.next;
	    }
    }
}

    