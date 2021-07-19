
import java.util.Stack;

public class StockSpan {
	
	public static void main(String[] args) {
		int[] arr= {100,80,60,70,60,75,85};
		int[] spanArray=new int[arr.length];
		Stack<Integer> tempStack=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if(tempStack.isEmpty()) {
				tempStack.push(i);
				if(i==0) {
					spanArray[i]=1;
				}
				else {
					spanArray[i]=i;
				}
			}
			else {
				while(arr[tempStack.peek()]<arr[i]) {
					tempStack.pop();
				}
				spanArray[i]=i-tempStack.peek();
				tempStack.push(i);
			}
		}
		for(int i=0;i<spanArray.length;i++) {
			System.out.print(spanArray[i]+" ");
		}
	}

}
