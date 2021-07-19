package com.akash.maharana.standardProblems;

public class ImplementKStacksInAnArray {

	public static void main(String[] args) {
		KStack ks = new KStack(3, 10);
		ks.push(0, 5);
		ks.push(0, 6);
		ks.push(1, 7);
		ks.push(1, 78);
		ks.push(2, 93);
		ks.pop(0);
		ks.push(2, 8);
		ks.pop(1);
		ks.printArray();
	}

}

class KStack {
	int noOfStack;
	int lengthOfArray;
	int[] stackData;
	int[] nextIndex;
	int[] topIndex;
	int nextAvailableIndex;

	public KStack(int noOfStack, int lengthOfArray) {
		this.noOfStack = noOfStack;
		this.lengthOfArray = lengthOfArray;
		this.topIndex = new int[noOfStack];
		for (int i = 0; i < this.topIndex.length; i++) {
			this.topIndex[i] = -1;
		}
		this.nextIndex = new int[lengthOfArray];
		for (int i = 0; i < this.nextIndex.length - 1; i++) {
			this.nextIndex[i] = i + 1;
		}
		this.nextIndex[this.nextIndex.length - 1] = -1;
		this.stackData = new int[lengthOfArray];
		this.nextAvailableIndex = 0;
	}

	public void push(int stackNumber, int inputNumber) {
		this.stackData[this.nextAvailableIndex] = inputNumber;
		int previousIndex = topIndex[stackNumber];
		topIndex[stackNumber] = nextAvailableIndex;
		int tempIndex = nextIndex[nextAvailableIndex];
		nextIndex[nextAvailableIndex] = previousIndex;
		nextAvailableIndex = tempIndex;
	}

	public int pop(int stackNumber) {
		int currentTop = this.topIndex[stackNumber];
		int popItem = this.stackData[this.topIndex[stackNumber]];
		int nextTop = this.nextIndex[this.topIndex[stackNumber]];
		this.topIndex[stackNumber] = nextTop;
		this.nextIndex[currentTop] = nextAvailableIndex;
		nextAvailableIndex = currentTop;
		return popItem;
	}

	public void printArray() {
		for (int i = 0; i < this.topIndex.length; i++) {
			System.out.print(this.topIndex[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < this.nextIndex.length; i++) {
			System.out.print(this.nextIndex[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < this.stackData.length; i++) {
			System.out.print(this.stackData[i] + " ");
		}
	}
}