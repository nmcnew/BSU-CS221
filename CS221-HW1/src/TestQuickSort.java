import java.util.Arrays;

public class TestQuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer numbers[] = { 83, 86, 77, 15, 93, 35, 86, 92, 49, 21, 62, 27,
				90, 59, 63, 26, 40, 26, 72, 36, 11, 68, 67, 29, 82, 30, 62, 23,
				67, 35, 29, 2, 22, 58, 69, 67, 93, 56, 11, 42, 29, 73, 21, 19,
				84, 37, 98, 24, 15, 70 };

		QuickSort.sort(numbers);

		System.out.println(Arrays.toString(numbers));
	}

}
