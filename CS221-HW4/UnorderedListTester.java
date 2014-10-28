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
 * @author mvail: testing framework and empty list scenario
 */
public class UnorderedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/**
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		UnorderedListTester tester = new UnorderedListTester();
		tester.runTests();
	}

	/**
	 * Returns an UnorderedListADT so the implementation can be changed in this
	 * one location rather than in every test.
	 * 
	 * @return a new UnorderedListADT
	 */
	private UnorderedListADT<Integer> newList() {
		// TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new GoodUnorderedList<Integer>();
		// return new BadUnorderedList<Integer>();
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
		UnorderedListADT<Integer> someList = newList();
		someList.addToFront(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListOneElement() {
		UnorderedListADT<Integer> someList = newList();
		someList.addToFront(new Integer(1));
		return someList;
	}

	private UnorderedListADT<Integer> newListAddToRearTwoElement() {
		UnorderedListADT<Integer> someList = newListAddToFrontOne();
		someList.addToRear(new Integer(2));
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
	 * Run tests to confirm required functionality from list constructors and
	 * methods
	 */
	private void runTests() {
		// TESTS ON A NEW, EMPTY LIST
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
		// TESTS ON AN EMPTY LIST THAT HAD REMOVE(integer) CALLED
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
		// TESTS ON A ONE-ELEMENT LIST THAT HAD REMOVE() CALLED TODO
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

		// ///////////////
		// final verdict
		// ///////////////
		printFinalSummary();
	}

	// //////////////////////////
	// SCENARIO: NEW, EMPTY LIST TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnNewList", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
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

	// //////////////////////////
	// SCENARIO: One-Element, addAfter() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToFrontOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
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

	// //////////////////////////
	// SCENARIO: One-Element, addToRear() TODO
	// //////////////////////////

	/** @return test success */
	private boolean testAddToFrontOnAddToRearOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(new Integer(1));
			list.addToFront(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToFrontOnAddToRearOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnAddToRearOne() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(new Integer(1));
			list.addToRear(i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testAddToRearOnAddToRearOne", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearOneValid() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
			list.addAfter(new Integer(2), new Integer(1));
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n", "testAddAfterOnAddToRearOneValid", "No Exception", e.toString());
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnAddToRearOneInvalid() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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
		UnorderedListADT<Integer> list = newListAddToFrontOne();
		try {
			return (list.contains(new Integer(1)) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearOneValid", e.toString());
			return false;
		}
	}

	private boolean testContainsOnAddToRearOneInvalid() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
			return (list.contains(new Integer(2)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testContainsOnAddToRearOneInvalid", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnAddToRearOne() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testIsEmptyOnAddToRearOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnAddToRearOne() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testSizeOnAddToRearOne", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnAddToRearOne() {
		UnorderedListADT<Integer> list = newList();
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
		UnorderedListADT<Integer> list = newList();
		try {
			list.addToRear(new Integer(1));
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

	// ///////////////////////////
	// SCENARIO: Three-Element, after addAfter() first Element TODO
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

}// end class UnorderedListTester
