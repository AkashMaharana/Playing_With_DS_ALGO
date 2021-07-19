package byteByByte;

import java.util.Stack;

public class StockSpanProblem {
	
	public static void main(String[] args) {
		int input[] = { 10, 4, 5, 90, 120, 80 };
		printSpanOfStocks(input);
	}
	
	private static void printSpanOfStocks(int[] input) {
		Stack<Integer> inputStack=new Stack<>();
		int[] span=new int[input.length];
		for(int i=0;i<input.length;i++) {
			while(!inputStack.isEmpty() && input[inputStack.peek()]<=input[i]) {
				inputStack.pop();
			}
			if(inputStack.isEmpty()) {
				span[i]=i+1;
				inputStack.push(i);
			}
			else {
				span[i]=i-inputStack.peek();
				inputStack.push(i);
			}
		}
		for(int i=0;i<span.length;i++) {
			System.out.print(span[i]+" ");
		}
	}

}
