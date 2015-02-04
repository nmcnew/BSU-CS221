import java.util.ListIterator;
import java.util.Random;

/**
 * Class for testing my implementation of MergeSort
 *
 * @author nmcnew
 */

public class MergeSortTester {

	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	public static void main(String[] args) {
		MergeSortTester tester = new MergeSortTester();
		tester.runTests();

	}

	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc
	 *            description of the test
	 * @param result
	 *            indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}

	/**
	 * Generates a new empty list
	 * 
	 * @return new empty list
	 */
	private DoubleLinkedListADT<Integer> newEmptyList() {
		DoubleLinkedListADT<Integer> newList = new WrappedDLL<Integer>();
		return newList;
	}

	/**
	 * Generates a random list with java.util.Random package
	 * 
	 * @param amount
	 *            How long this list should be
	 * @return randomly ordered and numbered list
	 */
	private DoubleLinkedListADT<Integer> fillListRandom(int amount) {
		DoubleLinkedListADT<Integer> newList = newEmptyList();
		Random r = new Random();
		for (int i = 0; i < amount; i++) {
			newList.add(new Integer(r.nextInt()));
		}
		return newList;
	}
	/**
	 * Fills in with numbers decrimenting from amount to 1
	 * @param amount length of the list and starting number
	 * @param reverseList List to add the values to
	 */
	private void fillListReverse(int amount, DoubleLinkedListADT<Integer> reverseList) {
		for (int i = 1; i <= amount; i++) {
			reverseList.addToFront(i);
		}
	}
	/**
	 * random character list filler that fills in the list provided with a random character from A - Z, a - z
	 * @param amount length to be added to the list
	 * @param charList list to be added to
	 */
	private void fillListRandomChar(int amount, DoubleLinkedListADT<Character> charList){
		Random generator = new Random();
		for(int i = 0; i < amount; i++){
			int rnd = generator.nextInt(52);
		    char base = (rnd < 26) ? 'A' : 'a';
			charList.add((char) (base + rnd % 26));
		}
	    return ;
	}
	/**
	 * tests if a list is in natural order
	 * @param list list to check order
	 * @return true if the list is in natural order
	 */
	private <T extends Comparable<T>> boolean isInForwardOrder(DoubleLinkedListADT<T> list) {
		ListIterator<T> listerator = list.listIterator();
		T previous = listerator.next();
		while (listerator.hasNext()) {
			T next = listerator.next();
			if (next.compareTo(previous) < 0)
				return false;
			previous = next;
		}
		return true;
	}
	/**
	 * Checks if the list is in order from the custom comparator
	 * @param list list to check
	 * @return true if the list is in the correct order
	 */
	private <T extends Comparable<T>> boolean isInReverseOrder(DoubleLinkedListADT<T> list) {

		ListIterator<T> listerator = list.listIterator();
		T previous = listerator.next();
		while (listerator.hasNext()) {
			T next = listerator.next();
			if (next.compareTo(previous) > 0)
				return false;
			previous = next;
		}
		return true;
	}

	private void runTests() {
		// TEST ON A empty list
		printTest("testSortOnEmptyList", testSortOnEmptyList());
		printTest("testSortWithComperatorOnEmptyList", testSortWithComperatorOnEmptyList());
		printTest("testFindSmallestOnEmptyList", testFindSmallestOnEmptyList());
		printTest("testFindSmallestWithComperatorOnEmptyList", testFindSmallestWithComperatorOnEmptyList());
		printTest("testFindLargestOnEmptyList", testFindLargestOnEmptyList());
		printTest("testFindLargestWithComperatorOnEmptyList", testFindLargestWithComperatorOnEmptyList());

		// TESTON a single element list
		printTest("testSortOnOneElementList", testSortOnOneElementList());
		printTest("testSortWithComperatorOnOneElementList", testSortWithComperatorOnOneElementList());
		printTest("testFindSmallestOnOneElementList", testFindSmallestOnOneElementList());
		printTest("testFindSmallestWithComperatorOnOneElementList", testFindSmallestWithComperatorOnOneElementList());
		printTest("testFindLargestOnOneElementList", testFindLargestOnOneElementList());
		printTest("testFindLargestWithComperatorOnOneElementList", testFindLargestWithComperatorOnOneElementList());

		// TEST ON A two element List
		// reverse
		printTest("testSortOnTwoElementListReverse", testSortOnTwoElementListReverse());
		printTest("testSortWithComperatorOnTwoElementListReverse", testSortWithComperatorOnTwoElementListReverse());
		printTest("testFindSmallestOnTwoElementListReverse", testFindSmallestOnTwoElementListReverse());
		printTest("testFindSmallestWithComperatorOnTwoElementListReverse", testFindSmallestWithComperatorOnTwoElementListReverse());
		printTest("testFindLargestOnTwoElementListReverse", testFindLargestOnTwoElementListReverse());
		printTest("testFindLargestWithComperatorOnTwoElementListReverse", testFindLargestWithComperatorOnTwoElementListReverse());

		// Random three element sort test
		printTest("testSortOnThreeElementListReverse", testSortOnThreeElementListReverse());

		// TEST on a 10 element list
		// random order
		printTest("testSortOnTenElementListRandom", testSortOnTenElementListRandom());
		printTest("testSortWithComperatorOnTenElementListRandom", testSortWithComperatorOnTenElementListRandom());
		printTest("testFindSmallestOnTenElementListRandom", testFindSmallestOnTenElementListRandom());
		printTest("testFindSmallestWithComperatorOnTenElementListRandom", testFindSmallestWithComperatorOnTenElementListRandom());
		printTest("testFindLargestOnTenElementListRandom", testFindLargestOnTenElementListRandom());
		printTest("testFindLargestWithComperatorOnTenElementListRandom", testFindLargestWithComperatorOnTenElementListRandom());
		// reverse
		printTest("testSortOnTenElementListReverse", testSortOnTenElementListReverse());
		printTest("testSortWithComperatorOnTenElementListReverse", testSortWithComperatorOnTenElementListReverse());
		printTest("testFindSmallestOnTenElementListReverse", testFindSmallestOnTenElementListReverse());
		printTest("testFindSmallestWithComperatorOnTenElementListReverse", testFindSmallestWithComperatorOnTenElementListReverse());
		printTest("testFindLargestOnTenElementListReverse", testFindLargestOnTenElementListReverse());
		printTest("testFindLargestWithComperatorOnTenElementListReverse", testFindLargestWithComperatorOnTenElementListReverse());

		// TEST ON THOUSAND ELEMENT LIST
		// Random
		printTest("testSortOnThousandElementListRandom", testSortOnThousandElementListRandom());
		printTest("testSortWithComperatorOnThousandElementListRandom", testSortWithComperatorOnThousandElementListRandom());
		printTest("testFindSmallestOnThousandElementListRandom", testFindSmallestOnThousandElementListRandom());
		printTest("testFindSmallestWithComperatorOnThousandElementListRandom", testFindSmallestWithComperatorOnThousandElementListRandom());
		printTest("testFindLargestOnThousandElementListRandom", testFindLargestOnThousandElementListRandom());
		printTest("testFindLargestWithComperatorOnThousandElementListRandom", testFindLargestWithComperatorOnThousandElementListRandom());

		// reverse
		printTest("testSortOnThousandElementListReverse", testSortOnThousandElementListReverse());
		printTest("testSortWithComperatorOnThousandElementListReverse", testSortWithComperatorOnThousandElementListReverse());
		printTest("testFindSmallestOnThousandElementListReverse", testFindSmallestOnThousandElementListReverse());
		printTest("testFindSmallestWithComperatorOnThousandElementListReverse", testFindSmallestWithComperatorOnThousandElementListReverse());
		printTest("testFindLargestOnThousandElementListReverse", testFindLargestOnThousandElementListReverse());
		printTest("testFindLargestWithComperatorOnThousandElementListReverse", testFindLargestWithComperatorOnThousandElementListReverse());

		//TESTS ON THOUSAND CHARACTER LIST
		printTest("testSortOnThousandCharacterListRandom", testSortOnThousandCharacterListRandom());	
		printTest("testSortWithComperatorOnThousandCharacterListRandom", testSortWithComperatorOnThousandCharacterListRandom());
		printTest("testFindSmallestOnThousandCharacterListRandom", testFindSmallestOnThousandCharacterListRandom());
		printTest("testFindSmallestWithComperatorOnThousandCharacterListRandom", testFindSmallestWithComperatorOnThousandCharacterListRandom());
		printTest("testFindLargestOnThousandCharacterListRandom", testFindLargestOnThousandCharacterListRandom());
		printTest("testFindLargestWithComperatorOnThousandCharacterListRandom", testFindLargestWithComperatorOnThousandCharacterListRandom());
		this.printFinalSummary();
	}

	// TODO: TEST ON AN EMPTY LIST
	private boolean testSortOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		DoubleLinkedListADT<Integer> answer = newEmptyList();
		MergeSort.sort(dll);
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testSortWithComperatorOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		DoubleLinkedListADT<Integer> answer = newEmptyList();
		MergeSort.sort(dll);
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testFindSmallestOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		if (MergeSort.findSmallest(dll) == null)
			return true;
		return false;
	}

	private boolean testFindSmallestWithComperatorOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		try {
			if (MergeSort.findSmallest(dll, new InverseComparator<Integer>()) == null)
				return true;
		} catch (Exception e) {
			System.out.printf("Caught Unexpected Exception %s", e.toString());
		}
		return false;
	}

	private boolean testFindLargestOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		if (MergeSort.findLargest(dll) == null)
			return true;
		return false;
	}

	private boolean testFindLargestWithComperatorOnEmptyList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		if (MergeSort.findLargest(dll, new InverseComparator<Integer>()) == null)
			return true;
		return false;
	}

	// TODO: TEST ON A SINGLE-ELEMENT LIST
	private boolean testSortOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));

		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(1));

		MergeSort.sort(dll);
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testSortWithComperatorOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));

		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(1));

		MergeSort.sort(dll);
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testFindSmallestOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		Integer myInt = new Integer(1);
		dll.addToRear(myInt);

		if (MergeSort.findSmallest(dll).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindSmallestWithComperatorOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));

		if (MergeSort.findSmallest(dll, new InverseComparator<Integer>()).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindLargestOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));

		if (MergeSort.findLargest(dll).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindLargestWithComperatorOnOneElementList() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));

		if (MergeSort.findLargest(dll, new InverseComparator<Integer>()).equals(new Integer(1)))
			return true;
		return false;
	}

	// TODO: TEST ON A Two-ELEMENT LIST in Reverse
	private boolean testSortOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));
		dll.addToFront(new Integer(2));
		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(1));
		answer.addToRear(new Integer(2));

		MergeSort.sort(dll);
		System.out.println(dll.toString());
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testSortWithComperatorOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToFront(new Integer(2));
		dll.addToFront(new Integer(1));
		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(2));
		answer.addToRear(new Integer(1));

		MergeSort.sort(dll, new InverseComparator<Integer>());
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	private boolean testFindSmallestOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));
		dll.addToFront(new Integer(2));
		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(1));
		answer.addToRear(new Integer(2));

		if (MergeSort.findSmallest(dll).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindSmallestWithComperatorOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToFront(new Integer(1));
		dll.addToFront(new Integer(2));

		if (MergeSort.findSmallest(dll, new InverseComparator<Integer>()).equals(new Integer(2)))
			return true;
		return false;
	}

	private boolean testFindLargestOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));
		dll.addToFront(new Integer(2));

		if (MergeSort.findLargest(dll).equals(new Integer(2)))
			return true;
		return false;
	}

	private boolean testFindLargestWithComperatorOnTwoElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));
		dll.addToFront(new Integer(2));

		if (MergeSort.findLargest(dll, new InverseComparator<Integer>()).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testSortOnThreeElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll.addToRear(new Integer(1));
		dll.addToFront(new Integer(2));
		dll.addToFront(new Integer(3));

		DoubleLinkedListADT<Integer> answer = newEmptyList();
		answer.addToRear(new Integer(1));
		answer.addToRear(new Integer(2));
		answer.addToRear(new Integer(3));

		MergeSort.sort(dll);
		System.out.println(dll.toString());
		if (dll.toString().compareTo(answer.toString()) == 0)
			return true;
		return false;
	}

	// TODO: TESTS ON TEN ELEMENT LIST RANDOM ORDERED
	private boolean testSortOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		dll = this.fillListRandom(10);
		MergeSort.sort(dll);

		return this.isInForwardOrder(dll);

	}

	private boolean testSortWithComperatorOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		dll = this.fillListRandom(10);
		MergeSort.sort(dll, new InverseComparator<Integer>());

		return this.isInReverseOrder(dll);
	}

	private boolean testFindSmallestOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(10);

		// tests if this is the smallest value
		Integer smallest = MergeSort.findSmallest(dll);
		for (Integer item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

	private boolean testFindSmallestWithComperatorOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(10);

		// tests if this is the smallest value
		Integer largest = MergeSort.findSmallest(dll, new InverseComparator<Integer>());
		for (Integer item : dll) {
			if (largest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(10);

		// tests if this is the smallest value
		Integer largest = MergeSort.findLargest(dll);
		for (Integer item : dll) {
			if (largest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestWithComperatorOnTenElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(10);

		// tests if this is the smallest value
		Integer smallest = MergeSort.findLargest(dll, new InverseComparator<Integer>());
		for (Integer item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

	// TODO: TESTS ON A REVERSE ORDERED TEN ELEMENT LISTs
	private boolean testSortOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		fillListReverse(10, dll);
		MergeSort.sort(dll);
		return isInForwardOrder(dll);
	}

	private boolean testSortWithComperatorOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		fillListReverse(10, dll);
		MergeSort.sort(dll, new InverseComparator<Integer>());
		return isInReverseOrder(dll);
	}

	private boolean testFindSmallestOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		fillListReverse(10, dll);

		if (MergeSort.findSmallest(dll).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindSmallestWithComperatorOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		fillListReverse(10, dll);
		if (MergeSort.findSmallest(dll, new InverseComparator<Integer>()).equals(new Integer(10)))
			return true;
		return false;
	}

	private boolean testFindLargestOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		fillListReverse(10, dll);

		if (MergeSort.findLargest(dll).equals(new Integer(10)))
			return true;
		return false;
	}

	private boolean testFindLargestWithComperatorOnTenElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		fillListReverse(10, dll);

		if (MergeSort.findLargest(dll, new InverseComparator<Integer>()).equals(new Integer(1)))
			return true;
		return false;
	}

	// TODO:TESTS ON THOUSAND ELEMENT LIST RANDOM ORDERED
	private boolean testSortOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		dll = this.fillListRandom(1000);
		MergeSort.sort(dll);

		return this.isInForwardOrder(dll);

	}

	private boolean testSortWithComperatorOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		dll = this.fillListRandom(1000);
		MergeSort.sort(dll, new InverseComparator<Integer>());

		return this.isInReverseOrder(dll);
	}

	private boolean testFindSmallestOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(1000);

		// tests if this is the smallest value
		Integer smallest = MergeSort.findSmallest(dll);
		for (Integer item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

	private boolean testFindSmallestWithComperatorOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(1000);

		// tests if this is the smallest value
		Integer largest = MergeSort.findSmallest(dll, new InverseComparator<Integer>());
		for (Integer item : dll) {
			if (largest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(1000);

		// tests if this is the smallest value
		Integer largest = MergeSort.findLargest(dll);
		for (Integer item : dll) {
			if (largest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestWithComperatorOnThousandElementListRandom() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		dll = fillListRandom(1000);

		// tests if this is the smallest value
		Integer smallest = MergeSort.findLargest(dll, new InverseComparator<Integer>());
		for (Integer item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

	// TODO:TESTS ON THOUSAND ELEMENT LIST REVERSE ORDERED
	private boolean testSortOnThousandElementListReverse() {

		DoubleLinkedListADT<Integer> dll = newEmptyList();
		fillListReverse(1000, dll);
		MergeSort.sort(dll);

		return isInForwardOrder(dll);

	}

	private boolean testSortWithComperatorOnThousandElementListReverse() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		fillListReverse(1000, dll);
		MergeSort.sort(dll, new InverseComparator<Integer>());
		return isInReverseOrder(dll);
	}

	private boolean testFindSmallestOnThousandElementListReverse() {
		DoubleLinkedListADT<Integer> dll = new WrappedDLL<Integer>();

		fillListReverse(1000, dll);

		if (MergeSort.findSmallest(dll).equals(new Integer(1)))
			return true;
		return false;
	}

	private boolean testFindSmallestWithComperatorOnThousandElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		fillListReverse(1000, dll);
		if (MergeSort.findSmallest(dll, new InverseComparator<Integer>()).equals(new Integer(1000)))
			return true;
		return false;
	}

	private boolean testFindLargestOnThousandElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();

		fillListReverse(1000, dll);

		if (MergeSort.findLargest(dll).equals(new Integer(1000)))
			return true;
		return false;
	}

	private boolean testFindLargestWithComperatorOnThousandElementListReverse() {
		DoubleLinkedListADT<Integer> dll = newEmptyList();
		fillListReverse(1000, dll);

		if (MergeSort.findLargest(dll, new InverseComparator<Integer>()).equals(new Integer(1)))
			return true;
		return false;
	}
	//TODO: CHAR TESTING THOUSAND ELEMENTS RANDOM
	private boolean testSortOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();

		this.fillListRandomChar(1000, dll);
		MergeSort.sort(dll);
		return this.isInForwardOrder(dll);

	}
	private boolean testSortWithComperatorOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();

		this.fillListRandomChar(1000, dll);
		MergeSort.sort(dll, new InverseComparator<Character>());

		return this.isInReverseOrder(dll);
	}

	private boolean testFindSmallestOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();

		this.fillListRandomChar(1000, dll);
		Character smallest = MergeSort.findSmallest(dll);
		for (Character item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

	private boolean testFindSmallestWithComperatorOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();

		this.fillListRandomChar(1000, dll);
		Character smallest = MergeSort.findSmallest(dll, new InverseComparator<Character>());
		for (Character item : dll) {
			if (smallest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();
		this.fillListRandomChar(1000, dll);

		// tests if this is the smallest value
		Character largest = MergeSort.findLargest(dll);
		for (Character item : dll) {
			if (largest.compareTo(item) < 0)
				return false;
		}
		return true;
	}

	private boolean testFindLargestWithComperatorOnThousandCharacterListRandom() {
		DoubleLinkedListADT<Character> dll = new WrappedDLL<Character>();
		this.fillListRandomChar(1000, dll);

		// tests if this is the smallest value
		Character smallest = MergeSort.findLargest(dll, new InverseComparator<Character>());
		for (Character item : dll) {
			if (smallest.compareTo(item) > 0)
				return false;
		}
		return true;
	}

}
