package com.akash.maharana;

public class _7_PrintMatrixDiagonally {
	
	public static void main(String[] args) {
		int[][] input= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		printMatrixDiagonally(input);
	}
	
	private static void printMatrixDiagonally(int[][] input) {
		int i=0;
		while(i<input.length) {
			int columnCount=0;
			int rowCount=i;
			while(rowCount>=0 && columnCount<=i) {
				System.out.print(input[rowCount][columnCount]+" ");
				rowCount--;
				columnCount++;
			}
			System.out.println();
			i++;
		}
		i=1;
		while(i<input[0].length) {
			int rowCount=input.length-1;
			int columnCount=i;
			while(rowCount>=0 && columnCount<=input[0].length-1) {
				System.out.print(input[rowCount][columnCount]+" ");
				rowCount--;
				columnCount++;
			}
			System.out.println();
			i++;
		}
	}

}
