/**
 * SingleLinkedList represents a LinearNode-based implementation of both an
 * unordered and indexed list.
 *
 * @author Java Foundations,
 * @version 4.0
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements
		UnorderedListADT<T>, IndexedListADT<T> {
	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element
	 *            the element to be added to the list
	 */
	public void addToFront(T element) {

		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(head);
		head = newNode;
		if (tail == null) {
			tail = head;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the list
	 */
	public void addToRear(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param element
	 *            the element to be added to this list
	 * @param target
	 *            the target element to be added after
	 * @throws ElementNotFoundException
	 *             if the target is not found
	 */
	public void addAfter(T element, T target) {
		// TODO To be completed as a Programming Project
		if (head == null)
			throw new ElementNotFoundException("SingleLinkedList");
		boolean found = false;
		LinearNode<T> current = head;
		while (current != null && !found) {
			if (current.getElement().equals(target))
				found = true;
			else
				current = current.getNext();
		}
		if (!found)
			throw new ElementNotFoundException("SingleLinkedList");
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		if (tail == current)
			tail = newNode;
		count++;
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
	 * @throws IndexOutOfBoundsException
	 *             for invalid index
	 */
	public void add(int index, T element) {
		if (index > count)
			throw new IndexOutOfBoundsException("LinkedList");
		LinearNode<T> current = head;
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (index == 0) {
			addToFront(element);
		} else if (index == count) {
			tail.setNext(newNode);
			tail = newNode;

			count++;
			modCount++;
		} else {
			for (int i = 0; i < index; i++) {
				current = current.getNext();

			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);

			count++;
			modCount++;
		}

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
	 * Sets the element at the specified index.
	 *
	 * @param index
	 *            the index into the array to which the element is to be set
	 * @param element
	 *            the element to be set into the list
	 * @throws IndexOutOfBoundsException
	 *             for invalid index
	 */
	public void set(int index, T element) {
		if (index >= count)
			throw new IndexOutOfBoundsException("LinkedList");
		LinearNode<T> current = head;
		int i = 0;
		while (i < index) {
			i++;
			current = current.getNext();
		}
		current.setElement(element);
	}

	/**
	 * Returns a reference to the element at the specified index.
	 *
	 * @param index
	 *            the index to which the reference is to be retrieved from
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException
	 *             for invalid index
	 */
	public T get(int index) {
		if (index >= count || head == null)
			throw new IndexOutOfBoundsException("LinkedList");
		LinearNode<T> current = head;
		for (int i = index; i > 0; i--) {
			current = current.getNext();
		}
		return current.getElement();
	}

	/**
	 * Returns the index of the specified element.
	 *
	 * @param element
	 *            the element for the index is to be retrieved
	 * @return the integer index for this element or -1 if element is not in the
	 *         list
	 */
	public int indexOf(T element) {
		LinearNode<T> current = head;
		for (int i = 0; i < count; i++) {
			if (current.getElement().equals(element)) {
				return (i);
			}
			current = current.getNext();
		}
		throw new ElementNotFoundException("LinkedList");
	}

	/**
	 * Returns the element at the specified element.
	 *
	 * @param index
	 *            the index of the element to be retrieved
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException
	 *             for invalid index
	 */
	public T remove(int index) {
		if (index >= count)
			throw new IndexOutOfBoundsException("LinkedList");
		LinearNode<T> current = head;
		T retVal;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		if(index == 0){
			head = current.getNext();
			retVal = current.getElement();
		}
		else if (current.getNext() == null) {
			retVal = current.getElement();
			head = tail = null;
		} else if (current.getNext() == tail) {
			retVal = current.getNext().getElement();
			current.setNext(null);
		} else {
			retVal = current.getNext().getElement();
			current.setNext(current.getNext().getNext());
		}
		count--;
		modCount++;
		return retVal;
	}
}
