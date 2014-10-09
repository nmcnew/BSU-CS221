import java.io.FileWriter;

public class FindTest {

	/**
	 * Get an array of specified size and find the indexes of all elements in
	 * the array using Find.find().
	 * 
	 * @param args
	 *            size of array to generate or file containing ints
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage:  java FindTest sizeOfArray\n"
					+ "\tor\n\tjava FindTest arrayFile");
			System.exit(1);
		}

		// create or read the int[]
		int size = 0;
		int[] array = new int[0];
		try {
			size = Integer.parseInt(args[0]);
			array = ArrayOfInts.randomizedArray(size);
		} catch (NumberFormatException nfe) {
			try {
				array = ArrayOfInts.arrayFromFile(args[0]);
				size = array.length;
			} catch (Exception e) {
				System.err.println("unable to read array from " + args[0]);
				System.exit(1);
			}
		}

		int k = 0;
		int total =0;
		int amt = 0;

		try {
			FileWriter writer = new FileWriter("find.csv");
			writer.append("n, statements\n");
			for (int i = 1; i <= array.length; i++) {

				total += k = Find.find(array, i);
				amt = i;
				writer.append(i + ", " + total + "\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(total / amt + " statements per ");
	}
}
