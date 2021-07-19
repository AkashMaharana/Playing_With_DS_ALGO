package com.akash.maharana.designAndImplementation;

public class ImplementTwoStacksInAnArray {

	public static void main(String[] args) {
		ArrayStack as = new ArrayStack(5);
		as.push1(5);
		as.push2(10);
		as.push2(15);
		as.push1(11);
		as.push2(7);
		System.out.println("Popped element from" + " stack1 is " + as.pop1());
		as.push2(40);
		System.out.println("Popped element from" + " stack2 is " + as.pop2());
	}

}

class ArrayStack {
	int firstIndex;
	int endIndex;
	int[] stackArray;

	ArrayStack(int n) {
		firstIndex = -1;
		endIndex = n;
		stackArray = new int[n];
	}

	public void push1(int data) {
		if (firstIndex < endIndex - 1) {
			firstIndex++;
			stackArray[firstIndex] = data;
		} else {
			System.out.println("Stack Overflow");
		}
	}

	public void push2(int data) {
		if (firstIndex < endIndex - 1) {
			endIndex--;
			stackArray[endIndex] = data;
		} else {
			System.out.println("Stack Overflow");
		}
	}

	public int pop1() {
		if (firstIndex >= 0) {
			int popElement = stackArray[firstIndex];
			firstIndex--;
			return popElement;
		} else {
			System.out.println("Strack Underflow");
			return -1;
		}
	}

	public int pop2() {
		if (endIndex < stackArray.length) {
			int popElement = stackArray[endIndex];
			endIndex++;
			return popElement;
		} else {
			System.out.println("Stack Underflow");
			return -1;
		}
	}

}
