
/**
 * @author ncmnew
 *
 * @param <T> Datetype
 */
public class MinStack<T> implements StackADT<T> {
	
	protected LinearNode<T> head;
	protected int count;
	
	public MinStack(){
		head  = null;
		count = 0;
	}
	
	public void push(T element) {
		LinearNode<T> newElement = new LinearNode<T>(element);
		newElement.setNext(head);
		head = newElement;		
		count++;
	}

	@Override
	public T pop() {
		if(isEmpty()) throw new EmptyCollectionException("Stack");
		LinearNode<T> current = head;
		head = head.getNext();
		count--;
		return current.getElement();
	}

	@Override
	public T peek() {
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}

    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	LinearNode<T> next = head;
    	while(next != null){
    		builder.append(next.getElement());
    		next = next.getNext();
    	}
    	return builder.toString();
    }
}

