/** Improved KW.CH03.PalindromeFinder class with methods to check whether a string is a palindrome.
 * Modified to use a StackADT implementation, rather than java.util.Stack.
 * @author Koffman & Wolfgang
 * @author mvail and Spring 2013 cs225-4 students
 **/
public class MVPalindromeFinder {

    /** String to store in stack. */
    private String inputString;
    /** Stack to hold characters. */
    private StackADT<Character> charStack = new MinStack<Character>();
    /** Boolean indicating if inputString is a palindrome */
    private boolean isPalindrome;

    /**
     * Store the argument string in a stack of characters.
     * @param str String of characters to store in the stack
     */
    public MVPalindromeFinder(String str) {
        inputString = lettersOnly(str);
        fillStack();
        isPalindrome = inputString.equalsIgnoreCase(buildReverse());
    }

    /** Method to fill a stack of characters from an input string. */
    private void fillStack() {
        for (int i = 0; i < inputString.length(); i++) {
            charStack.push(inputString.charAt(i));
        }
        System.out.println("Stack contents:\n" + charStack.toString());
    }

    /**
     * Method to build a string containing
     * the characters in a stack.
     * @post The stack is empty.
     * @return The string containing the words in the stack
     */
    private String buildReverse() {
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            // Remove top item from stack and append it to result.
            result.append(charStack.pop());
        }
        return result.toString();
    }

    /**
     * @return
     */
    public boolean isPalindrome() {
        return isPalindrome;
    }
    
    /**
     * @param original String possibly containing unwanted characters
     * @return condensed String with only letters
     */
    private String lettersOnly(String original) {
    	StringBuilder condensed = new StringBuilder();
    	for (int i = 0; i < original.length(); i++) {
    		char c = original.charAt(i);
    		if (Character.isLetter(c)) {
    			condensed.append(c);
    		}
    	}
    	return condensed.toString();
    }
}