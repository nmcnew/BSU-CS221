/**
 * Exercise the MVPalindromeFinder class
 * Only considers letters - numbers, whitespace, and punctuation will be ignored.
 * @author mvail
 */
public class TestMVPalindromeFinder {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		String palindrome1 = "kayak";
		String palindrome2 = "I saw I was I";
		String palindrome3 = "Racecar";
		String palindrome4 = "Go hang a salami, I'm a lasagna hog.";
		String notAPalindrome1 = "abracadabra";
		String emptyString = "";
		boolean result;
		boolean expected;

		System.out.println("Testing MVPalindromeFinder");
		System.out.println();
		
		MVPalindromeFinder pf1 = new MVPalindromeFinder(palindrome1);
		validateIsPalindrome(pf1, palindrome1, true); //could replace all following tests as well		
		
		MVPalindromeFinder pf2 = new MVPalindromeFinder(palindrome2);
		expected = true;
		result = pf2.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome2, expected, result, (expected==result?"PASS":"***FAIL***"));

		MVPalindromeFinder pf3 = new MVPalindromeFinder(palindrome3);
		expected = true;
		result = pf3.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome3, expected, result, (expected==result?"PASS":"***FAIL***"));

		MVPalindromeFinder pf4 = new MVPalindromeFinder(palindrome4);
		expected = true;
		result = pf4.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome4, expected, result, (expected==result?"PASS":"***FAIL***"));

		MVPalindromeFinder pf5 = new MVPalindromeFinder(notAPalindrome1);
		expected = false;
		result = pf5.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				notAPalindrome1, expected, result, (expected==result?"PASS":"***FAIL***"));
		
		MVPalindromeFinder pf6 = new MVPalindromeFinder(emptyString);
		expected = true;
		result = pf6.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				emptyString, expected, result, (expected==result?"PASS":"***FAIL***"));

		System.out.println();
		System.out.println("What if I repeat the above tests without recreating the corresponding MVPalindromeFinder objects?");
		System.out.println();
		
		expected = true;
		result = pf1.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome1, expected, result, (expected==result?"PASS":"***FAIL***"));

		expected = true;
		result = pf2.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome2, expected, result, (expected==result?"PASS":"***FAIL***"));

		expected = true;
		result = pf3.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome3, expected, result, (expected==result?"PASS":"***FAIL***"));

		expected = true;
		result = pf4.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				palindrome4, expected, result, (expected==result?"PASS":"***FAIL***"));

		expected = false;
		result = pf5.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				notAPalindrome1, expected, result, (expected==result?"PASS":"***FAIL***"));
		
		expected = true;
		result = pf6.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				emptyString, expected, result, (expected==result?"PASS":"***FAIL***"));
	}
	
	/**
	 * @param mvp object to test
	 * @param originalString String being tested
	 * @param expected boolean result
	 */
	private static void validateIsPalindrome(MVPalindromeFinder mvp, String originalString, boolean expected) {
		boolean result = mvp.isPalindrome();
		System.out.printf("Testing isPalindrome(\"%s\"): expected = %b, result = %b\t%s\n",
				originalString, expected, result, (expected==result?"PASS":"***FAIL***"));		
	}
}