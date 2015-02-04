
public class LinkedQueue<T> implements QueueADT<T> {

	private LinearNode<T> head, tail;
	private int count;
	public LinkedQueue(){
		head = tail = null;
		count = 0;
	}
	@Override
	public void enqueue(T element) {//add to rear
		// TODO Auto-generated method stub
		LinearNode<T> newNode = new LinearNode<T>(element);
		if(tail == null)
			head = tail = newNode;
		else{
			tail.setNext(newNode);
			tail = newNode;
		}
		count++;
		
	}

	@Override
	public T dequeue() {//remove from front
		// TODO Auto-generated method stub
		 if(isEmpty())
			 throw new EmptyCollectionException("LinkedQueue");
		 LinearNode<T> old = head;
		 head = head.getNext();
		 count--;
		 return old.getElement();
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if(size() == 0){
			throw new EmptyCollectionException("LinkedQueue"); 
		}
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	public String toString(){
		StringBuilder bldr = new StringBuilder();
		bldr.append("[");
		LinearNode<T> current = head;
		while(current != null){
			bldr.append(current.getElement());
			current = current.getNext();
			bldr.append(", ");
		}
		if(size() > 0 )
			bldr.delete(bldr.length() - 2, bldr.length());
		bldr.append("]");
		return bldr.toString();
		
	}

}
