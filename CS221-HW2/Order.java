import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Takes an array and reorders it so elements are in ascending order.
 * 
 * @author mvail
 */
public class Order {

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * 
	 * @param array
	 *            ints that need to be ordered
	 */
	public static long statements;

	public static void order(int[] array) {
		// T(n)=2n^2+3n+2
		statements = 2;
		try (PrintWriter pw = new PrintWriter("file2.csv")) {
			pw.println("n, statements");
			for (int next = 1; next < array.length; next++) {// 2+n*(3+n(2))
				statements += 2;
				int val = array[next];
				int index = next;
				while (index > 0 && val < array[index - 1]) {
					statements += 2;
					array[index] = array[index - 1];
					index--;
				}
				array[index] = val;
				statements++;
				pw.println(next+", "+ statements);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
