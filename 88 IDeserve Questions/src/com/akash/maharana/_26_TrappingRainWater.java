package com.akash.maharana;

public class _26_TrappingRainWater {

	public static void main(String[] args) {
		int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//int[] input1 = { 0, 1, 2, 0, 0, 3, 1, 0, 3 };
		System.out.println(trappedWaterAmount(input));
	}

	private static int trappedWaterAmount(int[] input) {
		int[] leftMaximum = new int[input.length];
		int[] rightMaximum = new int[input.length];
		int leftMax = input[0];
		int rightMax = input[input.length - 1];
		leftMaximum[0] = input[0];
		rightMaximum[input.length - 1] = input[input.length - 1];
		for (int i = 1; i < input.length; i++) {
			if (input[i] > leftMax) {
				leftMax = input[i];
				leftMaximum[i] = leftMax;
			} else {
				leftMaximum[i] = leftMax;
			}
		}
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] > rightMax) {
				rightMax = input[i];
				rightMaximum[i] = rightMax;
			} else {
				rightMaximum[i] = rightMax;
			}
		}
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			result = result + Math.min(leftMaximum[i], rightMaximum[i]) - input[i];
		}
		return result;
	}

}
