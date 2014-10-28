/**
 * ArrayList represents an array implementation of both an unordered and indexed
 * list.
 *
 * @author Java Foundations,
 * @version 4.0
 */
public class ArrayList<T> extends AbstractArrayList<T> implements UnorderedListADT<T>, IndexedListADT<T> {
	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayList() {
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity
	 *            the intial size of the list
	 */
	public ArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Adds the specified element to the front of this list.
	 * 
	 * @param element
	 *            the element to be added to the front of the list
	 */
	public void addToFront(T element) {
		if (size() == list.length)
			expandCapacity();

		for (int shift = rear; shift > 0; shift--) {
			list[shift] = list[shift - 1];
		}
		list[0] = element;
		rear++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the list
	 */
	public void addToRear(T element) {
		if (size() == list.length)
			expandCapacity();
		list[rear] = element;
		rear++;
		modCount++;
	}

	/**
	 * Adds the specified element after the specified target element. Throws an
	 * ElementNotFoundException if the target is not found.
	 *
	 * @param element
	 *            the element to be added after the target element
	 * @param target
	 *            the target that the element is to be added after
	 */
	public void addAfter(T element, T target) {
		if(!contains(target)) throw new ElementNotFoundException("ArrayList");
		if (size() == list.length)
			expandCapacity();

		int scan = 0;

		// find the insertion point
		while (scan < rear && !target.equals(list[scan]))
			scan++;

		if (scan == rear)
			throw new ElementNotFoundException("UnorderedList");

		scan++;

		// shift elements up one
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];

		// insert element
		list[scan] = element;
		rear++;
		modCount++;
	}

	/**
	 * Inserts the specified element at the specified index.
	 * 
	 * @param index
	 *            the index into the array to which the element is to be
	 *            inserted.
	 * @param element
	 *            the element to be inserted into the array
	 */
	public void add(int index, T element) throws IndexOutOfBoundsException {
		if (size() == list.length)
			expandCapacity();
		if (index > rear)
			throw new IndexOutOfBoundsException("ArrayList");
		T oldElement = list[index];

		list[index] = element;
		for (int shift = rear; shift > index; shift--)
			list[shift] = list[shift - 1];
		rear++;
		list[index+1] = oldElement;

	}

	/**
	 * Sets the element at the specified index.
	 *
	 * @param index
	 *            the index into the array to which the element is to be set
	 * @param element
	 *            the element to be set into the list
	 */
	public void set(int index, T element) {
		if (index >= rear)
			throw new IndexOutOfBoundsException("ArrayList");
		list[index] = element;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of the list
	 */
	public void add(T element) {
		addToRear(element);
	}

	/**
	 * Returns a reference to the element at the specified index.
	 *
	 * @param index
	 *            the index to which the reference is to be retrieved from
	 * @return the element at the specified index
	 */
	public T get(int index) {
		if (index >= rear)
			throw new IndexOutOfBoundsException("ArrayList");
		return list[index];
	}

	/**
	 * Returns the index of the specified element.
	 *
	 * @param element
	 *            the element for the index is to be retrieved
	 * @return the integer index for this element
	 */
	public int indexOf(T element) {
		if (!contains(element))
			throw new ElementNotFoundException("ArrayList");
		int scan = 0;
		int result = -1;

		if (!isEmpty())
			while (result == -1 && scan < rear)
				if (element.equals(list[scan]))
					result = scan;
				else
					scan++;

		return result;
	}

	/**
	 * Returns the element at the specified element.
	 *
	 * @param index
	 *            the index of the element to be retrieved
	 * @return the element at the given index
	 */
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index >= rear)
			throw new IndexOutOfBoundsException("ArrayList");
		T oldElement = list[index];
			for (int shift = index; shift < rear; shift++) {
				list[shift] = list[shift + 1];
			}
		rear--;
		return oldElement;
	}
}
