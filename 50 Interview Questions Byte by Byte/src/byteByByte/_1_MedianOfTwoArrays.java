package byteByByte;

public class _1_MedianOfTwoArrays {
	
	/*Find the median of two sorted arrays.*/

	public static void main(String[] args) {
		int[] a = { -5, 3, 6, 12, 15 };
		int[] b = { -12, -10, -6, -3, 4, 10 };

		System.out.println(medianOfTwoArrays(a, b, 0, a.length - 1, 0, b.length - 1));
	}

	private static double medianOfTwoArrays(int[] a, int[] b, int start_a, int end_a, int start_b, int end_b) {
		if ((end_a - start_a < 0) || (end_b - start_b < 0)) {
			System.out.println("Invalid Input");
			return -1;
		}
		
		if ((end_a - start_a == 0) && (end_b - start_b == 0)) {
			return (a[0] + b[0]) / 2;
		}
		
		if ((end_a - start_a == 1) && (end_b - start_b == 1)) {
			return (Math.max(a[start_a], b[start_b]) + Math.min(a[end_a], b[end_b])) / 2;
		}
		
		double median1 = findMedian(a, start_a, end_a);
		double median2 = findMedian(b, start_b, end_b);
		if (median1 == median2) {
			return median1;
		}
		
		if (median1 < median2) {
			if ((end_a - start_a) % 2 == 0) {
				start_a = start_a + (end_a - start_a) / 2;
				end_b = start_b + (end_b - start_b) / 2;
			} else {
				start_a = start_a + (end_a - start_a) / 2;
				end_b = start_b + (end_b - start_b) / 2 + 1;
			}
		} 
		
		else {
			if ((end_b - start_b) % 2 == 0) {
				start_b = start_b + (end_b - start_b) / 2;
				end_a = start_a + (end_a - start_a) / 2;
			} else {
				start_b = start_b + (end_b - start_b) / 2;
				end_a = start_a + (end_a - start_a) / 2 + 1;
			}
		}

		return medianOfTwoArrays(a, b, start_a, end_a, start_b, end_b);
	}

	private static double findMedian(int[] array, int startIndex, int endIndex) {
		int indexDiff = (endIndex - startIndex);
		if (indexDiff % 2 == 0) {
			return array[startIndex + (indexDiff / 2)];
		} else {
			return 1.0 * (array[startIndex + (indexDiff / 2)] + array[startIndex + (indexDiff / 2) + 1]) / 2;
		}
	}

}
