package maximumSumIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumIncreasingSubsequence {

	public void maximumIncreasingSubsequence(int[] inputArray) {
		int[] maximumArray = new int[inputArray.length];
		int[] indexArray = new int[inputArray.length];
		int maxIndex = 0;
		int maxValue = 0;
		for (int i = 0; i < inputArray.length; i++) {
			maximumArray[i] = inputArray[i];
		}
		for (int i = 0; i < indexArray.length; i++) {
			indexArray[i] = i;
		}
		for (int i = 1; i < inputArray.length; i++) {
			int tempIndex = 0;
			int maxValueAtIndex = maximumArray[i];
			while (tempIndex < i) {
				if (inputArray[tempIndex] < inputArray[i]) {
					if (maxValueAtIndex < (inputArray[i] + maximumArray[tempIndex])) {
						maxValueAtIndex = inputArray[i] + maximumArray[tempIndex];
						indexArray[i] = tempIndex;
					}
				}
				tempIndex++;
			}
			maximumArray[i] = maxValueAtIndex;
			if (maxValue < maxValueAtIndex) {
				maxValue = maxValueAtIndex;
				maxIndex = i;
			}
		}
		System.out.print("Maximum Array : ");
		for (int i = 0; i < maximumArray.length; i++) {
			System.out.print(maximumArray[i] + " ");
		}
		System.out.println();
		System.out.print("Index Array : ");
		for (int i = 0; i < indexArray.length; i++) {
			System.out.print(indexArray[i] + " ");
		}
		System.out.println();
		showSubsequence(indexArray, inputArray, maxIndex);
	}

	private void showSubsequence(int[] indexArray, int[] inputArray, int maxIndex) {
		List<Integer> list = new ArrayList<>();
		while (maxIndex > 0) {
			list.add(inputArray[maxIndex]);
			maxIndex = indexArray[maxIndex];
		}
		list.add(inputArray[maxIndex]);
		System.out.print("Maximum Subsequence : ");
		for(Integer i : list){
			System.out.print(i+" ");
		}
	}

}
