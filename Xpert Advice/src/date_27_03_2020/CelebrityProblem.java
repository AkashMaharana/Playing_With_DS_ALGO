package date_27_03_2020;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {

		int[][] inputArray = { { 0, 0, 1, 0 }, 
							   { 0, 0, 1, 0 }, 
							   { 0, 0, 0, 0 }, 
							   { 0, 0, 1, 0 } };
		System.out.println(findTheCelebrity(inputArray));
	}
	
	private static int findTheCelebrity(int[][] inputArray) {
		Stack<Integer> temp=new Stack<>();
		for(int i=1;i<=inputArray.length;i++) {
			temp.push(i);
		}
		while(temp.size()>1) {
			int first=temp.pop();
			int second=temp.pop();
			if(haveAcquaintance(first,second,inputArray)) {
				temp.push(second);
			}
			else {
				temp.push(first);
			}
		}
		int lastPerson=temp.pop();
		for(int i=1;i<=inputArray.length;i++) {
			if(i!=lastPerson && (haveAcquaintance(i, lastPerson, inputArray) && 
					haveAcquaintance(lastPerson, i, inputArray))) {
				return -1;
			}
		}
		return lastPerson;
	}
	
	private static boolean haveAcquaintance(int first,int second,int[][] inputArray) {
		return inputArray[first-1][second-1]==1;
	}

}
