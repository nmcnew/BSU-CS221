/**
 * Returns index of a value in an int[] or -1 if it isn't found.
 * @author mvail
 */
public class Find {

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static int find(int[] array, int value) {
		//T(n) = 2n + 2 
		int statements = 2;
		for (int i = 0; i < array.length; i++) {//2 + n(1 + 1)
			statements++;
			if (array[i] == value) {//1
				statements++;
				break;
			}
		}
		return statements;
	}
}
