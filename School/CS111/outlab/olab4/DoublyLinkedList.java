/* Francis Murray CS111 Out Of Lab 4 Assignment */

public class DoublyLinkedList<T extends Comparable <T>> 
{
    
    private static class Node<T>
    {
	private T data;
	private Node<T> next;
	private Node<T> previous;
	
	private Node (T d)
	    {
		data = d;
		next = null;
		previous = null;
	    }
	
	private Node (T d, Node<T> pref, Node<T> nref)
	    {
		data = d;
		next = nref;
		previous = pref;
	    }

    }

    private Node<T> head;
    private Node<T> current;
    private int size;

    public DoublyLinkedList()
	{
	    size = 0;
	    head = new Node<T>(null);
	    head.next = head;
	    head.previous = head;
	}

    public DoublyLinkedList (DoublyLinkedList<T> l) throws ListEmptyException
	{
	    head = new Node<T>(null);
	    head.next = head;
	    head.previous = head;
	    Node<T> ptr = l.head.next;
	    while(ptr != l.head)
		{
		    insert(ptr.data);
		    ptr = ptr.next;
		}
	    size = l.size;
	    begin();
	}
    
    


    public void insert(T d)
    {
	Node<T> temp = new Node<T>(d);
	begin();
	advance();
	//System.out.println("current " +current.data + " head " + head.data + " d " +d);
	while(current != head && d.compareTo(current.data) > 0)
	    {
		advance();
	    }
	temp.next = current;
	temp.previous = current.previous;
	current.previous.next = temp;
	current.previous = temp;
	current = temp;
	size++;
    }

    public void remove(T d) throws ListEmptyException, NotInListException
    {
	
	if(head.next == head)
	    {
		throw new ListEmptyException();
	    }
	begin();
	advance();
	while(current != head && !d.equals(current.data))
	    {
		advance();
	    }
	if(current == head)
	    {
		throw new NotInListException();
	    }
	current.previous.next = current.next;
	current.next.previous = current.previous;
	current = current.next;
	size--;
    
    }
    
    public void begin()
    {
	current = head;
    }
    
    
    public void advance()
    {
	current = current.next;
    }
    
    
    public void retreat() 
    {
	
	current = current.previous;
    }
    

    public T current() throws ListEmptyException
    {
	if(head.next == head)
	    {
		throw new ListEmptyException();
	    }
	return current.data;
    }

    public boolean end()
    {
	if(current.next == head)
	    {
		return true;
	    }
	return false;
    }

    public boolean empty()
    {
	if(head.next == head)
	    {
		return true;
	    }
	return false;
    }
    
    public int size()
    {
	return size;
    }
}