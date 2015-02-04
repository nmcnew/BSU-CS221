import java.util.Arrays;


public class CircularArrayQueue<T> implements QueueADT<T>{

	protected final static int DEFAULT_CAPACITY = 100;
	
	protected T[] array;
	protected int front, rear, count;
	public CircularArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public CircularArrayQueue(int initialCapacity) {
		rear = 0;
		array = (T[]) (new Object[initialCapacity]);
	}
    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[array.length *2]);
    
        for (int scan = 0; scan < count; scan++)
        {
            larger[scan] = array[front];
            front = (front + 1) % array.length;
        }
    
        front = 0;
        rear = count;
        array = larger;
    }
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
        if (size() == array.length) 
            expandCapacity();
    
        array[rear] = element;
        rear = (rear+1) % array.length;
    
        count++;
	}

	@Override
	public T dequeue() {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
    
        T result = array[front];
        array[front] = null;
        front = (front+1) % array.length;
    
        count--;
    
        return result;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return array[front];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

    public String toString(){
    	StringBuilder str = new StringBuilder();
    	str.append("[");
        for (int scan = 0; scan < count; scan++)
        {
            str.append(array[(front + scan) % array.length] + ", ");
        }
        if(array.length > 0)
        str.delete(str.length()-2, str.length());
        str.append("]");
        return str.toString();
    }
}
