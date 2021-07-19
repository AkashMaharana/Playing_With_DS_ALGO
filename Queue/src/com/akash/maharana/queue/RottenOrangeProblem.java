package com.akash.maharana.queue;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangeProblem {

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, 
						{ 1, 0, 1, 2, 1 }, 
						{ 1, 0, 0, 2, 1 } };
		int minimumDays = 0;
		int noOfDays = daysRequiredToRottenAllOranges(arr, minimumDays);
		if (noOfDays == 0) {
			System.out.println("All oranges can't rot");
		} else {
			System.out.println("Days required to rot all oranges : " + noOfDays);
		}
	}

	private static int daysRequiredToRottenAllOranges(int[][] arr, int minimumDays) {
		Queue<Orange> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					addToTheRottenQueue(i, j, arr, q);
				} else {
					continue;
				}
			}
		}
		if (q.isEmpty()) {
			return minimumDays;
		} else {
			while (!q.isEmpty()) {
				arr[q.peek().i][q.peek().j] = 2;
				q.remove();
			}
			minimumDays=minimumDays+1;;
			return daysRequiredToRottenAllOranges(arr, minimumDays);
		}
	}

	private static void addToTheRottenQueue(int i, int j, int[][] arr, Queue<Orange> q) {
		if (i - 1 >= 0 && arr[i - 1][j] == 1) {
			q.add(new Orange(i - 1, j));
		}
		if (i + 1 < arr.length && arr[i + 1][j] == 1) {
			q.add(new Orange(i + 1, j));
		}
		if (j - 1 >= 0 && arr[i][j - 1] == 1) {
			q.add(new Orange(i, j - 1));
		}
		if (j + 1 < arr[0].length && arr[i][j + 1] == 1) {
			q.add(new Orange(i, j + 1));
		}
	}

}

class Orange {
	int i;
	int j;

	Orange(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
