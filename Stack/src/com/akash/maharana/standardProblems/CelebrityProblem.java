package com.akash.maharana.standardProblems;

import java.util.Stack;

//https://www.geeksforgeeks.org/the-celebrity-problem/

public class CelebrityProblem {

	public static void main(String[] args) {
		int n = 4;
		int[][] inputMatrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		int result = findCelebrity(n, inputMatrix);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else {
			System.out.println("Celebrity ID " + result);
		}
	}

	private static int findCelebrity(int n,int[][] inputMatrix) {
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<n;i++){
			s.push(i);
		}
		while(s.size()>1){
			int firstCelebrity=s.pop();
			int secondCelebrity=s.pop();
			if(celebrityKnowsEachOther(firstCelebrity,secondCelebrity,inputMatrix)){
				s.push(secondCelebrity);
			}
			else{
				s.push(firstCelebrity);
			}
		}
		int lastCelebrity=s.pop();
		for(int i=0;i<n;i++){
			if(i!=lastCelebrity && (celebrityKnowsEachOther(lastCelebrity, i, inputMatrix) || 
					!celebrityKnowsEachOther(i,lastCelebrity,inputMatrix))){
				return -1;
			}
		}
		return lastCelebrity;
	}

	private static boolean celebrityKnowsEachOther(int firstCelebrity, int secondCelebrity, int[][] inputMatrix) {
		if (inputMatrix[firstCelebrity][secondCelebrity] == 1) {
			return true;
		} else {
			return false;
		}
	}

}
