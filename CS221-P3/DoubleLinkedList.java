import java.util.*;

/**
 * Implementation of the DoubleLinkedListADT
 * 
 * @author nmcnew
 */
public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
	private LinearNode<T> head, tail;
	private int count;
	private int modCount;

	public DoubleLinkedList() {
		head = tail = null;
		count = 0;
		modCount = 0;
	}

	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element
	 *            the element to be added to the front of this list
	 */
	public void addToFront(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (head == null)
			head = tail = newNode;
		else {
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		count++;
		modCount++;

	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of this list
	 */
	public void addToRear(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (tail == null)
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element after the specified target.
	 *
	 * @param element
	 *            the element to be added after the target
	 * @param target
	 *            the target is the item that the element will be added after
	 * @throws ElementNotFoundException
	 *             if target element is not in this list
	 */
	public void addAfter(T element, T target) {
		if (isEmpty())
			throw new ElementNotFoundException("DoubleLinkedList");
		ListIterator<T> it = listIterator();
		boolean found = false;
		while (!found && it.hasNext()) {
			T val = it.next();
			if (val.equals(target)) {
				it.add(element);
				found = true;
			}
		}
		if (!found)
			throw new ElementNotFoundException("DoubleLinkedList");
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	public T removeFirst() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		LinearNode<T> old = head;
		if (size() == 1)
			head = tail = null;
		else {
			head = head.getNext();
			head.setPrev(null);
		}
		modCount++;
		count--;
		return old.getElement();
	}

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return the last element from this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	public T removeLast() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");

		LinearNode<T> old = tail;
		if (size() == 1)
			head = tail = null;
		else {
			tail = tail.getPrev();
			tail.setNext(null);
		}
		modCount++;
		count--;
		return old.getElement();
	}

	/**
	 * Removes and returns the specified element from this list.
	 *
	 * @param element
	 *            the element to be removed from the list
	 * @throws ElementNotFoundException
	 *             if element is not in this list
	 */
	public T remove(T element) {
		if (isEmpty())
			throw new ElementNotFoundException("DoubleLinkedList");
		ListIterator<T> it = listIterator();
		while (it.hasNext()) {
			T val = it.next();
			if (val.equals(element)) {
				it.remove();
				return val;
			}
		}
		throw new ElementNotFoundException("DoubleLinkedList");
	}

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	public T first() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		return head.getElement();
	}

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	public T last() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		return tail.getElement();
	}

	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target
	 *            the target that is being sought in the list
	 * @return true if the list contains this element, else false
	 */
	public boolean contains(T target) {
		if (isEmpty())
			return false;
		ListIterator<T> it = listIterator();
		boolean found = false;
		while (it.hasNext() && !found) {
			if (it.next().equals(target)) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return (count == 0);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	public int size() {
		return count;
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
	 *             if the index is out of range (index < 0 || index > size())
	 */
	public void add(int index, T element) {
		if (index > count || index < 0) {
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		if (index == 0) {
			addToFront(element);
		} else if (index == count) {
			addToRear(element);
		} else {
			ListIterator<T> it = listIterator(index);
			it.add(element);
		}

	}

	/**
	 * Sets the element at the specified index.
	 *
	 * @param index
	 *            the index into the array to which the element is to be set
	 * @param element
	 *            the element to be set into the list
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public void set(int index, T element) {
		if (index >= count || isEmpty() || index < 0)
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		if (index == 0) {
			head.setElement(element);
			modCount++;
		} else if (index == size() - 1) {
			tail.setElement(element);

			modCount++;
		} else {
			ListIterator<T> it = listIterator(index);
			it.set(element);
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
	 * Returns a reference to the element at the specified index.
	 *
	 * @param index
	 *            the index to which the reference is to be retrieved from
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public T get(int index) {
		if (index >= count || index < 0)
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		if (index == 0)
			return head.getElement();
		else if (index == size() - 1)
			return tail.getElement();
		else {
			ListIterator<T> it = listIterator(index);
			return it.next();
		}
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
		if (isEmpty())
			return -1;
		int i = 0;
		ListIterator<T> it = listIterator();
		while (it.hasNext()) {
			if (it.next().equals(element))
				return i;
			else
				i++;
		}
		return -1;
	}

	/**
	 * Returns the element at the specified element.
	 *
	 * @param index
	 *            the index of the element to be retrieved
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public T remove(int index) {
		if (index >= count || index < 0)
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		T element;
		if (size() == 1) {
			element = head.getElement();
			head = tail = null;
			count--;
			modCount++;
		} else if (index == 0) {
			head.getNext().setPrev(null);
			element = head.getElement();
			head = head.getNext();
			count--;
			modCount++;
		} else if (index == size() - 1) {
			tail.getPrev().setNext(null);
			element = tail.getElement();
			tail = tail.getPrev();
			count--;
			modCount++;

		} else {
			ListIterator<T> it = listIterator(index);
			element = it.next();
			it.remove();
		}
		return element;
	}

	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of this list
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			builder.append(it.next());
			builder.append(", ");
		}
		if (size() > 0) {
			builder.delete(builder.length() - 2, builder.length());
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Returns an iterator for the elements in this list.
	 *
	 * @return an iterator over the elements in this list
	 */
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return listIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIterator();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		// TODO Auto-generated method stub
		if (startingIndex > size() || startingIndex < 0)
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		return new DoubleLinkedListIterator(startingIndex);
	}

	private class DoubleLinkedListIterator implements ListIterator<T> {

		private int iteratorModCount;
		private LinearNode<T> next;//
		private int index;
		private boolean canRemoveNext;
		private boolean canRemovePrev;

		public DoubleLinkedListIterator() {
			next = head;
			iteratorModCount = modCount;
			index = 0;
			canRemoveNext = canRemovePrev = false;

		}

		public DoubleLinkedListIterator(int startingIndex) {
			if (startingIndex == 0) {
				next = head;
				iteratorModCount = modCount;
				index = 0;
				canRemoveNext = canRemovePrev = false;
			} else {
				next = head;
				iteratorModCount = modCount;
				index = startingIndex;// set next to this index
				canRemovePrev = false;
				for (int i = 0; i <= index; i++) {
					next = next.getNext();
				}
				canRemoveNext = true;
			}
		}

		/**
		 * Returns true if this list iterator has more elements when traversing
		 * the list in the forward direction. (In other words, returns true if
		 * next() would return an element rather than throwing an exception.)
		 * 
		 * @return true if the list iterator has more elements when traversing
		 *         the list in the forward direction
		 */
		public boolean hasNext() {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			if (head == null)
				return false;
			return (next != null);
		}

		/**
		 * Returns the next element in the list and advances the cursor
		 * position. This method may be called repeatedly to iterate through the
		 * list, or intermixed with calls to previous() to go back and forth.
		 * (Note that alternating calls to next and previous will return the
		 * same element repeatedly.)
		 * 
		 * @return the next element in the list
		 * @throws NoSuchElementException
		 *             if the iteration has no next element
		 */
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException("DoubleLinkedList");
			LinearNode<T> old = next;
			next = next.getNext();
			index++;
			canRemoveNext = true;
			canRemovePrev = false;
			return old.getElement();

		}

		/**
		 * Inserts the specified element into the list (optional operation). The
		 * element is inserted immediately before the element that would be
		 * returned by next(), if any, and after the element that would be
		 * returned by previous(), if any. (If the list contains no elements,
		 * the new element becomes the sole element on the list.) The new
		 * element is inserted before the implicit cursor: a subsequent call to
		 * next would be unaffected, and a subsequent call to previous would
		 * return the new element. (This call increases by one the value that
		 * would be returned by a call to nextIndex or previousIndex.)
		 *
		 * @param arg0
		 *            the element to insert
		 * 
		 * @throws ConcurrentModificationException
		 *             when the list is modified outside of the iteration
		 */
		public void add(T arg0) {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			LinearNode<T> newElement = new LinearNode<T>(arg0);
			if (head == null) {
				head = tail = newElement;
			} else if (next == null) {
				tail.setNext(newElement);
				newElement.setPrev(tail);
				tail = newElement;
			} else if (next.getPrev() == null) {
				newElement.setNext(next);
				next.setPrev(newElement);
				head = newElement;
			} else if (next == null) {
				newElement.setPrev(next);
				next.setNext(newElement);
				tail = newElement;

			} else {
				newElement.setNext(next);
				newElement.setPrev(next.getPrev());
				next.getPrev().setNext(newElement);
				next.setPrev(newElement);
			}
			count++;
			index++;
			modCount++;
			iteratorModCount++;

			canRemoveNext = canRemovePrev = false;
		}

		/**
		 * Returns true if this list iterator has more elements when traversing
		 * the list in the reverse direction. (In other words, returns true if
		 * previous() would return an element rather than throwing an
		 * exception.)
		 * 
		 * @return true if the list iterator has more elements when traversing
		 *         the list in the reverse direction
		 * @throws ConcurrentModificationException
		 *             if the list has been modified outside of the iterator
		 */
		public boolean hasPrevious() {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			return (next != null);
		}

		/**
		 * Returns the index of the element that would be returned by a
		 * subsequent call to next(). (Returns list size if the list iterator is
		 * at the end of the list.)
		 * 
		 * @return the index of the element that would be returned by a
		 *         subsequent call to next, or list size if the list iterator is
		 *         at the end of the list
		 * 
		 * @throws ConcurrentModificationException
		 *             if the list has been modified outside of the iterator
		 */
		public int nextIndex() {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException("DoubleLinkedList");

			if (size() == 0 || next.getNext() == null) {
				return count;
			}
			return index + 1;
		}

		/**
		 * Returns the previous element in the list and moves the cursor
		 * position backwards. This method may be called repeatedly to iterate
		 * through the list backwards, or intermixed with calls to next() to go
		 * back and forth. (Note that alternating calls to next and previous
		 * will return the same element repeatedly.)
		 * 
		 * @return the previous element in the list
		 * @throws NoSuchElementException
		 *             if the iteration has no previous element
		 */
		public T previous() {
			if (!hasPrevious())
				throw new NoSuchElementException("DoubleLinkedList");
			LinearNode<T> old = next;
			next = next.getPrev();
			index--;
			canRemovePrev = true;
			canRemoveNext = false;
			return old.getElement();
		}

		/**
		 * Returns the index of the element that would be returned by a
		 * subsequent call to previous(). (Returns -1 if the list iterator is at
		 * the beginning of the list.)
		 * 
		 * @return the index of the element that would be returned by a
		 *         subsequent call to previous, or -1 if the list iterator is at
		 *         the beginning of the list
		 * 
		 * @ConcurrentModificationException if the list has been modified
		 *                                  outside of the iterator
		 */
		public int previousIndex() {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			if (size() == 0 || next.getPrev() == null)
				return -1;
			return index - 1;
		}

		/**
		 * Removes from the list the last element that was returned by next() or
		 * previous() (optional operation). This call can only be made once per
		 * call to next or previous. It can be made only if add(E) has not been
		 * called after the last call to next or previous.
		 * 
		 * @throws IllegalStateException
		 *             if neither next nor previous have been called, or remove
		 *             or add have been called after the last call to next or
		 *             previous
		 */
		public void remove() {
			if (!(canRemoveNext || canRemovePrev))
				throw new IllegalStateException("DoubleLinkedList");
			// General case for removePrev
			if (canRemovePrev) {
				if (tail.equals(head))
					head = tail = null;
				else if (next == null) {
					head.getNext().setPrev(null);
					head = head.getNext();

				} else if (next.getNext().equals(tail)) {
					next.setNext(null);
					tail = next;
				} else {
					// General Case
					next.setNext(next.getNext().getNext());
					next.getNext().setPrev(next);
				}
			}
			// General case for removeNext
			else if (canRemoveNext) {
				if (tail.equals(head))
					head = tail = null;
				else if (next == null) {
					tail.getPrev().setNext(null);
					tail = tail.getPrev();

				} else if (next.getPrev().equals(head)) {
					next.setPrev(null);
					head = next;
				} else {
					// General Case
					next.setPrev(next.getPrev().getPrev());
					next.getPrev().setNext(next);
				}

			}

			canRemoveNext = canRemovePrev = false;
			count--;
			index--;
			modCount++;
			iteratorModCount++;
		}

		/**
		 * Replaces the last element returned by next() or previous() with the
		 * specified element (optional operation). This call can be made only if
		 * neither remove() nor add(E) have been called after the last call to
		 * next or previous.
		 * 
		 * @throws IllegalStateException
		 *             if neither next nor previous have been called, or remove
		 *             or add have been called after the last call to next or
		 *             previous
		 */
		public void set(T arg0) {
			if (!(canRemoveNext || canRemovePrev))
				throw new IllegalStateException("DoubleLinkedList");
			if (head == tail && head != null)
				head.setElement(arg0);
			else if (canRemovePrev) {
				if (next == null) {
					head.setElement(arg0);
				} else
					next.getNext().setElement(arg0);
			} else if (canRemoveNext) {
				if (next == null) {
					tail.setElement(arg0);
				} else {
					next.getPrev().setElement(arg0);
				}
			}
		}
	}

}
