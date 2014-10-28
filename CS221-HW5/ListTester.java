import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for UnorderedListADT. This is a set of black box tests that
 * should work for any implementation of UnorderedListADT.
 * 
 * NOTE: One set of example tests is given for the scenario of a creating a new,
 * empty list to get you started.
 * 
 * Method newList() returns one of two (or more) alternate implementations to
 * all tests, so you don't have to do a search and replace on constructor calls
 * in every test.
 * 
 * @author ncmnew: testing framework and empty list scenario
 */
public class ListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/**
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		ListTester tester = new ListTester();
		tester.runTests();
		// tester.runArrayTest();
	}

	/**
	 * Returns an UnorderedListADT so the implementation can be changed in this
	 * one location rather than in every test.
	 * 
	 * @return a new UnorderedListADT
	 */
	private UnorderedListADT<Integer> newUnorderedList() {
		// TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new ArrayList<Integer>();
	}

	private UnorderedListADT<Integer> newListRemoveEmpty() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.remove(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListRemoveFirstEmpty() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.removeFirst();
		return someList;
	}

	private UnorderedListADT<Integer> newListRemoveLastEmpty() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.removeFirst();
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToFrontOne() {
		UnorderedListADT<Integer> someList = newUnorderedList();
		someList.addToFront(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToRearOne() {
		UnorderedListADT<Integer> someList = newUnorderedList();
		someList.addToFront(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListOneElement() {
		UnorderedListADT<Integer> someList = newUnorderedList();
		someList.addToFront(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToFrontTwo() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.addToFront(new Integer(2));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToRearTwoElement() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.addToRear(new Integer(2));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddAfterTwoElement() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.addAfter(new Integer(2), new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListRemoveTwoElement() {
		UnorderedListADT<Integer> someList = newListAddToRearThree();
		someList.remove(new Integer(3));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToFrontThree() {
		UnorderedListADT<Integer> someList = newListAddToRearTwoElement();
		someList.addToFront(new Integer(3));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddAfterFirstElementThree() {
		UnorderedListADT<Integer> someList = newListAddToRearTwoElement();
		someList.addAfter(new Integer(3), new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddAfterSecondElementThree() {
		UnorderedListADT<Integer> someList = newListAddToRearTwoElement();
		someList.addAfter(new Integer(3), new Integer(2));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToRearThree() {
		UnorderedListADT<Integer> someList = newListAddToRearTwoElement();
		someList.addToRear(new Integer(3));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedList() {
		// TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new ArrayList<Integer>();
	}

	private IndexedListADT<Integer> newIndexedListRemoveElementEmpty() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.remove(new Integer(1));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListRemoveFirstEmpty() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		((ArrayList<Integer>) someList).removeFirst();
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListRemoveLastEmpty() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		((ArrayList<Integer>) someList).removeLast();
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListAddOne() {
		IndexedListADT<Integer> someList = newIndexedList();
		someList.add(new Integer(1));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListAddAtOne() {
		IndexedListADT<Integer> someList = newIndexedList();
		someList.add(0, new Integer(1));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListRemoveIndexEmpty() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.remove(0);
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListSetOne() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.set(0, new Integer(2));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListRemoveFirstOne() {
		IndexedListADT<Integer> someList = newIndexedListAddAtSecondTwo();
		someList.remove(0);
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListRemoveSecondOne() {
		IndexedListADT<Integer> someList = newIndexedListAddAtSecondTwo();
		someList.remove(1);
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListAddAtFirstTwo() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.add(0, new Integer(2));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListAddAtSecondTwo() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.add(1, new Integer(2));
		return someList;
	}

	private IndexedListADT<Integer> newIndexedListSetAtFirstTwo() {
		IndexedListADT<Integer> someList = newIndexedListAddOne();
		someList.add(1, new Integer(2));
		return someList;
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

	// TODO
	private void runTests() {
		// TESTS ON A NEW, EMPTY ArrayList
		printTest("testAddToFrontOnNewList", testAddToFrontOnNewList());
		printTest("testAddToRearOnNewList", testAddToRearOnNewList());
		printTest("testAddAfterOnNewList", testAddAfterOnNewList());
		printTest("testRemoveFirstOnNewList", testRemoveFirstOnNewList());
		printTest("testRemoveLastOnNewList", testRemoveLastOnNewList());
		printTest("testRemoveElementOnNewList", testRemoveElementOnNewList());
		printTest("testFirstOnNewList", testFirstOnNewList());
		printTest("testLastOnNewList", testLastOnNewList());
		printTest("testContainsOnNewList", testContainsOnNewList());
		printTest("testIsEmptyOnNewList", testIsEmptyOnNewList());
		printTest("testSizeOnNewList", testSizeOnNewList());
		printTest("testIteratorOnNewList", testIteratorOnNewList());
		printTest("testToStringOnNewList", testToStringOnNewList());
		// TESTS ON AN EMPTY ArrayList THAT HAD REMOVE(integer) CALLED
		printTest("testAddToFrontOnRemoveEmpty", testAddToFrontOnRemoveEmpty());
		printTest("testAddToRearOnRemoveEmpty", testAddToRearOnRemoveEmpty());
		printTest("testAddAfterOnRemoveEmpty", testAddAfterOnRemoveEmpty());
		printTest("testRemoveFirstOnRemoveEmpty", testRemoveFirstOnRemoveEmpty());
		printTest("testRemoveLastOnRemoveEmpty", testRemoveLastOnRemoveEmpty());
		printTest("testRemoveElementOnRemoveEmpty", testRemoveElementOnRemoveEmpty());
		printTest("testFirstOnRemoveEmpty", testFirstOnRemoveEmpty());
		printTest("testLastOnRemoveEmpty", testLastOnRemoveEmpty());
		printTest("testContainsOnRemoveEmpty", testContainsOnRemoveEmpty());
		printTest("testIsEmptyOnRemoveEmpty", testIsEmptyOnRemoveEmpty());
		printTest("testSizeOnRemoveEmpty", testSizeOnRemoveEmpty());
		printTest("testIteratorOnRemoveEmpty", testIteratorOnRemoveEmpty());
		printTest("testToStringOnRemoveEmpty", testToStringOnRemoveEmpty());
		// TESTS ON AN EMPTY LIST FROM REMOVELAST()
		printTest("testAddToFrontOnRemoveLastEmpty", testAddToFrontOnRemoveLastEmpty());
		printTest("testAddToRearOnRemoveLastEmpty", testAddToRearOnRemoveLastEmpty());
		printTest("testAddAfterOnRemoveLastEmpty", testAddAfterOnRemoveLastEmpty());
		printTest("testRemoveFirstOnRemoveLastEmpty", testRemoveFirstOnRemoveLastEmpty());
		printTest("testRemoveLastOnRemoveLastEmpty", testRemoveLastOnRemoveLastEmpty());
		printTest("testRemoveElementOnRemoveLastEmpty", testRemoveElementOnRemoveLastEmpty());
		printTest("testFirstOnRemoveLastEmpty", testFirstOnRemoveLastEmpty());
		printTest("testLastOnRemoveLastEmpty", testLastOnRemoveLastEmpty());
		printTest("testContainsOnRemoveLastEmpty", testContainsOnRemoveLastEmpty());
		printTest("testIsEmptyOnRemoveLastEmpty", testIsEmptyOnRemoveLastEmpty());
		printTest("testSizeOnRemoveLastEmpty", testSizeOnRemoveLastEmpty());
		printTest("testIteratorOnRemoveLastEmpty", testIteratorOnRemoveLastEmpty());
		printTest("testToStringOnRemoveLastEmpty", testToStringOnRemoveLastEmpty());
		// TESTS ON AN EMPTY LIST THAT HAD REMOVEFIRST() CALLED
		printTest("testAddToFrontOnRemoveFirstEmpty", testAddToFrontOnRemoveFirstEmpty());
		printTest("testAddToRearOnRemoveFirstEmpty", testAddToRearOnRemoveFirstEmpty());
		printTest("testAddAfterOnRemoveFirstEmpty", testAddAfterOnRemoveFirstEmpty());
		printTest("testRemoveFirstOnRemoveFirstEmpty", testRemoveFirstOnRemoveFirstEmpty());
		printTest("testRemoveLastOnRemoveFirstEmpty", testRemoveLastOnRemoveFirstEmpty());
		printTest("testRemoveElementOnRemoveFirstEmpty", testRemoveElementOnRemoveFirstEmpty());
		printTest("testFirstOnRemoveFirstEmpty", testFirstOnRemoveFirstEmpty());
		printTest("testLastOnRemoveFirstEmpty", testLastOnRemoveFirstEmpty());
		printTest("testContainsOnRemoveFirstEmpty", testContainsOnRemoveFirstEmpty());
		printTest("testIsEmptyOnRemoveFirstEmpty", testIsEmptyOnRemoveFirstEmpty());
		printTest("testSizeOnRemoveFirstEmpty", testSizeOnRemoveFirstEmpty());
		printTest("testIteratorOnRemoveFirstEmpty", testIteratorOnRemoveFirstEmpty());
		printTest("testToStringOnRemoveFirstEmpty", testToStringOnRemoveFirstEmpty());
		// TESTS ON A LIST WITH ONE VALUE, AFTER ADDTOFRONT()
		printTest("testAddToFrontOnAddToFrontOne", testAddToFrontOnAddToFrontOne());
		printTest("testAddToRearOnAddToFrontOne", testAddToRearOnAddToFrontOne());
		printTest("testAddAfterOnAddToFrontOneValid", testAddAfterOnAddToFrontOneValid());
		printTest("testAddAfterOnAddToFrontOneInvalid", testAddAfterOnAddToFrontOneInvalid());
		printTest("testRemoveFirstOnAddToFrontOne", testRemoveFirstOnAddToFrontOne());
		printTest("testRemoveLastOnAddToFrontOne", testRemoveLastOnAddToFrontOne());
		printTest("testRemoveElementOnAddToFrontOneValid", testRemoveElementOnAddToFrontOneValid());
		printTest("testRemoveElementOnAddToFrontOneInvalid", testRemoveElementOnAddToFrontOneInvalid());
		printTest("testFirstOnAddToFrontOne", testFirstOnAddToFrontOne());
		printTest("testLastOnAddToFrontOne", testLastOnAddToFrontOne());
		printTest("testContainsOnAddToFrontOneValid", testContainsOnAddToFrontOneValid());
		printTest("testContainsOnAddToFrontOneInvalid", testContainsOnAddToFrontOneInvalid());
		printTest("testIsEmptyOnAddToFrontOne", testIsEmptyOnAddToFrontOne());
		printTest("testSizeOnAddToFrontOne", testSizeOnAddToFrontOne());
		printTest("testIteratorOnAddToFrontOne", testIteratorOnAddToFrontOne());
		printTest("testToStringOnAddToFrontOne", testToStringOnAddToFrontOne());
		// TESTS ON A LIST WITH ONE VALUE, AFTER ADDTOREAR()
		printTest("testAddToFrontOnAddToRearOne", testAddToFrontOnAddToRearOne());
		printTest("testAddToRearOnAddToRearOne", testAddToRearOnAddToRearOne());
		printTest("testAddAfterOnAddToRearOneValid", testAddAfterOnAddToRearOneValid());
		printTest("testAddAfterOnAddToRearOneInvalid", testAddAfterOnAddToRearOneInvalid());
		printTest("testRemoveFirstOnAddToRearOne", testRemoveFirstOnAddToRearOne());
		printTest("testRemoveLastOnAddToRearOne", testRemoveLastOnAddToRearOne());
		printTest("testRemoveElementOnAddToRearOneValid", testRemoveElementOnAddToRearOneValid());
		printTest("testRemoveElementOnAddToRearOneInvalid", testRemoveElementOnAddToRearOneInvalid());
		printTest("testFirstOnAddToRearOne", testFirstOnAddToRearOne());
		printTest("testLastOnAddToRearOne", testLastOnAddToRearOne());
		printTest("testContainsOnAddToRearOneValid", testContainsOnAddToRearOneValid());
		printTest("testContainsOnAddToRearOneInvalid", testContainsOnAddToRearOneInvalid());
		printTest("testIsEmptyOnAddToRearOne", testIsEmptyOnAddToRearOne());
		printTest("testSizeOnAddToRearOne", testSizeOnAddToRearOne());
		printTest("testIteratorOnAddToRearOne", testIteratorOnAddToRearOne());
		printTest("testToStringOnAddToRearOne", testToStringOnAddToRearOne());
		// TESTS ON A ONE-ELEMENT LIST THAT HAD REMOVE(INTEGER(2)) CALLED TODO
		// TEST ON A LIST WITH TWO VALUES, AFTER ADDTOFRONT()
		printTest("testAddToFrontOnAddToFrontTwo", testAddToFrontOnAddToFrontTwo());
		printTest("testAddToRearOnAddToFrontTwo", testAddToRearOnAddToFrontTwo());
		printTest("testAddAfterOnAddToFrontTwoValid", testAddAfterOnAddToFrontTwoValid());
		printTest("testAddAfterOnAddToFrontTwoInvalid", testAddAfterOnAddToFrontTwoInvalid());
		printTest("testRemoveFirstOnAddToFrontTwo", testRemoveFirstOnAddToFrontTwo());
		printTest("testRemoveLastOnAddToFrontTwo", testRemoveLastOnAddToFrontTwo());
		printTest("testRemoveFirstElementOnAddToFrontTwoValid", testRemoveFirstElementOnAddToFrontTwoValid());
		printTest("testRemoveSecondElementOnAddToFrontTwoValid", testRemoveSecondElementOnAddToFrontTwoValid());
		printTest("testRemoveElementOnAddToFrontTwoInvalid", testRemoveElementOnAddToFrontTwoInvalid());
		printTest("testFirstOnAddToFrontTwo", testFirstOnAddToFrontTwo());
		printTest("testLastOnAddToFrontTwo", testLastOnAddToFrontTwo());
		printTest("testContainsOnAddToFrontTwoValid", testContainsOnAddToFrontTwoValid());
		printTest("testContainsOnAddToFrontTwoInvalid", testContainsOnAddToFrontTwoInvalid());
		printTest("testIsEmptyOnAddToFrontTwo", testIsEmptyOnAddToFrontTwo());
		printTest("testSizeOnAddToFrontTwo", testSizeOnAddToFrontTwo());
		printTest("testIteratorOnAddToFrontTwo", testIteratorOnAddToFrontTwo());
		printTest("testToStringOnAddToFrontTwo", testToStringOnAddToFrontTwo());
		// TESTS ON A LIST WITH TWO VALUES, ADDTOREAR()
		printTest("testAddToFrontOnAddToRearTwo", testAddToFrontOnAddToRearTwo());
		printTest("testAddToRearOnAddToRearTwo", testAddToRearOnAddToRearTwo());
		printTest("testAddAfterOnAddToRearTwoValid", testAddAfterOnAddToRearTwoValid());
		printTest("testAddAfterOnAddToRearTwoInvalid", testAddAfterOnAddToRearTwoInvalid());
		printTest("testRemoveFirstOnAddToRearTwo", testRemoveFirstOnAddToRearTwo());
		printTest("testRemoveLastOnAddToRearTwo", testRemoveLastOnAddToRearTwo());
		printTest("testRemoveFirstElementOnAddToRearTwoValid", testRemoveFirstElementOnAddToRearTwoValid());
		printTest("testRemoveSecondElementOnAddToRearTwoValid", testRemoveSecondElementOnAddToRearTwoValid());
		printTest("testRemoveElementOnAddToRearTwoInvalid", testRemoveElementOnAddToRearTwoInvalid());
		printTest("testFirstOnAddToRearTwo", testFirstOnAddToRearTwo());
		printTest("testLastOnAddToRearTwo", testLastOnAddToRearTwo());
		printTest("testContainsFirstElementOnAddToRearTwoValid", testContainsFirstElementOnAddToRearTwoValid());
		printTest("testContainsSecondElementOnAddToRearTwoValid", testContainsSecondElementOnAddToRearTwoValid());
		printTest("testContainsOnAddToRearTwoInvalid", testContainsOnAddToRearTwoInvalid());
		printTest("testIsEmptyOnAddToRearTwo", testIsEmptyOnAddToRearTwo());
		printTest("testSizeOnAddToRearTwo", testSizeOnAddToRearTwo());
		printTest("testIteratorOnAddToRearTwo", testIteratorOnAddToRearTwo());
		printTest("testToStringOnAddToRearTwo", testToStringOnAddToRearTwo());
		// TESTS ON A LIST WITH TWO VALUES, ADDAFTER()
		printTest("testAddToFrontOnAddAfterTwo", testAddToFrontOnAddAfterTwo());
		printTest("testAddToRearOnAddAfterTwo", testAddToRearOnAddAfterTwo());
		printTest("testAddAfterOnAddAfterTwoValid", testAddAfterOnAddAfterTwoValid());
		printTest("testAddAfterOnAddAfterTwoInvalid", testAddAfterOnAddAfterTwoInvalid());
		printTest("testRemoveFirstOnAddAfterTwo", testRemoveFirstOnAddAfterTwo());
		printTest("testRemoveLastOnAddAfterTwo", testRemoveLastOnAddAfterTwo());
		printTest("testRemoveFirstElementOnAddAfterTwoValid", testRemoveFirstElementOnAddAfterTwoValid());
		printTest("testRemoveSecondElementOnAddAfterTwoValid", testRemoveSecondElementOnAddAfterTwoValid());
		printTest("testRemoveElementOnAddAfterTwoInvalid", testRemoveElementOnAddAfterTwoInvalid());
		printTest("testFirstOnAddAfterTwo", testFirstOnAddAfterTwo());
		printTest("testLastOnAddAfterTwo", testLastOnAddAfterTwo());
		printTest("testContainsFirstElementOnAddAfterTwoValid", testContainsFirstElementOnAddAfterTwoValid());
		printTest("testContainsSecondElementOnAddAfterTwoValid", testContainsSecondElementOnAddAfterTwoValid());
		printTest("testContainsOnAddAfterTwoInvalid", testContainsOnAddAfterTwoInvalid());
		printTest("testIsEmptyOnAddAfterTwo", testIsEmptyOnAddAfterTwo());
		printTest("testSizeOnAddAfterTwo", testSizeOnAddAfterTwo());
		printTest("testIteratorOnAddAfterTwo", testIteratorOnAddAfterTwo());
		printTest("testToStringOnAddAfterTwo", testToStringOnAddAfterTwo());
		// TESTS ON A TWO-ELEMENT LIST THAT HAD REMOVE() CALLED TODO
		printTest("testAddToFrontOnRemoveTwo", testAddToFrontOnRemoveTwo());
		printTest("testAddToRearOnRemoveTwo", testAddToRearOnRemoveTwo());
		printTest("testAddAfterOnRemoveTwoValid", testAddAfterOnRemoveTwoValid());
		printTest("testAddAfterOnRemoveTwoInvalid", testAddAfterOnRemoveTwoInvalid());
		printTest("testRemoveFirstOnRemoveTwo", testRemoveFirstOnRemoveTwo());
		printTest("testRemoveLastOnRemoveTwo", testRemoveLastOnRemoveTwo());
		printTest("testRemoveFirstElementOnRemoveTwoValid", testRemoveFirstElementOnRemoveTwoValid());
		printTest("testRemoveSecondElementOnRemoveTwoValid", testRemoveSecondElementOnRemoveTwoValid());
		printTest("testRemoveElementOnRemoveTwoInvalid", testRemoveElementOnRemoveTwoInvalid());
		printTest("testFirstOnRemoveTwo", testFirstOnRemoveTwo());
		printTest("testLastOnRemoveTwo", testLastOnRemoveTwo());
		printTest("testContainsFirstElementOnRemoveTwoValid", testContainsFirstElementOnRemoveTwoValid());
		printTest("testContainsSecondElementOnRemoveTwoValid", testContainsSecondElementOnRemoveTwoValid());
		printTest("testContainsOnRemoveTwoInvalid", testContainsOnRemoveTwoInvalid());
		printTest("testIsEmptyOnRemoveTwo", testIsEmptyOnRemoveTwo());
		printTest("testSizeOnRemoveTwo", testSizeOnRemoveTwo());
		printTest("testIteratorOnRemoveTwo", testIteratorOnRemoveTwo());
		printTest("testToStringOnRemoveTwo", testToStringOnRemoveTwo());
		// TESTS ON A LIST WITH THREE VALUES, ADDTOFRONT()
		printTest("testAddToFrontOnAddToFrontThree", testAddToFrontOnAddToFrontThree());
		printTest("testAddToRearOnAddToFrontThree", testAddToRearOnAddToFrontThree());
		printTest("testAddAfterFirstElementOnAddToFrontThreeValid", testAddAfterFirstElementOnAddToFrontThreeValid());
		printTest("testAddAfterSecondElementOnAddToFrontThreeValid", testAddAfterSecondElementOnAddToFrontThreeValid());
		printTest("testAddAfterThirdElementOnAddToFrontThreeValid", testAddAfterThirdElementOnAddToFrontThreeValid());
		printTest("testAddAfterOnAddToFrontThreeInvalid", testAddAfterOnAddToFrontThreeInvalid());
		printTest("testRemoveFirstOnAddToFrontThree", testRemoveFirstOnAddToFrontThree());
		printTest("testRemoveLastOnAddToFrontThree", testRemoveLastOnAddToFrontThree());
		printTest("testRemoveFirstElementOnAddToFrontThreeValid", testRemoveFirstElementOnAddToFrontThreeValid());
		printTest("testRemoveSecondElementOnAddToFrontThreeValid", testRemoveSecondElementOnAddToFrontThreeValid());
		printTest("testRemoveSecondElementOnAddToFrontThreeValid", testRemoveThirdElementOnAddToFrontThreeValid());
		printTest("testRemoveElementOnAddToFrontThreeInvalid", testRemoveElementOnAddToFrontThreeInvalid());
		printTest("testFirstOnAddToFrontThree", testFirstOnAddToFrontThree());
		printTest("testLastOnAddToFrontThree", testLastOnAddToFrontThree());
		printTest("testContainsFirstElementOnAddToFrontThreeValid", testContainsFirstElementOnAddToFrontThreeValid());
		printTest("testContainsSecondElementOnAddToFrontThreeValid", testContainsSecondElementOnAddToFrontThreeValid());
		printTest("testContainsThirdElementOnAddToFrontThreeValid", testContainsThirdElementOnAddToFrontThreeValid());
		printTest("testContainsOnAddToFrontThreeInvalid", testContainsOnAddToFrontThreeInvalid());
		printTest("testIsEmptyOnAddToFrontThree", testIsEmptyOnAddToFrontThree());
		printTest("testSizeOnAddToFrontThree", testSizeOnAddToFrontThree());
		printTest("testIteratorOnAddToFrontThree", testIteratorOnAddToFrontThree());
		printTest("testToStringOnAddToFrontThree", testToStringOnAddToFrontThree());
		// TESTS ON A LIST WITH THREE VALUES, ADDAFTER() FIRST ELEMENT
		printTest("testAddToFrontOnAddAfterFirstElementThree", testAddToFrontOnAddAfterFirstElementThree());
		printTest("testAddToRearOnAddAfterFirstElementThree", testAddToRearOnAddAfterFirstElementThree());
		printTest("testAddAfterFirstElementOnAddAfterFirstElementThreeValid", testAddAfterFirstElementOnAddAfterFirstElementThreeValid());
		printTest("testAddAfterSecondElementOnAddAfterFirstElementThreeValid", testAddAfterSecondElementOnAddAfterFirstElementThreeValid());
		printTest("testAddAfterThirdElementOnAddAfterFirstElementThreeValid", testAddAfterThirdElementOnAddAfterFirstElementThreeValid());
		printTest("testAddAfterOnAddAfterFirstElementThreeInvalid", testAddAfterOnAddAfterFirstElementThreeInvalid());
		printTest("testRemoveFirstOnAddAfterFirstElementThree", testRemoveFirstOnAddAfterFirstElementThree());
		printTest("testRemoveLastOnAddAfterFirstElementThree", testRemoveLastOnAddAfterFirstElementThree());
		printTest("testRemoveFirstElementOnAddAfterFirstElementThreeValid", testRemoveFirstElementOnAddAfterFirstElementThreeValid());
		printTest("testRemoveSecondElementOnAddAfterFirstElementThreeValid", testRemoveSecondElementOnAddAfterFirstElementThreeValid());
		printTest("testRemoveThirdElementOnAddAfterFirstElementThreeValid", testRemoveThirdElementOnAddAfterFirstElementThreeValid());
		printTest("testRemoveElementOnAddAfterFirstElementThreeInvalid", testRemoveElementOnAddAfterFirstElementThreeInvalid());
		printTest("testFirstOnAddAfterFirstElementThree", testFirstOnAddAfterFirstElementThree());
		printTest("testLastOnAddAfterFirstElementThree", testLastOnAddAfterFirstElementThree());
		printTest("testContainsFirstElementOnAddAfterFirstElementThreeValid", testContainsFirstElementOnAddAfterFirstElementThreeValid());
		printTest("testContainsSecondElementOnAddAfterFirstElementThreeValid", testContainsSecondElementOnAddAfterFirstElementThreeValid());
		printTest("testContainsThirdElementOnAddAfterFirstElementThreeValid", testContainsThirdElementOnAddAfterFirstElementThreeValid());
		printTest("testContainsOnAddAfterFirstElementThreeInvalid", testContainsOnAddAfterFirstElementThreeInvalid());
		printTest("testIsEmptyOnAddAfterFirstElementThree", testIsEmptyOnAddAfterFirstElementThree());
		printTest("testSizeOnAddAfterFirstElementThree", testSizeOnAddAfterFirstElementThree());
		printTest("testIteratorOnAddAfterFirstElementThree", testIteratorOnAddAfterFirstElementThree());
		printTest("testToStringOnAddAfterFirstElementThree", testToStringOnAddAfterFirstElementThree());
		// TESTS ON A LIST WITH THREE VALUES, ADDAFTER() SECOND ELEMENT
		printTest("testAddToFrontOnAddAfterSecondElementThree", testAddToFrontOnAddAfterSecondElementThree());
		printTest("testAddToRearOnAddAfterSecondElementThree", testAddToRearOnAddAfterSecondElementThree());
		printTest("testAddAfterFirstElementOnAddAfterSecondElementThreeValid", testAddAfterFirstElementOnAddAfterSecondElementThreeValid());
		printTest("testAddAfterSecondElementOnAddAfterSecondElementThreeValid", testAddAfterSecondElementOnAddAfterSecondElementThreeValid());
		printTest("testAddAfterThirdElementOnAddAfterSecondElementThreeValid", testAddAfterThirdElementOnAddAfterSecondElementThreeValid());
		printTest("testAddAfterOnAddAfterSecondElementThreeInvalid", testAddAfterOnAddAfterSecondElementThreeInvalid());
		printTest("testRemoveFirstOnAddAfterSecondElementThree", testRemoveFirstOnAddAfterSecondElementThree());
		printTest("testRemoveLastOnAddAfterSecondElementThree", testRemoveLastOnAddAfterSecondElementThree());
		printTest("testRemoveFirstElementOnAddAfterSecondElementThreeValid", testRemoveFirstElementOnAddAfterSecondElementThreeValid());
		printTest("testRemoveSecondElementOnAddAfterSecondElementThreeValid", testRemoveSecondElementOnAddAfterSecondElementThreeValid());
		printTest("testRemoveThirdElementOnAddAfterSecondElementThreeValid", testRemoveThirdElementOnAddAfterSecondElementThreeValid());
		printTest("testRemoveElementOnAddAfterSecondElementThreeInvalid", testRemoveElementOnAddAfterSecondElementThreeInvalid());
		printTest("testFirstOnAddAfterSecondElementThree", testFirstOnAddAfterSecondElementThree());
		printTest("testLastOnAddAfterSecondElementThree", testLastOnAddAfterSecondElementThree());
		printTest("testContainsFirstElementOnAddAfterSecondElementThreeValid", testContainsFirstElementOnAddAfterSecondElementThreeValid());
		printTest("testContainsSecondElementOnAddAfterSecondElementThreeValid", testContainsSecondElementOnAddAfterSecondElementThreeValid());
		printTest("testContainsThirdElementOnAddAfterSecondElementThreeValid", testContainsThirdElementOnAddAfterSecondElementThreeValid());
		printTest("testContainsOnAddAfterSecondElementThreeInvalid", testContainsOnAddAfterSecondElementThreeInvalid());
		printTest("testIsEmptyOnAddAfterSecondElementThree", testIsEmptyOnAddAfterSecondElementThree());
		printTest("testSizeOnAddAfterSecondElementThree", testSizeOnAddAfterSecondElementThree());
		printTest("testIteratorOnAddAfterSecondElementThree", testIteratorOnAddAfterSecondElementThree());
		printTest("testToStringOnAddAfterSecondElementThree", testToStringOnAddAfterSecondElementThree());
		// TESTS ON A LIST WITH THREE VALUES, ADDTOREAR()
		printTest("testAddToFrontOnAddToRearThree", testAddToFrontOnAddToRearThree());
		printTest("testAddToRearOnAddToRearThree", testAddToRearOnAddToRearThree());
		printTest("testAddAfterFirstElementOnAddToRearThreeValid", testAddAfterFirstElementOnAddToRearThreeValid());
		printTest("testAddAfterSecondElementOnAddToRearThreeValid", testAddAfterSecondElementOnAddToRearThreeValid());
		printTest("testAddAfterThirdElementOnAddToRearThreeValid", testAddAfterThirdElementOnAddToRearThreeValid());
		printTest("testAddAfterOnAddToRearThreeInvalid", testAddAfterOnAddToRearThreeInvalid());
		printTest("testRemoveFirstOnAddToRearThree", testRemoveFirstOnAddToRearThree());
		printTest("testRemoveLastOnAddToRearThree", testRemoveLastOnAddToRearThree());
		printTest("testRemoveFirstElementOnAddToRearThreeValid", testRemoveFirstElementOnAddToRearThreeValid());
		printTest("testRemoveSecondElementOnAddToRearThreeValid", testRemoveSecondElementOnAddToRearThreeValid());
		printTest("testRemoveThirdElementOnAddToRearThreeValid", testRemoveThirdElementOnAddToRearThreeValid());
		printTest("testRemoveElementOnAddToRearThreeInvalid", testRemoveElementOnAddToRearThreeInvalid());
		printTest("testFirstOnAddToRearThree", testFirstOnAddToRearThree());
		printTest("testLastOnAddToRearThree", testLastOnAddToRearThree());
		printTest("testContainsFirstElementOnAddToRearThreeValid", testContainsFirstElementOnAddToRearThreeValid());
		printTest("testContainsSecondElementOnAddToRearThreeValid", testContainsSecondElementOnAddToRearThreeValid());
		printTest("testContainsThirdElementOnAddToRearThreeValid", testContainsThirdElementOnAddToRearThreeValid());
		printTest("testContainsOnAddToRearThreeInvalid", testContainsOnAddToRearThreeInvalid());
		printTest("testIsEmptyOnAddToRearThree", testIsEmptyOnAddToRearThree());
		printTest("testSizeOnAddToRearThree", testSizeOnAddToRearThree());
		printTest("testIteratorOnAddToRearThree", testIteratorOnAddToRearThree());
		printTest("testToStringOnAddToRearThree", testToStringOnAddToRearThree());
		runIndexedTests();
		// ///////////////
		// final verdict
		// ///////////////
		printFinalSummary();
	}

	/**
	 * Run tests to confirm required functionality from list constructors and
	 * methods TODO
	 */
	private void runIndexedTests() {
		// /
		// /Addendum to old Scenarios
		// /
		// TESTS ON A NEW, EMPTY ArrayList
		printTest("testAddAtIndexOnNewIndexedListValid", testAddAtIndexOnNewIndexedListValid());
		printTest("testAddAtIndexOnNewIndexedListInvalid", testAddAtIndexOnNewIndexedListInvalid());
		printTest("testAddV2OnNewIndexedList", testAddV2OnNewIndexedList());// add(T)
		printTest("testSetOnNewIndexedListInvalid", testSetOnNewIndexedListInvalid());
		printTest("testGetOnNewIndexedListValid", testGetOnNewIndexedListValid());
		printTest("testIndexOfOnNewIndexedList", testIndexOfOnNewIndexedList());
		printTest("testRemoveIndexOnNewIndexedList", testRemoveIndexOnNewIndexedList());
		// TESTS ON AN EMPTY INDEXEDLIST THAT HAD REMOVE(integer) CALLED
		printTest("testAddAtIndexOnRemoveElementIndexedListValid", testAddAtIndexOnRemoveElementIndexedListValid());
		printTest("testAddAtIndexOnRemoveElementIndexedListInvalid", testAddAtIndexOnRemoveElementIndexedListInvalid());
		printTest("testAddV2OnRemoveElementIndexedList", testAddV2OnRemoveElementIndexedList());
		printTest("testSetOnRemoveElementIndexedListInvalid", testSetOnRemoveElementIndexedListInvalid());
		printTest("testGetOnRemoveElementIndexedListValid", testGetOnRemoveElementIndexedListValid());
		printTest("testIndexOfOnRemoveElementIndexedList", testIndexOfOnRemoveElementIndexedList());
		printTest("testRemoveIndexOnRemoveElementList", testRemoveIndexOnRemoveElementIndexedList());
		// TESTS ON AN EMPTY LIST FROM REMOVELAST()
		printTest("testAddAtIndexOnRemoveLastIndexedListValid", testAddAtIndexOnRemoveLastIndexedListValid());
		printTest("testAddAtIndexOnRemoveLastIndexedListInvalid", testAddAtIndexOnRemoveLastIndexedListInvalid());
		printTest("testAddV2OnRemoveLastIndexedList", testAddV2OnRemoveLastIndexedList());
		printTest("testSetOnRemoveLastIndexedListInvalid", testSetOnRemoveLastIndexedListInvalid());
		printTest("testGetOnRemoveLastListValid", testGetOnRemoveLastIndexedListValid());
		printTest("testGetOnRemoveLastIndexedListInvalid", testGetOnRemoveLastIndexedListInvalid());
		printTest("testIndexOfOnRemoveLastIndexedList", testIndexOfOnRemoveLastIndexedList());
		printTest("testRemoveIndexOnRemoveLastList", testRemoveIndexOnRemoveLastIndexedList());
		// TESTS ON AN EMPTY LIST THAT HAD REMOVEFIRST() CALLED
		printTest("testAddAtIndexOnRemoveFirstIndexedListValid", testAddAtIndexOnRemoveFirstIndexedListValid());
		printTest("testAddAtIndexOnRemoveFirstIndexedListInvalid", testAddAtIndexOnRemoveFirstIndexedListInvalid());
		printTest("testAddV2OnRemoveFirstIndexedList", testAddV2OnRemoveFirstIndexedList());
		printTest("testSetOnRemoveFirstIndexedListInvalid", testSetOnRemoveFirstIndexedListInvalid());
		printTest("testGetOnRemoveFirstIndexedListValid", testGetOnRemoveFirstIndexedListValid());
		printTest("testIndexOfOnRemoveFirstIndexedList", testIndexOfOnRemoveFirstIndexedList());
		printTest("testRemoveIndexOnRemoveFirstIndexedList", testRemoveIndexOnRemoveFirstIndexedList());
		// TESTS ON A LIST WITH ONE VALUE, AFTER ADDTOFRONT()
		printTest("testAddAtIndexOnAddToFrontIndexedListOneValid", testAddAtIndexOnAddToFrontIndexedListOneValid());
		printTest("testAddAtIndexOnAddToFrontIndexedListOneInvalid", testAddAtIndexOnAddToFrontIndexedListOneInvalid());
		printTest("testAddV2OnAddToFrontIndexedListOne", testAddV2OnAddToFrontIndexedListOne());
		printTest("testSetOnAddToFrontIndexedListOneValid", testSetOnAddToFrontIndexedListOneValid());
		printTest("testSetOnAddToFrontIndexedListOneInvalid", testSetOnAddToFrontIndexedListOneInvalid());
		printTest("testGetOnAddToFrontIndexedListOneValid", testGetOnAddToFrontIndexedListOneValid());
		printTest("testGetOnAddToFrontIndexedListOneInvalid", testGetOnAddToFrontIndexedListOneInvalid());
		printTest("testIndexOfOnAddToFrontIndexedListOneValid", testIndexOfOnAddToFrontIndexedListOneValid());
		printTest("testIndexOfOnAddToFrontIndexedListOneInvalid", testIndexOfOnAddToFrontIndexedListOneInvalid());
		printTest("testRemoveIndexOnAddToFrontIndexedListOne", testRemoveIndexOnAddToFrontIndexedListOne());
		// TESTS ON A LIST WITH ONE VALUE, AFTER ADDTOREAR()
		printTest("testAddAtIndexOnAddToRearIndexedListOneValid", testAddAtIndexOnAddToRearIndexedListOneValid());
		printTest("testAddAtIndexOnAddToRearIndexedListOneInvalid", testAddAtIndexOnAddToRearIndexedListOneInvalid());
		printTest("testAddV2OnAddToRearIndexedListOne", testAddV2OnAddToRearIndexedListOne());
		printTest("testSetOnAddToRearIndexedListOneValid", testSetOnAddToRearIndexedListOneValid());
		printTest("testSetOnAddToRearIndexedListOneInvalid", testSetOnAddToRearIndexedListOneInvalid());
		printTest("testGetOnAddToRearIndexedListOneValid", testGetOnAddToRearIndexedListOneValid());
		printTest("testGetOnAddToRearIndexedListOneInvalid", testGetOnAddToRearIndexedListOneInvalid());
		printTest("testIndexOfOnAddToRearIndexedListOneValid", testIndexOfOnAddToRearIndexedListOneValid());
		printTest("testIndexOfOnAddToRearIndexedListOneInvalid", testIndexOfOnAddToRearIndexedListOneInvalid());
		printTest("testRemoveIndexOnAddToRearIndexedListOne", testRemoveIndexOnAddToRearIndexedListOne());
		// TESTS ON A LIST WITH ONE VALUE, AFTER Remove() TODO
		// TESTS ON A LIST WITH ONE VALUE, AFTER Remove() TODO
		// TESTS ON A LIST WITH ONE VALUE, AFTER removeLast() TODO
		// TESTS ON A LIST WITH ONE VALUE, AFTER removeFirst() TODO
		// TEST ON A LIST WITH TWO VALUES, AFTER ADDTOFRONT()
		printTest("testAddAtIndexOnAddToFrontIndexedListTwoValid", testAddAtIndexOnAddToFrontIndexedListTwoValid());
		printTest("testAddAtIndexOnAddToFrontIndexedListTwoInvalid", testAddAtIndexOnAddToFrontIndexedListTwoInvalid());
		printTest("testAddV2OnAddToFrontIndexedListTwo", testAddV2OnAddToFrontIndexedListTwo());
		printTest("testSetOnAddToFrontIndexedListTwoValid", testSetOnAddToFrontIndexedListTwoValid());
		printTest("testSetOnAddToFrontIndexedListTwoInvalid", testSetOnAddToFrontIndexedListTwoInvalid());
		printTest("testGetOnAddToFrontIndexedListTwoValid", testGetOnAddToFrontIndexedListTwoValid());
		printTest("testGetOnAddToFrontIndexedListTwoInvalid", testGetOnAddToFrontIndexedListTwoInvalid());
		printTest("testIndexOfOnAddToFrontIndexedListTwoValid", testIndexOfOnAddToFrontIndexedListTwoValid());
		printTest("testIndexOfOnAddToFrontIndexedListTwoInvalid", testIndexOfOnAddToFrontIndexedListTwoInvalid());
		printTest("testRemoveIndexOnAddToFrontIndexedListTwoValid", testRemoveIndexOnAddToFrontIndexedListTwoValid());
		printTest("testRemoveIndexOnAddToFrontIndexedListTwoInvalid", testRemoveIndexOnAddToFrontIndexedListTwoInvalid());
		// TEST ON A LIST WITH TWO VALUES, AFTER ADDTOREAR()
		printTest("testAddAtIndexOnAddToRearIndexedListTwoValid", testAddAtIndexOnAddToRearIndexedListTwoValid());
		printTest("testAddAtIndexOnAddToRearIndexedListTwoInvalid", testAddAtIndexOnAddToRearIndexedListTwoInvalid());
		printTest("testAddV2OnAddToRearIndexedListTwo", testAddV2OnAddToRearIndexedListTwo());
		printTest("testSetOnAddToRearIndexedListTwoValid", testSetOnAddToRearIndexedListTwoValid());
		printTest("testSetOnAddToRearIndexedListTwoInvalid", testSetOnAddToRearIndexedListTwoInvalid());
		printTest("testGetOnAddToRearIndexedListTwoValid", testGetOnAddToRearIndexedListTwoValid());
		printTest("testGetOnAddToRearIndexedListTwoInvalid", testGetOnAddToRearIndexedListTwoInvalid());
		printTest("testIndexOfOnAddToRearIndexedListTwoValid", testIndexOfOnAddToRearIndexedListTwoValid());
		printTest("testIndexOfOnAddToRearIndexedListTwoInvalid", testIndexOfOnAddToRearIndexedListTwoInvalid());
		printTest("testRemoveIndexOnAddToRearIndexedListTwoValid", testRemoveIndexOnAddToRearIndexedListTwoValid());
		printTest("testRemoveIndexOnAddToRearIndexedListTwoInvalid", testRemoveIndexOnAddToRearIndexedListTwoInvalid());
		// TESTS ON A LIST WITH TWO VALUE, AFTER AddAfter(new Integer(1))
		printTest("testAddAtIndexOnAddAfterIndexedListTwoValid", testAddAtIndexOnAddAfterIndexedListTwoValid());
		printTest("testAddAtIndexOnAddAfterIndexedListTwoInvalid", testAddAtIndexOnAddAfterIndexedListTwoInvalid());
		printTest("testAddV2OnAddAfterIndexedListTwo", testAddV2OnAddAfterIndexedListTwo());
		printTest("testSetOnAddAfterIndexedListTwoValid", testSetOnAddAfterIndexedListTwoValid());
		printTest("testSetOnAddAfterIndexedListTwoInvalid", testSetOnAddAfterIndexedListTwoInvalid());
		printTest("testGetOnAddAfterIndexedListTwoValid", testGetOnAddAfterIndexedListTwoValid());
		printTest("testGetOnAddAfterIndexedListTwoInvalid", testGetOnAddAfterIndexedListTwoInvalid());
		printTest("testIndexOfOnAddAfterIndexedListTwoValid", testIndexOfOnAddAfterIndexedListTwoValid());
		printTest("testIndexOfOnAddAfterIndexedListTwoInvalid", testIndexOfOnAddAfterIndexedListTwoInvalid());
		printTest("testRemoveIndexOnAddAfterIndexedListTwoValid", testRemoveIndexOnAddAfterIndexedListTwoValid());
		printTest("testRemoveIndexOnAddAfterIndexedListTwoInvalid", testRemoveIndexOnAddAfterIndexedListTwoInvalid());
		// TESTS ON A LIST WITH TWO VALUE, AFTER remove())
		printTest("testAddAtIndexOnRemoveIndexedListTwoValid", testAddAtIndexOnRemoveIndexedListTwoValid());
		printTest("testAddAtIndexOnRemoveIndexedListTwoInvalid", testAddAtIndexOnRemoveIndexedListTwoInvalid());
		printTest("testAddV2OnRemoveIndexedListTwo", testAddV2OnRemoveIndexedListTwo());
		printTest("testSetOnRemoveIndexedListTwoValid", testSetOnRemoveIndexedListTwoValid());
		printTest("testSetOnRemoveIndexedListTwoInvalid", testSetOnRemoveIndexedListTwoInvalid());
		printTest("testGetOnRemoveIndexedListTwoValid", testGetOnRemoveIndexedListTwoValid());
		printTest("testGetOnRemoveIndexedListTwoInvalid", testGetOnRemoveIndexedListTwoInvalid());
		printTest("testIndexOfOnRemoveIndexedListTwoValid", testIndexOfOnRemoveIndexedListTwoValid());
		printTest("testIndexOfOnRemoveIndexedListTwoalid", testIndexOfOnRemoveIndexedListTwoInvalid());
		printTest("testRemoveIndexOnRemoveIndexedListTwoValid", testRemoveIndexOnRemoveIndexedListTwoValid());
		printTest("testRemoveIndexOnRemoveIndexedListTwoInvalid", testRemoveIndexOnRemoveIndexedListTwoInvalid());
		// TESTS ON A LIST WITH THREE VALUE, AFTER AddToFront())
		printTest("testAddAtIndexOnAddToFrontIndexedListThreeValid", testAddAtIndexOnAddToFrontIndexedListThreeValid());
		printTest("testAddAtIndexOnAddToFrontIndexedListThreeInvalid", testAddAtIndexOnAddToFrontIndexedListThreeInvalid());
		printTest("testAddV2OnAddToFrontIndexedListThree", testAddV2OnAddToFrontIndexedListThree());
		printTest("testSetOnAddToFrontIndexedListThreeValid", testSetOnAddToFrontIndexedListThreeValid());
		printTest("testSetOnAddToFrontIndexedListThreeInvalid", testSetOnAddToFrontIndexedListThreeInvalid());
		printTest("testGetOnAddToFrontIndexedListThreeValid", testGetOnAddToFrontIndexedListThreeValid());
		printTest("testGetOnAddToFrontIndexedListThreeInvalid", testGetOnAddToFrontIndexedListThreeInvalid());
		printTest("testIndexOfOnAddToFrontIndexedListThreeValid", testIndexOfOnAddToFrontIndexedListThreeValid());
		printTest("testIndexOfOnAddToFrontIndexedListThreealid", testIndexOfOnAddToFrontIndexedListThreeInvalid());
		printTest("testRemoveIndexOnAddToFrontIndexedListThreeValid", testRemoveIndexOnAddToFrontIndexedListThreeValid());
		printTest("testRemoveIndexOnAddToFrontIndexedListThreeInvalid", testRemoveIndexOnAddToFrontIndexedListThreeInvalid());
		// TESTS ON A LIST WITH THREE VALUE, AFTER AddAfter(<1st Element>)
		printTest("testAddAtIndexOnAddAfterIndexedListThreeValid", testAddAtIndexOnAddAfterIndexedListThreeValid());
		printTest("testAddAtIndexOnAddAfterIndexedListThreeInvalid", testAddAtIndexOnAddAfterIndexedListThreeInvalid());
		printTest("testAddV2OnAddAfterIndexedListThree", testAddV2OnAddAfterIndexedListThree());
		printTest("testSetOnAddAfterIndexedListThreeValid", testSetOnAddAfterIndexedListThreeValid());
		printTest("testSetOnAddAfterIndexedListThreeInvalid", testSetOnAddAfterIndexedListThreeInvalid());
		printTest("testGetOnAddAfterIndexedListThreeValid", testGetOnAddAfterIndexedListThreeValid());
		printTest("testGetOnAddAfterIndexedListThreeInvalid", testGetOnAddAfterIndexedListThreeInvalid());
		printTest("testIndexOfOnAddAfterIndexedListThreeValid", testIndexOfOnAddAfterIndexedListThreeValid());
		printTest("testIndexOfOnAddAfterIndexedListThreealid", testIndexOfOnAddAfterIndexedListThreeInvalid());
		printTest("testRemoveIndexOnAddAfterIndexedListThreeValid", testRemoveIndexOnAddAfterIndexedListThreeValid());
		printTest("testRemoveIndexOnAddAfterIndexedListThreeInvalid", testRemoveIndexOnAddAfterIndexedListThreeInvalid());
		// TESTS ON A LIST WITH THREE VALUE, AFTER AddAfter(<2nd Element>)
		printTest("testAddAtIndexOnAddAfterSecondIndexedListThreeValid", testAddAtIndexOnAddAfterSecondIndexedListThreeValid());
		printTest("testAddAtIndexOnAddAfterSecondIndexedListThreeInvalid", testAddAtIndexOnAddAfterSecondIndexedListThreeInvalid());
		printTest("testAddV2OnAddAfterSecondIndexedListThree", testAddV2OnAddAfterSecondIndexedListThree());
		printTest("testSetOnAddAfterSecondIndexedListThreeValid", testSetOnAddAfterSecondIndexedListThreeValid());
		printTest("testSetOnAddAfterSecondIndexedListThreeInvalid", testSetOnAddAfterSecondIndexedListThreeInvalid());
		printTest("testGetOnAddAfterSecondIndexedListThreeValid", testGetOnAddAfterSecondIndexedListThreeValid());
		printTest("testGetOnAddAfterSecondIndexedListThreeInvalid", testGetOnAddAfterSecondIndexedListThreeInvalid());
		printTest("testIndexOfOnAddAfterSecondIndexedListThreeValid", testIndexOfOnAddAfterSecondIndexedListThreeValid());
		printTest("testIndexOfOnAddAfterSecondIndexedListThreealid", testIndexOfOnAddAfterSecondIndexedListThreeInvalid());
		printTest("testRemoveIndexOnAddAfterSecondIndexedListThreeValid", testRemoveIndexOnAddAfterSecondIndexedListThreeValid());
		printTest("testRemoveIndexOnAddAfterSecondIndexedListThreeInvalid", testRemoveIndexOnAddAfterSecondIndexedListThreeInvalid());
		// TESTS ON A LIST WITH THREE VALUE, AFTER AddToRear())
		printTest("testAddAtIndexOnAddToRearIndexedListThreeValid", testAddAtIndexOnAddToRearIndexedListThreeValid());
		printTest("testAddAtIndexOnAddToRearIndexedListThreeInvalid", testAddAtIndexOnAddToRearIndexedListThreeInvalid());
		printTest("testAddV2OnAddToRearIndexedListThree", testAddV2OnAddToRearIndexedListThree());
		printTest("testSetOnAddToRearIndexedListThreeValid", testSetOnAddToRearIndexedListThreeValid());
		printTest("testSetOnAddToRearIndexedListThreeInvalid", testSetOnAddToRearIndexedListThreeInvalid());
		printTest("testGetOnAddToRearIndexedListThreeValid", testGetOnAddToRearIndexedListThreeValid());
		printTest("testGetOnAddToRearIndexedListThreeInvalid", testGetOnAddToRearIndexedListThreeInvalid());
		printTest("testIndexOfOnAddToRearIndexedListThreeValid", testIndexOfOnAddToRearIndexedListThreeValid());
		printTest("testIndexOfOnAddToRearIndexedListThreealid", testIndexOfOnAddToRearIndexedListThreeInvalid());
		printTest("testRemoveIndexOnAddToRearIndexedListThreeValid", testRemoveIndexOnAddToRearIndexedListThreeValid());
		printTest("testRemoveIndexOnAddToRearIndexedListThreeInvalid", testRemoveIndexOnAddToRearIndexedListThreeInvalid());
		// TESTS ON A LIST WITH THREE VALUE, AFTER remove()) TODO
		// TESTS ON A LIST WITH THREE VALUE, AFTER removeFirst()) TODO
		// TESTS ON A LIST WITH THREE VALUE, AFTER RemoveLast()) TODO

		// /
		// /New Scenarios
		// /
		// 1) [] -> add(A) -> [A]
		printTest("testAddToFrontOnAddElementOne", testAddToFrontOnAddElementOne());
		printTest("testAddToRearOnAddElementOne", testAddToRearOnAddElementOne());
		printTest("testAddAfterOnAddElementOneValid", testAddAfterOnAddElementOneValid());
		printTest("testAddAfterOnAddElementOneInvalid", testAddAfterOnAddElementOneInvalid());
		printTest("testRemoveFirstOnAddElementOne", testRemoveFirstOnAddElementOne());
		printTest("testRemoveLastOnAddElementOne", testRemoveLastOnAddElementOne());
		printTest("testRemoveElementOnAddElementOneValid", testRemoveElementOnAddElementOneValid());
		printTest("testRemoveElementOnAddElementOneInvalid", testRemoveElementOnAddElementOneInvalid());
		printTest("testFirstOnAddElementOne", testFirstOnAddElementOne());
		printTest("testLastOnAddElementOne", testLastOnAddElementOne());
		printTest("testContainsOnAddElementOneValid", testContainsOnAddElementOneValid());
		printTest("testContainsOnAddElementOneInvalid", testContainsOnAddElementOneInvalid());
		printTest("testIsEmptyOnAddElementOne", testIsEmptyOnAddElementOne());
		printTest("testSizeOnAddElementOne", testSizeOnAddElementOne());
		printTest("testIteratorOnAddElementOne", testIteratorOnAddElementOne());
		printTest("testToStringOnAddElementOne", testToStringOnAddElementOne());

		printTest("testAddAtIndexOnAddElementOne", testAddAtIndexOnAddElementOneValid());
		printTest("testAddAtIndexOnAddElementOneInvalid", testAddAtIndexOnAddElementOneInvalid());
		printTest("testAddV2OnAddElementOne", testAddV2OnAddElementOne());
		printTest("testSetOnAddElementOneValid", testSetOnAddElementOneValid());
		printTest("testSetOnAddElementOneInvalid", testSetOnAddElementOneInvalid());
		printTest("testGetOnAddElementOneValid", testGetOnAddElementOneValid());
		printTest("testGetOnAddElementOneInvalid", testGetOnAddElementOneInvalid());
		printTest("testIndexOfOnAddElementOneValid", testIndexOfOnAddElementOneValid());
		printTest("testIndexOfOnAddElementOneInvalid", testIndexOfOnAddElementOneInvalid());
		printTest("testRemoveIndexOnAddElementOne", testRemoveIndexOnAddElementOne());
		// 2) [] -> add(0,A) -> [A]
		printTest("testAddToFrontOnAddAtOne", testAddToFrontOnAddAtOne());
		printTest("testAddToRearOnAddAtOne", testAddToRearOnAddAtOne());
		printTest("testAddAfterOnAddAtOneValid", testAddAfterOnAddAtOneValid());
		printTest("testAddAfterOnAddAtOneInvalid", testAddAfterOnAddAtOneInvalid());
		printTest("testRemoveFirstOnAddAtOne", testRemoveFirstOnAddAtOne());
		printTest("testRemoveLastOnAddAtOne", testRemoveLastOnAddAtOne());
		printTest("testRemoveElementOnAddAtOneValid", testRemoveElementOnAddAtOneValid());
		printTest("testRemoveElementOnAddAtOneInvalid", testRemoveElementOnAddAtOneInvalid());
		printTest("testFirstOnAddAtOne", testFirstOnAddAtOne());
		printTest("testLastOnAddAtOne", testLastOnAddAtOne());
		printTest("testContainsOnAddAtOneValid", testContainsOnAddAtOneValid());
		printTest("testContainsOnAddAtOneInvalid", testContainsOnAddAtOneInvalid());
		printTest("testIsEmptyOnAddAtOne", testIsEmptyOnAddAtOne());
		printTest("testSizeOnAddAtOne", testSizeOnAddAtOne());
		printTest("testIteratorOnAddAtOne", testIteratorOnAddAtOne());
		printTest("testToStringOnAddAtOne", testToStringOnAddAtOne());

		printTest("testAddAtIndexOnAddAtOne", testAddAtIndexOnAddAtOneValid());
		printTest("testAddAtIndexOnAddAtOneInvalid", testAddAtIndexOnAddAtOneInvalid());
		printTest("testAddV2OnAddAtOne", testAddV2OnAddAtOne());
		printTest("testSetOnAddAtOneValid", testSetOnAddAtOneValid());
		printTest("testSetOnAddAtOneInvalid", testSetOnAddAtOneInvalid());
		printTest("testGetOnAddAtOneValid", testGetOnAddAtOneValid());
		printTest("testGetOnAddAtOneInvalid", testGetOnAddAtOneInvalid());
		printTest("testIndexOfOnAddAtOneValid", testIndexOfOnAddAtOneValid());
		printTest("testIndexOfOnAddAtOneInvalid", testIndexOfOnAddAtOneInvalid());
		printTest("testRemoveIndexOnAddAtOne", testRemoveIndexOnAddAtOne());
		// 3) [A] -> remove(0) -> []
		printTest("testAddToFrontOnRemoveIndexEmpty", testAddToFrontOnRemoveIndexEmpty());
		printTest("testAddToRearOnRemoveIndexEmpty", testAddToRearOnRemoveIndexEmpty());
		printTest("testAddAfterOnRemoveIndexEmpty", testAddAfterOnRemoveIndexEmpty());
		printTest("testRemoveFirstOnRemoveIndexEmpty", testRemoveFirstOnRemoveIndexEmpty());
		printTest("testRemoveLastOnRemoveIndexEmpty", testRemoveLastOnRemoveIndexEmpty());
		printTest("testRemoveElementOnRemoveIndexEmpty", testRemoveElementOnRemoveIndexEmpty());
		printTest("testFirstOnRemoveIndexEmpty", testFirstOnRemoveIndexEmpty());
		printTest("testLastOnRemoveIndexEmpty", testLastOnRemoveIndexEmpty());
		printTest("testContainsOnRemoveIndexEmpty", testContainsOnRemoveIndexEmpty());
		printTest("testIsEmptyOnRemoveIndexEmpty", testIsEmptyOnRemoveIndexEmpty());
		printTest("testSizeOnRemoveIndexEmpty", testSizeOnRemoveIndexEmpty());
		printTest("testIteratorOnRemoveIndexEmpty", testIteratorOnRemoveIndexEmpty());
		printTest("testToStringOnRemoveIndexEmpty", testToStringOnRemoveIndexEmpty());

		printTest("testAddAtIndexOnRemoveIndexEmptyValid", testAddAtIndexOnRemoveIndexEmptyValid());
		printTest("testAddAtIndexOnRemoveIndexEmptyInvalid", testAddAtIndexOnRemoveIndexEmptyInvalid());
		printTest("testAddV2OnRemoveIndexEmpty", testAddV2OnRemoveIndexEmpty());
		printTest("testSetOnRemoveIndexEmptyValid", testSetOnRemoveIndexEmptyValid());
		printTest("testSetOnRemoveIndexEmptyInvalid", testSetOnRemoveIndexEmptyInvalid());
		printTest("testGetOnRemoveIndexEmptyValid", testGetOnRemoveIndexEmptyValid());
		printTest("testIndexOfOnRemoveIndexEmpty", testIndexOfOnRemoveIndexEmpty());
		printTest("testRemoveIndexOnRemoveIndexEmpty", testRemoveIndexOnRemoveIndexEmpty());
		// // 4) [A] -> set(0,B) -> [B]
		printTest("testAddToFrontOnSetOne", testAddToFrontOnSetOne());
		printTest("testAddToRearOnSetOne", testAddToRearOnSetOne());
		printTest("testAddAfterOnSetOneValid", testAddAfterOnSetOneValid());
		printTest("testAddAfterOnSetOneInvalid", testAddAfterOnSetOneInvalid());
		printTest("testRemoveFirstOnSetOne", testRemoveFirstOnSetOne());
		printTest("testRemoveLastOnSetOne", testRemoveLastOnSetOne());
		printTest("testRemoveElementOnSetOneValid", testRemoveElementOnSetOneValid());
		printTest("testRemoveElementOnSetOneInvalid", testRemoveElementOnSetOneInvalid());
		printTest("testFirstOnSetOne", testFirstOnSetOne());
		printTest("testLastOnSetOne", testLastOnSetOne());
		printTest("testContainsOnSetOneValid", testContainsOnSetOneValid());
		printTest("testContainsOnSetOneInvalid", testContainsOnSetOneInvalid());
		printTest("testIsEmptyOnSetOne", testIsEmptyOnSetOne());
		printTest("testSizeOnSetOne", testSizeOnSetOne());
		printTest("testIteratorOnSetOne", testIteratorOnSetOne());
		printTest("testToStringOnSetOne", testToStringOnSetOne());

		printTest("testAddAtIndexOnSetOne", testAddAtIndexOnSetOneValid());
		printTest("testAddAtIndexOnSetOneInvalid", testAddAtIndexOnSetOneInvalid());
		printTest("testAddV2OnSetOne", testAddV2OnSetOne());
		printTest("testSetOnSetOneValid", testSetOnSetOneValid());
		printTest("testSetOnSetOneInvalid", testSetOnSetOneInvalid());
		printTest("testGetOnSetOneValid", testGetOnSetOneValid());
		printTest("testGetOnSetOneInvalid", testGetOnSetOneInvalid());
		printTest("testIndexOfOnSetOneValid", testIndexOfOnSetOneValid());
		printTest("testIndexOfOnSetOneInvalid", testIndexOfOnSetOneInvalid());
		printTest("testRemoveIndexOnSetOne", testRemoveIndexOnSetOne());
		// 7) [A,B] -> remove(0) -> [B] TODO
		printTest("testAddToFrontOnRemoveFirstOne", testAddToFrontOnRemoveFirstOne());
		printTest("testAddToRearOnRemoveFirstOne", testAddToRearOnRemoveFirstOne());
		printTest("testAddAfterOnRemoveFirstOneValid", testAddAfterOnRemoveFirstOneValid());
		printTest("testAddAfterOnRemoveFirstOneInvalid", testAddAfterOnRemoveFirstOneInvalid());
		printTest("testRemoveFirstOnRemoveFirstOne", testRemoveFirstOnRemoveFirstOne());
		printTest("testRemoveLastOnRemoveFirstOne", testRemoveLastOnRemoveFirstOne());
		printTest("testRemoveElementOnRemoveFirstOneValid", testRemoveElementOnRemoveFirstOneValid());
		printTest("testRemoveElementOnRemoveFirstOneInvalid", testRemoveElementOnRemoveFirstOneInvalid());
		printTest("testFirstOnRemoveFirstOne", testFirstOnRemoveFirstOne());
		printTest("testLastOnRemoveFirstOne", testLastOnRemoveFirstOne());
		printTest("testContainsOnRemoveFirstOneValid", testContainsOnRemoveFirstOneValid());
		printTest("testContainsOnRemoveFirstOneInvalid", testContainsOnRemoveFirstOneInvalid());
		printTest("testIsEmptyOnRemoveFirstOne", testIsEmptyOnRemoveFirstOne());
		printTest("testSizeOnRemoveFirstOne", testSizeOnRemoveFirstOne());
		printTest("testIteratorOnRemoveFirstOne", testIteratorOnRemoveFirstOne());
		printTest("testToStringOnRemoveFirstOne", testToStringOnRemoveFirstOne());

		printTest("testAddAtIndexOnRemoveFirstOne", testAddAtIndexOnRemoveFirstOneValid());
		printTest("testAddAtIndexOnRemoveFirstOneInvalid", testAddAtIndexOnRemoveFirstOneInvalid());
		printTest("testAddV2OnRemoveFirstOne", testAddV2OnRemoveFirstOne());
		printTest("testSetOnRemoveFirstOneValid", testSetOnRemoveFirstOneValid());
		printTest("testSetOnRemoveFirstOneInvalid", testSetOnRemoveFirstOneInvalid());
		printTest("testGetOnRemoveFirstOneValid", testGetOnRemoveFirstOneValid());
		printTest("testGetOnRemoveFirstOneInvalid", testGetOnRemoveFirstOneInvalid());
		printTest("testIndexOfOnRemoveFirstOneValid", testIndexOfOnRemoveFirstOneValid());
		printTest("testIndexOfOnRemoveFirstOneInvalid", testIndexOfOnRemoveFirstOneInvalid());
		printTest("testRemoveIndexOnRemoveFirstOne", testRemoveIndexOnRemoveFirstOne());
		// 8) [A,B] -> remove(1) -> [A] TODO
		// 5) [A] -> add(0,B) -> [B,A]
		printTest("testAddToFrontOnAddAtFirstTwo", testAddToFrontOnAddAtFirstTwo());
		printTest("testAddToRearOnAddAtFirstTwo", testAddToRearOnAddAtFirstTwo());
		printTest("testAddAfterFirstOnAddAtFirstTwoValid", testAddAfterFirstOnAddAtFirstTwoValid());
		printTest("testAddAfterSecondOnAddAtFirstTwoValid", testAddAfterSecondOnAddAtFirstTwoValid());
		printTest("testAddAfterOnAddAtFirstTwoInvalid", testAddAfterOnAddAtFirstTwoInvalid());
		printTest("testRemoveFirstOnAddAtFirstTwo", testRemoveFirstOnAddAtFirstTwo());
		printTest("testRemoveLastOnAddAtFirstTwo", testRemoveLastOnAddAtFirstTwo());
		printTest("testRemoveFirstElementOnAddAtFirstTwoValid", testRemoveFirstElementOnAddAtFirstTwoValid());
		printTest("testRemoveSecondElementOnAddAtFirstTwoValid", testRemoveSecondElementOnAddAtFirstTwoValid());
		printTest("testRemoveElementOnAddAtFirstTwoInvalid", testRemoveElementOnAddAtFirstTwoInvalid());
		printTest("testFirstOnAddAtFirstTwo", testFirstOnAddAtFirstTwo());
		printTest("testLastOnAddAtFirstTwo", testLastOnAddAtFirstTwo());
		printTest("testContainsFirstOnAddAtFirstTwoValid", testContainsFirstOnAddAtFirstTwoValid());
		printTest("testContainsSecondOnAddAtFirstTwoValid", testContainsSecondOnAddAtFirstTwoValid());
		printTest("testContainsOnAddAtFirstTwoInvalid", testContainsOnAddAtFirstTwoInvalid());
		printTest("testIsEmptyOnAddAtFirstTwo", testIsEmptyOnAddAtFirstTwo());
		printTest("testSizeOnAddAtFirstTwo", testSizeOnAddAtFirstTwo());
		printTest("testIteratorOnAddAtFirstTwo", testIteratorOnAddAtFirstTwo());
		printTest("testToStringOnAddAtFirstTwo", testToStringOnAddAtFirstTwo());

		printTest("testAddAtIndexOnAddAtFirstTwo", testAddAtIndexOnAddAtFirstTwoValid());
		printTest("testAddAtIndexOnAddAtFirstTwoInvalid", testAddAtIndexOnAddAtFirstTwoInvalid());
		printTest("testAddV2OnAddAtFirstTwo", testAddV2OnAddAtFirstTwo());
		printTest("testSetFirstOnAddAtFirstTwoValid", testSetFirstOnAddAtFirstTwoValid());
		printTest("testSetSecondOnAddAtFirstTwoValid", testSetSecondOnAddAtFirstTwoValid());
		printTest("testSetOnAddAtFirstTwoInvalid", testSetOnAddAtFirstTwoInvalid());
		printTest("testGetFirstOnAddAtFirstTwoValid", testGetFirstOnAddAtFirstTwoValid());
		printTest("testGetSecondOnAddAtFirstTwoValid", testGetSecondOnAddAtFirstTwoValid());
		printTest("testGetOnAddAtFirstTwoInvalid", testGetOnAddAtFirstTwoInvalid());
		printTest("testIndexOfFirstOnAddAtFirstTwoValid", testIndexOfFirstOnAddAtFirstTwoValid());
		printTest("testIndexOfSecondOnAddAtFirstTwoValid", testIndexOfSecondOnAddAtFirstTwoValid());
		printTest("testIndexOfOnAddAtFirstTwoInvalid", testIndexOfOnAddAtFirstTwoInvalid());
		printTest("testRemoveIndexOnAddAtFirstTwoValid", testRemoveIndexOnAddAtFirstTwoValid());
		printTest("testRemoveIndexOnAddAtFirstTwoInvalid", testRemoveIndexOnAddAtFirstTwoInvalid());
		// 6) [A] -> add[1,B) -> [A,B]
		printTest("testAddToFrontOnAddAtSecondTwo", testAddToFrontOnAddAtSecondTwo());
		printTest("testAddToRearOnAddAtSecondTwo", testAddToRearOnAddAtSecondTwo());
		printTest("testAddAfterFirstOnAddAtSecondTwoValid", testAddAfterFirstOnAddAtSecondTwoValid());
		printTest("testAddAfterSecondOnAddAtSecondTwoValid", testAddAfterSecondOnAddAtSecondTwoValid());
		printTest("testAddAfterOnAddAtSecondTwoInvalid", testAddAfterOnAddAtSecondTwoInvalid());
		printTest("testRemoveFirstOnAddAtSecondTwo", testRemoveFirstOnAddAtSecondTwo());
		printTest("testRemoveLastOnAddAtSecondTwo", testRemoveLastOnAddAtSecondTwo());
		printTest("testRemoveFirstElementOnAddAtSecondTwoValid", testRemoveFirstElementOnAddAtSecondTwoValid());
		printTest("testRemoveSecondElementOnAddAtSecondTwoValid", testRemoveSecondElementOnAddAtSecondTwoValid());
		printTest("testRemoveElementOnAddAtSecondTwoInvalid", testRemoveElementOnAddAtSecondTwoInvalid());
		printTest("testFirstOnAddAtSecondTwo", testFirstOnAddAtSecondTwo());
		printTest("testLastOnAddAtSecondTwo", testLastOnAddAtSecondTwo());
		printTest("testContainsFirstOnAddAtSecondTwoValid", testContainsFirstOnAddAtSecondTwoValid());
		printTest("testContainsSecondOnAddAtSecondTwoValid", testContainsSecondOnAddAtSecondTwoValid());
		printTest("testContainsOnAddAtSecondTwoInvalid", testContainsOnAddAtSecondTwoInvalid());
		printTest("testIsEmptyOnAddAtSecondTwo", testIsEmptyOnAddAtSecondTwo());
		printTest("testSizeOnAddAtSecondTwo", testSizeOnAddAtSecondTwo());
		printTest("testIteratorOnAddAtSecondTwo", testIteratorOnAddAtSecondTwo());
		printTest("testToStringOnAddAtSecondTwo", testToStringOnAddAtSecondTwo());

		printTest("testAddAtIndexOnAddAtSecondTwo", testAddAtIndexOnAddAtSecondTwoValid());
		printTest("testAddAtIndexOnAddAtSecondTwoInvalid", testAddAtIndexOnAddAtSecondTwoInvalid());
		printTest("testAddV2OnAddAtSecondTwo", testAddV2OnAddAtSecondTwo());
		printTest("testSetFirstOnAddAtSecondTwoValid", testSetFirstOnAddAtSecondTwoValid());
		printTest("testSetSecondOnAddAtSecondTwoValid", testSetSecondOnAddAtSecondTwoValid());
		printTest("testSetOnAddAtSecondTwoInvalid", testSetOnAddAtSecondTwoInvalid());
		printTest("testGetFirstOnAddAtSecondTwoValid", testGetFirstOnAddAtSecondTwoValid());
		printTest("testGetSecondOnAddAtSecondTwoValid", testGetSecondOnAddAtSecondTwoValid());
		printTest("testGetOnAddAtSecondTwoInvalid", testGetOnAddAtSecondTwoInvalid());
		printTest("testIndexOfFirstOnAddAtSecondTwoValid", testIndexOfFirstOnAddAtSecondTwoValid());
		printTest("testIndexOfSecondOnAddAtSecondTwoValid", testIndexOfSecondOnAddAtSecondTwoValid());
		printTest("testIndexOfOnAddAtSecondTwoInvalid", testIndexOfOnAddAtSecondTwoInvalid());
		printTest("testRemoveIndexOnAddAtSecondTwoValid", testRemoveIndexOnAddAtSecondTwoValid());
		printTest("testRemoveIndexOnAddAtSecondTwoInvalid", testRemoveIndexOnAddAtSecondTwoInvalid());
		// 9) [A,B] -> set(0,C) -> [C,B] TODO
		// 10) [A,B] -> set(1,C) -> [A,C] TODO
		// 15) [A,B,C] -> remove(0) -> [B,C] TODO
		// 16) [A,B,C] -> remove(1) -> [A,C] TODO
		// 17) [A,B,C] -> remove(2) -> [A,B] TODO
		// 11) [A,B] -> add(C) -> [A,B,C] TODO
		// 12) [A,B] -> add(0,C) -> [C,A,B] TODO
		// 13) [A,B] -> add(1,C) -> [A,C,B] TODO
		// 14) [A,B] -> add (2,C) -> [A,B,C] TODO
		// 18) [A,B,C] -> set(0,D) -> [D,B,C] TODO
		// 19) [A,B,C] -> set(1,D) -> [A,D,C] TODO
		// 20) [A,B,C] -> set(2,D) -> [A,B,D] TODO
	}

	// //////////////////////////
	// SCENARIO: NEW, EMPTY LIST TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnNewList", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.first(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			list.last(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnNewList", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testContainsOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return false;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnNewList", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnNewList() {
		UnorderedListADT<Integer> list = newUnorderedList();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST TODO
	/* @return test success */
	private boolean testAddAtIndexOnNewIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedList();
		Integer i = new Integer(1);
		try {
			list.add(0, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnNewIndexedListValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnNewIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedList();
		Integer i = new Integer(1);
		try {
			list.add(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "testAddAtIndexOnNewIndexedListInvalid", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnNewIndexedList() {
		IndexedListADT<Integer> list = newIndexedList();
		Integer i = new Integer(1);
		try {
			list.add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnNewIndexedList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnNewIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedList();
		Integer i = new Integer(1);
		try {
			list.set(0, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnNewIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnNewIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedList();
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnNewIndexedListValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnNewIndexedList() {
		IndexedListADT<Integer> list = newIndexedList();
		Integer i = new Integer(1);
		try {
			list.indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnNewIndexedList", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnNewIndexedList() {
		IndexedListADT<Integer> list = newIndexedList();
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnNewIndexedList", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// //////////////////////////
	// SCENARIO: Removed an element from List, now empty TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnRemoveEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnRemoveEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnRemoveEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.first(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnRemoveEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			list.last(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnRemoveEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testContainsOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return false;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveEmpty", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveEmpty() {
		UnorderedListADT<Integer> list = newListRemoveEmpty();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER REMOVING ELMENT TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveElementIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		Integer i = new Integer(1);
		try {
			list.add(0, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveElementIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveElementIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		Integer i = new Integer(1);
		try {
			list.add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveElementIndexedList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveElementIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		Integer i = new Integer(1);
		try {
			list.set(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveElementIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveElementIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveElementIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testIndexOfOnRemoveElementIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		Integer i = new Integer(1);
		try {
			list.indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveElementIndexedList", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnRemoveElementIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveElementEmpty();
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveElementIndexedList", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// //////////////////////////
	// SCENARIO: empty List, removeFirst()TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnRemoveFirstEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveFirstEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveFirstEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnRemoveFirstEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnRemoveFirstEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveFirstEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.first(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnRemoveFirstEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			list.last(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnRemoveFirstEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testContainsOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveFirstEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveFirstEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveFirstEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return false;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveFirstEmpty", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveFirstEmpty() {
		UnorderedListADT<Integer> list = newListRemoveFirstEmpty();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER Removing First ELMENT TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveFirstIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.add(0, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveFirstIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveFirstIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveFirstIndexedList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveFirstIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.set(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveFirstIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveFirstIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveFirstIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testIndexOfOnRemoveFirstIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		Integer i = new Integer(1);
		try {
			list.indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveFirstIndexedList", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnRemoveFirstIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstEmpty();
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveFirstIndexedList", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// //////////////////////////
	// SCENARIO: empty List, removeLast()TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnRemoveLastEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveLastEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveLastEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.removeFirst();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnRemoveLastEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.removeLast();
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnRemoveLastEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveLastEmpty", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.first(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnRemoveLastEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			list.last(); // exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnRemoveLastEmpty", "EmptyCollectionException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testContainsOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveLastEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveLastEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveLastEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return false;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveLastEmpty", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveLastEmpty() {
		UnorderedListADT<Integer> list = newListRemoveLastEmpty();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER REMOVELAST TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveLastIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.add(0, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveLastIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveLastIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveLastIndexedList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveLastIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.set(1, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveLastIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveLastIndexedListValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveLastIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testIndexOfOnRemoveLastIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		Integer i = new Integer(1);
		try {
			list.indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveLastIndexedList", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveLastIndexedListInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		try {
			list.get(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnRemoveLastIndexedListInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnRemoveLastIndexedList() {
		IndexedListADT<Integer> list = newIndexedListRemoveLastEmpty();
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveElementIndexedList", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// //////////////////////////
	// SCENARIO: One-Element, AddToFront() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToFrontOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			list.addToFront(new Integer(1));
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToFrontOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToFrontOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(1));
			list.addAfter(new Integer(2), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToFrontOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToFrontOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToFrontOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddToFrontOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddToFrontOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToFrontOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToFrontOneValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToFrontOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToFrontOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddToFrontOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddToFrontOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnAddToFrontOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToFrontOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToFrontOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToFrontOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToFrontOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToFrontOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToFrontOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToFrontIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToFrontIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToFrontIndexedListOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToFrontIndexedListOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToFrontIndexedListOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToFrontIndexedListOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToFrontIndexedListOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToFrontIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToFrontIndexedListOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testIndexOfOnAddToFrontIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToFrontIndexedListOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddToFrontIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToFrontIndexedListOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToFrontIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToFrontIndexedListOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToFrontIndexedListOne() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveElementIndexedList", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// //////////////////////////
	// SCENARIO: One-Element, addToRear() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToRearOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToRearOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			list.addAfter(new Integer(2), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToRearOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			list.addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToRearOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddToRearOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToRearOne() {

		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddToRearOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToRearOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToRearOneValid", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToRearOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToRearOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddToRearOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddToRearOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnAddToRearOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToRearOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToRearOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToRearOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToRearOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToRearOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToRear TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToRearIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddToRearIndexedListOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToRearIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToRearIndexedListOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToRearIndexedListOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToRearIndexedListOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToRearIndexedListOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToRearIndexedListOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToRearIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToRearIndexedListOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testIndexOfOnAddToRearIndexedListOneValid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToRearIndexedListOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddToRearIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToRearIndexedListOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToRearIndexedListOneInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToRearIndexedListOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToRearIndexedListOne() {
		UnorderedListADT<Integer> list = newListAddToRearOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToRearIndexedListOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ////////////////////////
	// SCENARIO: Two-Element, after addToFront() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(3);
		try {
			list.addToFront(new Integer(2));
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToFrontTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		Integer i = new Integer(3);
		try {
			list.addToFront(new Integer(2));
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToFrontTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToFrontTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			list.addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToFrontTwoValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToFrontTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			list.addAfter(new Integer(1), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToFrontTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.removeFirst().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddToFrontTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddToFrontTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddToFrontTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstElementOnAddToFrontTwoValid", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddToFrontTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveSecondElementOnAddToFrontTwoValid", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToFrontTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToFrontTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.first().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddToFrontTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddToFrontTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnAddToFrontTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToFrontTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToFrontTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToFrontTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToFrontTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToFrontTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToFrontTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToFrontTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			list.addToFront(new Integer(2));
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS TWo ELEMENT LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToFrontIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddToFrontIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToFrontIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToFrontIndexedListTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToFrontIndexedListTwo() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToFrontIndexedListTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToFrontIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToFrontIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddToFrontIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddToFrontIndexedListTwoValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddToFrontIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToFrontIndexedListTwoInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToFrontIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToFrontIndexedListTwoValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddToFrontIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToFrontIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToFrontIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToFrontIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddToFrontIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontTwo();
		try {
			((ArrayList<Integer>) list).remove(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToFrontIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ////////////////////////
	// SCENARIO: Two-Element, after addToRear() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		Integer i = new Integer(3);
		try {
			list.addToRear(new Integer(2));
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToRearTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		Integer i = new Integer(3);
		try {
			list.addToRear(new Integer(2));
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToRearTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			list.addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterOnAddToRearTwoValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			list.addAfter(new Integer(1), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToRearTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.removeLast().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddToRearTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddToRearTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddToRearTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddToRearTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToRearTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToRearTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.last().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddToRearTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddToRearTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddToRearTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddToRearTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToRearTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToRearTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToRearTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addToRear(new Integer(2));
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS TWo ELEMENT LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToRearIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddToRearIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToRearIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToRearIndexedListTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToRearIndexedListTwo() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToRearIndexedListTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToRearIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToRearIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddToRearIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddToRearIndexedListTwoValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddToRearIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToRearIndexedListTwoInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToRearIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToRearIndexedListTwoValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddToRearIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToRearIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToRearIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToRearIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddToRearIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearTwoElement();
		try {
			((ArrayList<Integer>) list).remove(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToRearIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ////////////////////////
	// SCENARIO: Two-Element, after addAfter() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		Integer i = new Integer(3);
		try {
			list.addAfter(new Integer(2), new Integer(1));
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAfterTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		Integer i = new Integer(3);
		try {
			list.addAfter(new Integer(2), new Integer(1));
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAfterTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAfterTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			list.addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterOnAddAfterTwoValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAfterTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			list.addAfter(new Integer(1), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAfterTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.removeLast().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddAfterTwo", e.toString());
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddAfterTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddAfterTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddAfterTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddAfterTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAfterTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAfterTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.last().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddAfterTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddAfterTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddAfterTwoValid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddAfterTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAfterTwoInvalid() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAfterTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAfterTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAfterTwo() {
		UnorderedListADT<Integer> list = newListOneElement();
		try {
			list.addAfter(new Integer(2), new Integer(1));
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS TWo ELEMENT LIST AFTER AddAfter TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAfterIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddAfterIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAfterIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAfterIndexedListTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAfterIndexedListTwo() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAfterIndexedListTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAfterIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAfterIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddAfterIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddAfterIndexedListTwoValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddAfterIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAfterIndexedListTwoInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddAfterIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterIndexedListTwoValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddAfterIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAfterIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddAfterIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterTwoElement();
		try {
			((ArrayList<Integer>) list).remove(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ////////////////////////
	// SCENARIO: Two-Element, after Remove() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnRemoveTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			list.addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterOnRemoveTwoValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			list.addAfter(new Integer(1), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnRemoveTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.removeLast().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnRemoveTwo", e.toString());
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstElementOnRemoveTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnRemoveTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnRemoveTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnRemoveTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnRemoveTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.last().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnRemoveTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnRemoveTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnRemoveTwoValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnRemoveTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnRemoveTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnRemoveTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {

			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS TWo ELEMENT LIST AFTER AddAfter TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnRemoveIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnRemoveIndexedListTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveIndexedListTwo() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveIndexedListTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnRemoveIndexedListTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnRemoveIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnRemoveIndexedListTwoValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnRemoveIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveIndexedListTwoInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnRemoveIndexedListTwoValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnRemoveIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnRemoveIndexedListTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnRemoveIndexedListTwoValid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnRemoveIndexedListTwoInvalid() {
		UnorderedListADT<Integer> list = newListRemoveTwoElement();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveIndexedListTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	// //////////////////////
	// SCENARIO: Three-Element, after addToFront() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToFrontThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToFrontThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToFrontThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToFrontThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterSecondElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterSecondElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterThirdElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addAfter(new Integer(4), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterThirdElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToFrontThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.removeFirst().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.removeLast().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.remove(new Integer(3)).equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveThirdElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveThirdElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToFrontThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.first().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.last().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.contains(new Integer(3)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsThirdElementOnAddToFrontThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsThirdElementOnAddToFrontThreeValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToFrontThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToFrontThreeInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToFrontThree", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToFrontThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToFrontThree();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS THREE ELEMENT LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToFrontIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddToFrontIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToFrontIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(4, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToFrontIndexedListThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToFrontIndexedListThree() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToFrontIndexedListThree", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToFrontIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToFrontIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToFrontIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddToFrontIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 2);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddToFrontIndexedListThreeValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddToFrontIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToFrontIndexedListThreeInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToFrontIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(3)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToFrontIndexedListThreeValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddToFrontIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		try {
			((ArrayList<Integer>) list).get(4);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToFrontIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToFrontIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToFrontIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddToFrontIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToFrontThree();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToFrontIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////////
	// SCENARIO: Three-Element, after addAfter() first Element TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAfterFirstElementThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAfterFirstElementThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAfterFirstElementThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAfterFirstElementThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterFirstElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterSecondElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterSecondElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterThirdElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterThirdElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAfterFirstElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.removeLast().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.remove(new Integer(3)).equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveThirdElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveThirdElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAfterFirstElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAfterFirstElementThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.last().equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.contains(new Integer(3)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsThirdElementOnAddAfterFirstElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsThirdElementOnAddAfterFirstElementThreeValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAfterFirstElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAfterFirstElementThreeInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAfterFirstElementThree", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAfterFirstElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS THREE ELEMENT LIST AFTER AddAftor TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAfterIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddAfterIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAfterIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(4, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAfterIndexedListThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAfterIndexedListThree() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAfterIndexedListThree", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAfterIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAfterIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddAfterIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 2);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddAfterIndexedListThreeValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddAfterIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAfterIndexedListThreeInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddAfterIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterIndexedListThreeValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddAfterIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		try {
			((ArrayList<Integer>) list).get(4);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAfterIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddAfterIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterFirstElementThree();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////////
	// SCENARIO: Three-Element, after addAfter() Second Element TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAfterSecondElementThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAfterSecondElementThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAfterSecondElementThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAfterSecondElementThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterFirstElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterSecondElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterSecondElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterThirdElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterThirdElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAfterSecondElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnNewList", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.removeLast().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.remove(new Integer(3)).equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveThirdElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveThirdElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAfterSecondElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAfterSecondElementThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.last().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.contains(new Integer(3)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsThirdElementOnAddAfterSecondElementThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsThirdElementOnAddAfterSecondElementThreeValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAfterSecondElementThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAfterSecondElementThreeInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAfterSecondElementThree", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAfterSecondElementThree() {
		try {
			UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS THREE ELEMENT LIST AFTER AddAftor TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAfterSecondIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddAfterSecondIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAfterSecondIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(4, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAfterSecondIndexedListThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAfterSecondIndexedListThree() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAfterSecondIndexedListThree", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterSecondIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAfterSecondIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAfterSecondIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAfterSecondIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddAfterSecondIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddAfterSecondIndexedListThreeValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddAfterSecondIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAfterSecondIndexedListThreeInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddAfterSecondIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterSecondIndexedListThreeValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddAfterSecondIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		try {
			((ArrayList<Integer>) list).get(4);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAfterSecondIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAfterSecondIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterSecondIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddAfterSecondIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddAfterSecondElementThree();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAfterSecondIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////////
	// SCENARIO: Three-Element, after addToRear() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToRearThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToRearThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToRearThree() {
		Integer i = new Integer(4);
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToRearThree", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addAfter(new Integer(4), new Integer(3));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterFirstElementOnAddToRearThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterSecondElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addAfter(new Integer(4), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterSecondElementOnAddToRearThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterThirdElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addAfter(new Integer(4), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAfterThirdElementOnAddToRearThreeValid", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.addAfter(new Integer(5), new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToRearThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.removeFirst().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.removeLast().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveLastOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.remove(new Integer(3)).equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveFirstElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveSecondElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveSecondElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveThirdElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testRemoveThirdElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddToRearThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			list.remove(new Integer(4));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddToRearThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.first().equals(new Integer(1)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testFirstOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.last().equals(new Integer(3)));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testLastOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.contains(new Integer(3)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsFirstElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsSecondElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsSecondElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsThirdElementOnAddToRearThreeValid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsThirdElementOnAddToRearThreeValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToRearThreeInvalid() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.contains(new Integer(4)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearThreeInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToRearThree", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddToRearThree", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddToRearThree() {
		try {
			UnorderedListADT<Integer> list = newListAddToRearThree();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS THREE ELEMENT LIST AFTER AddAftor TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddToRearIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddAtIndexOnAddToRearIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddToRearIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(4, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddToRearIndexedListThreeInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddToRearIndexedListThree() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddToRearIndexedListThree", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddToRearIndexedListThreeValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddToRearIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).set(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddToRearIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnAddToRearIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIndexOfOnAddToRearIndexedListThreeValid", e.toString());
			return false;
		}
	}

	private boolean testIndexOfOnAddToRearIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		Integer i = new Integer(4);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddToRearIndexedListThreeInvalid", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddToRearIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToRearIndexedListThreeValid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddToRearIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		try {
			((ArrayList<Integer>) list).get(4);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddToRearIndexedListThreeInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddToRearIndexedListThreeValid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToRearIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddToRearIndexedListThreeInvalid() {
		UnorderedListADT<Integer> list = newListAddToRearThree();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddToRearIndexedListThree", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 1) [] -> add(A) -> [A] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddElementOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(2), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddElementOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddElementOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddElementOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddElementOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddElementOneValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddElementOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddElementOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddElementOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddElementOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddElementOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddElementOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddElementOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddElementOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddElementOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddElementOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddElementOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddElementOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddElementOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testIndexOfOnAddElementOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddElementOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddElementOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddElementOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).indexOf(2);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddElementOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddElementOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddElementOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 2) [] -> add(0,A) -> [A] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAtOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAtOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(2), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddAtOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddAtOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtOneValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddAtOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddAtOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAtOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAtOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAtOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAtOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAtOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAtOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testIndexOfOnAddAtOneValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		Integer i = new Integer(2);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testGetOnAddAtOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).indexOf(2);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAtOne() {
		IndexedListADT<Integer> list = newIndexedListAddAtOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAtOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 3) [A] -> remove(0) -> [] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnRemoveIndexEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveIndexEmpty", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(1), new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveIndexEmptyInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnRemoveIndexEmpty", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnRemoveIndexEmpty", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			list.remove(new Integer(2));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveIndexEmptyInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnRemoveIndexEmpty", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnRemoveIndexEmpty", "No Exception", e.toString());
			return false;
		}
	}

	private boolean testContainsOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveIndexEmptyInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveIndexEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveIndexEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveIndexEmpty", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveIndexEmptyValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveIndexEmptyInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnRemoveIndexEmptyInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveIndexEmpty", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveIndexEmptyValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);

		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveIndexEmptyInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testSetOnRemoveIndexEmptyInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveIndexEmptyInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveIndexEmptyValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveIndexEmptyInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testIndexOfOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveIndexEmpty", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testRemoveIndexOnRemoveIndexEmpty() {
		IndexedListADT<Integer> list = newIndexedListRemoveIndexEmpty();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveIndexEmpty", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 4) [A] -> set(0,B) -> [B] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnSetOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(1), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnSetOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(4), new Integer(1));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnSetOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.removeFirst().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnSetOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.removeLast().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnSetOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnSetOneValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			list.remove(new Integer(1));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnSetOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.first().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnSetOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.last().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnSetOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnSetOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.contains(new Integer(1)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnSetOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnSetOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnSetOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnSetOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnSetOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnSetOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnSetOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnSetOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnSetOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			((ArrayList<Integer>) list).indexOf(1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnSetOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnSetOneValid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnSetOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnSetOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnSetOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnSetOne() {
		IndexedListADT<Integer> list = newIndexedListSetOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnSetOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 7) [A,B] -> remove(0) -> [B] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnRemoveFirstOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(1), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveFirstOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(4), new Integer(1));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnRemoveFirstOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.removeFirst().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnRemoveFirstOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.removeLast().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnRemoveFirstOne", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveFirstOneValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			list.remove(new Integer(1));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnRemoveFirstOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.first().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnRemoveFirstOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.last().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnRemoveFirstOne", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveFirstOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.contains(new Integer(1)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnRemoveFirstOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnRemoveFirstOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnRemoveFirstOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnRemoveFirstOne", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnRemoveFirstOneInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnRemoveFirstOne", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnRemoveFirstOneValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveFirstOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnRemoveFirstOneInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			((ArrayList<Integer>) list).indexOf(1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveFirstOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfOnRemoveFirstOneValid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveFirstOne", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnRemoveFirstOneInvalid() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnRemoveFirstOne", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnRemoveFirstOne() {
		IndexedListADT<Integer> list = newIndexedListRemoveFirstOne();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnRemoveFirstOne", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 5) [A] -> add(0,B) -> [B,A] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAtFirstTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAtFirstTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtFirstTwoValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterSecondOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(3), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtFirstTwoValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtFirstTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.removeFirst().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddAtFirstTwo", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.removeLast().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddAtFirstTwo", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtFirstTwoValid", "no Exception", e.toString());
			return false;
		}
	}

	private boolean testRemoveSecondElementOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtFirstTwoValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtFirstTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.first().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddAtFirstTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.last().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddAtFirstTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtFirstTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsSecondOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtFirstTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtFirstTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAtFirstTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAtFirstTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAtFirstTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAtFirstTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAtFirstTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAtFirstTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetFirstOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAtFirstTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetSecondOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAtFirstTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtFirstTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetFirstOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtFirstTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetSecondOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtFirstTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAtFirstTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfFirstOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtFirstTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfSecondOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtFirstTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtFirstTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAtFirstTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAtFirstTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddAtFirstTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtFirstTwo();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAtFirstTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	// ///////////////////////
	// 6) [A] -> add[1,B) -> [A,B] TODO
	// ///////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddAtSecondTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddAtSecondTwo", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterFirstOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(3), new Integer(2));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtSecondTwoValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAfterSecondOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(3), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtSecondTwoValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).addAfter(new Integer(4), new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddAtSecondTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.removeFirst().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveFirstOnAddAtSecondTwo", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.removeLast().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveLastOnAddAtSecondTwo", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstElementOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.remove(new Integer(2)).equals(new Integer(2)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtSecondTwoValid", "no Exception", e.toString());
			return false;
		}
	}

	private boolean testRemoveSecondElementOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.remove(new Integer(1)).equals(new Integer(1)));
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtSecondTwoValid", "no Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveElementOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			list.remove(new Integer(3));
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testRemoveElementOnAddAtSecondTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testFirstOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.first().equals(new Integer(1)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testFirstOnAddAtSecondTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.last().equals(new Integer(2)));
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testLastOnAddAtSecondTwo", "No Exception", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsFirstOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.contains(new Integer(2)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtSecondTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsSecondOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtSecondTwoValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddAtSecondTwoInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddAtSecondTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddAtSecondTwo", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { // should be false
				return true;
			}
			try {
				it.next(); // NoSuchElementException expected
			} catch (NoSuchElementException e) {
				// iterator() returned an Iterator<Integer>,
				// hasNext() returned false,
				// and next() threw a NoSuchElementException
				return true;
			}
			// next() did not throw an exception
			return false;
		} catch (Exception e) {
			// iterator() returned null or another invalid type
			System.out.printf("%s caught unexpected %s\n", "testIteratorOnAddAtSecondTwo", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean testToStringOnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}

			if (str.length() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// IndexedList METHODS NEW LIST AFTER AddToFront TODO
	/* @return test success */
	private boolean testAddAtIndexOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(1, i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
		return true;
	}

	private boolean testAddAtIndexOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(1);
		try {
			((ArrayList<Integer>) list).add(3, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAtIndexOnAddAtSecondTwoInvalid", "ElementNotFoundException", e.toString());
			return false;
		}
		return false;
	}

	private boolean testAddV2OnAddAtSecondTwo() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).add(i);
		} catch (ElementNotFoundException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddV2OnAddAtSecondTwo", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetFirstOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(0, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAtSecondTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetSecondOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(1, i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSetOnAddAtSecondTwoValid", e.toString());
			return false;
		}
		return true;
	}

	private boolean testSetOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).set(2, i);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtSecondTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testGetFirstOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (((ArrayList<Integer>) list).get(0).equals(new Integer(1)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtSecondTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetSecondOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			return (((ArrayList<Integer>) list).get(1).equals(new Integer(2)));
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testSetOnAddAtSecondTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
	}

	private boolean testGetOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).get(2);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testGetOnAddAtSecondTwoInvalid", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}

	private boolean testIndexOfFirstOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(2);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 1);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtSecondTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfSecondOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(1);
		try {
			return (((ArrayList<Integer>) list).indexOf(i) == 0);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtSecondTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
	}

	private boolean testIndexOfOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		Integer i = new Integer(3);
		try {
			((ArrayList<Integer>) list).indexOf(i);
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testIndexOfOnAddAtSecondTwo", e.toString(), "ElementNotFoundException");
			return false;
		}
		return false;
	}

	private boolean testRemoveIndexOnAddAtSecondTwoValid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).remove(1);
		} catch (IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAtSecondTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return true;
	}

	private boolean testRemoveIndexOnAddAtSecondTwoInvalid() {
		IndexedListADT<Integer> list = newIndexedListAddAtSecondTwo();
		try {
			((ArrayList<Integer>) list).remove(3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s, expected %s \n", "testRemoveIndexOnAddAtSecondTwo", e.toString(), "IndexOutOfBoundsException");
			return false;
		}
		return false;
	}
}// end class UnorderedListTester
