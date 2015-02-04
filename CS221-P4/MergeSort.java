import java.util.*;

/**
 * Class for sorting DoubleLinkedLists using either natural order or a
 * Comparator.
 *
 * @author spanter, mvail, nmcnew
 */
public class MergeSort {
	/**
	 * Sorts a list that implements the DoubleLinkedListADT using the natural
	 * ordering of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The data type in the list must extend Comparable
	 * @param list
	 *            The list that will be sorted
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> void sort(DoubleLinkedListADT<T> list) {
		list = mergeSort(list, 0, list.size()-1);
	}

	/**
	 * Helper method for sort that allows for recursion to happen
	 * 
	 * @param list the list provided to the method that will be split
	 * @param min the point in the list to begin
	 * @param max  the point in the list to end at
	 */
	private static <T extends Comparable<T>> DoubleLinkedListADT<T> mergeSort(DoubleLinkedListADT<T> list, int min, int max) {

		if (min < max) {
			DoubleLinkedListADT<T> leftList = new WrappedDLL<T>();
			DoubleLinkedListADT<T> rightList = new WrappedDLL<T>();
			
			int mid = (min + max) / 2;

			ListIterator<T> lefterator = list.listIterator(min);
			ListIterator<T> righterator = list.listIterator(mid + 1);
			
			while(lefterator.nextIndex() <= mid)
				leftList.add(lefterator.next());
			
			while(righterator.nextIndex() <= max)
				rightList.add(righterator.next());
			
			leftList = mergeSort(leftList, 0, mid);
			rightList = mergeSort(rightList, 0, rightList.size() - 1);
			
			DoubleLinkedListADT<T> merged = merge(leftList, rightList);
			
			ListIterator<T> listerator = list.listIterator(min);
			ListIterator<T> mergedator = merged.listIterator();
			
			while(mergedator.hasNext()){

				listerator.next();
				listerator.set(mergedator.next());
			}
		}
		return list;
	}
	/**
	 *  Merges two lists provided into one list in natural order.
	 * @param left list from min to mid
	 * @param right list from mid to max
	 * @return a list to mergeSort() to add back to the list
	 */
	private static <T extends Comparable<T>> DoubleLinkedListADT<T> merge(DoubleLinkedListADT<T> left, DoubleLinkedListADT<T> right) {
		DoubleLinkedListADT<T> newList = new WrappedDLL<T>();
		ListIterator<T> lefterator = left.listIterator();
		ListIterator<T> righterator = right.listIterator();
		while (left.size() > 0  && right.size() > 0 ) {
			if (left.first().compareTo(right.first()) < 0) {
				newList.add(lefterator.next());
				lefterator.remove();
			} else {
				newList.add(righterator.next());
				righterator.remove();
			}
		}
		
		// move over first set's data, if any
		while (left.size() > 0) {
			newList.add(lefterator.next());
			lefterator.remove();
		}
		// move over second set's data, if any
		while (right.size() > 0) {
			newList.add(righterator.next());
			righterator.remove();
		}
		// copy merged data into original list
		return newList;

	}

	/**
	 * Sorts a DoubleLinkedListADT with the provided Comparator. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of list to sort
	 * @param list
	 *            The list to sort
	 * @param c
	 *            The Comparator to use
	 * @see DoubleLinkedListADT
	 */
	public static <T> void sort(DoubleLinkedListADT<T> list, Comparator<T> c) {
		list = mergeSort(list, 0, list.size()-1, c);
	}

	/**
	 * Recursive helper method that breaks the list into sublists
	 * 
	 * @param list the list provided to the method that will be split
	 * @param min the point in the list to begin
	 * @param max  the point in the list to end at
	 */
	private static <T> DoubleLinkedListADT<T> mergeSort(DoubleLinkedListADT<T> list, int min, int max, Comparator<T> c) {

		if (min < max) {
			DoubleLinkedListADT<T> leftList = new WrappedDLL<T>();
			DoubleLinkedListADT<T> rightList = new WrappedDLL<T>();
			
			int mid = (min + max) / 2;

			ListIterator<T> lefterator = list.listIterator(min);
			ListIterator<T> righterator = list.listIterator(mid + 1);
			
			while(lefterator.nextIndex() <= mid)
				leftList.add(lefterator.next());
			
			while(righterator.nextIndex() <= max)
				rightList.add(righterator.next());
			
			leftList = mergeSort(leftList, 0, mid, c);
			rightList = mergeSort(rightList, 0, rightList.size() - 1, c);
			
			DoubleLinkedListADT<T> merged = mergeWithComp(leftList, rightList, c);
			
			ListIterator<T> listerator = list.listIterator(min);
			ListIterator<T> mergedator = merged.listIterator();
			
			while(mergedator.hasNext()){

				listerator.next();
				listerator.set(mergedator.next());
			}
		}
		return list;
	}
	/**
	 *  Merges two lists provided into one list in order determined by the comparator
	 * @param left list from min to mid
	 * @param right list from mid to max
	 * @return a list to mergeSort() to add back to the list
	 */
	private static <T> DoubleLinkedListADT<T> mergeWithComp(DoubleLinkedListADT<T> left, DoubleLinkedListADT<T> right, Comparator<T> c) {
		DoubleLinkedListADT<T> newList = new WrappedDLL<T>();
		ListIterator<T> lefterator = left.listIterator();
		ListIterator<T> righterator = right.listIterator();
		while (left.size() > 0  && right.size() > 0 ) {
			if (c.compare(left.first(), right.first()) < 0) {
				newList.add(lefterator.next());
				lefterator.remove();
			} else {
				newList.add(righterator.next());
				righterator.remove();
			}
		}
		
		// move over first set's data, if any
		while (left.size() > 0) {
			newList.add(lefterator.next());
			lefterator.remove();
		}
		// move over second set's data, if any
		while (right.size() > 0) {
			newList.add(righterator.next());
			righterator.remove();
		}
		// copy merged data into original list
		return newList;

	}

	/**
	 * Finds the smallest element in a list according to the natural ordering of
	 * list elements. Does not alter the order of list elements. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findSmallest(DoubleLinkedListADT<T> list) {

		if (list.size() == 0)
			return null;
		if (list.size() == 1)
			return list.first();
		else {
			return findSmallestHelper(list, list.listIterator());
		}

	}
	/**
	 * Helper class for FindSmallest
	 * @param <T>
	 * 		the type of object we are comparing
	 * 
	 * @param list
	 * 		list to find the smallest
	 * @param iter
	 * 		list iterator to be used
	 * 
	 * @return smallest number
	 */
	private static <T extends Comparable<T>> T findSmallestHelper(DoubleLinkedListADT<T> list, ListIterator<T> iter) {
		T min = iter.next();
		if (!iter.hasNext()) {
			return min;
		} else {
			T find = findSmallestHelper(list, iter);
			if (find.compareTo(min) > 0) {
				return min;
			} else {
				return find;
			}
		}
	}

	/**
	 * Finds the smallest element in a list with a Custom comparator. Does not
	 * alter the order of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findSmallest(DoubleLinkedListADT<T> list, Comparator<T> c) {
		if (list.size() == 0)
			return null;
		if (list.size() == 1)
			return list.first();
		else {
			return findSmallestCompHelper(list, list.listIterator(), c);
		}

	}
	/**
	 * Find smallest with a comparator helper class to do the bulk of the recursion
	 * @param list list to find smallest from
	 * @param iter iterator to use to go through the list
	 * @param c comparator to use
	 * @return smallest item determined by comparator
	 */
	private static <T> T findSmallestCompHelper(DoubleLinkedListADT<T> list, ListIterator<T> iter, Comparator<T> c) {
		T min = iter.next();
		if (!iter.hasNext()) {
			return min;
		} else {
			T find = findSmallestCompHelper(list, iter, c);
			if (c.compare(find, min) > 0) {
				return min;
			} else {
				return find;
			}
		}
	}

	/**
	 * Finds the largest element in a list according to the natural ordering of
	 * list elements. Does not alter the order of list elements. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findLargest(DoubleLinkedListADT<T> list) {
		if (list.size() == 0) {
			return null;
		}
		if (list.size() == 1) {
			return list.first();
		} else {
			return FindLargestHelper(list, list.listIterator());
		}

	}
	/**
	 * Helper class that Finds the largest item from a list using recursion
	 * @param list list to find the largest from
	 * @param it iterator that is passed on each iteration so It can keep its place
	 * @return largest item
	 */
	private static <T extends Comparable<T>> T FindLargestHelper(DoubleLinkedListADT<T> list, ListIterator<T> it) {
		T max = it.next();

		if (!it.hasNext()) {
			return max;
		} else {
			T find = FindLargestHelper(list, it);
			if (find.compareTo(max) < 0) {
				return max;
			} else {
				return find;
			}
		}
	}

	/**
	 * Finds the largest element in a list with a Custom comparator. Does not
	 * alter the order of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findLargest(DoubleLinkedListADT<T> list, Comparator<T> c) {
		if (list.size() == 0) {
			return null;
		}
		if (list.size() == 1) {
			return list.first();
		} else {
			return FindLargestCompHelper(list, list.listIterator(), c);
		}

	}
	/**
	 * Helps the find largest helper by doing the bulk of recursion and finding the smallest from 
	 * @param list list to find the largest item from
	 * @param it Iterator that is passed around to keep track of location
	 * @param c Comparator
	 * @return the largest item determined by the comparator
	 */
	private static <T> T FindLargestCompHelper(DoubleLinkedListADT<T> list, ListIterator<T> it, Comparator<T> c) {
		T max = it.next();

		if (!it.hasNext()) {
			return max;
		} else {
			T find = FindLargestCompHelper(list, it, c);
			if (c.compare(find,max) < 0) {
				return max;
			} else {
				return find;
			}
		}
	}
}
