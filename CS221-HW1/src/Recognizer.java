//	Recognizer.java

import java.io.*;
import java.text.ParseException;

/**
 * Description:
 * 
 * @author Teresa Cole
 * @version CS354
 */
public class Recognizer {
	private StringReader reader;
	private char lookahead;
	private boolean eof = false;
	public int index = 0;

	/**
	 * Main entry point
	 */
	public static void main(String[] args) {
		System.out.println();
		System.out.println("Recursive Descent Parsing ");

		Recognizer recog = new Recognizer(
				new StringReader("[(x),[z,(([z,y]))]"));
		recog.recognize();

	}

	public Recognizer(StringReader in) {
		reader = in;
	}

	public void recognize() {
		try {
			next();
			pop();
			System.out.println("Valid Sentence");
		} catch (ParseException pe) {
			System.out.println("Invalid Sentence");
			System.out.println(pe.getMessage());
		}

		System.out.println();
	}

	public void pop() throws ParseException {
		if (lookahead == '[') {
			next();
			bop();
			match(',');
			pop();
			match(']');
		} else
			bop();
	}

	public void bop() throws ParseException {
		if (lookahead == '(') {
			next();
			pop();
			match(')');
		} else
			boop();
	}

	public void boop() throws ParseException {
		if ("xyz".indexOf(lookahead) == -1)
			throw new ParseException("Expected x or y or z, not " + lookahead,
					index);
		else
			next();
	}

	public char next() {
		char current = lookahead;
		int nextChar = 0;
		try {
			do {
				nextChar = reader.read();
				if (nextChar != -1)
					lookahead = (char) nextChar;
				else
					eof = true;
				index++;
			} while (Character.isWhitespace(lookahead) && !eof);
		} catch (IOException e) {
			System.exit(1);
		}

		return current;
	}

	public void match(char ch) throws ParseException {
		if (lookahead != ch)
			throw new ParseException(ch + " not found", index);
		next();
	}

}
