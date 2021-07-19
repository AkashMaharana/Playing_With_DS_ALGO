package com.akash.maharana.standardProblems;

import java.util.Stack;

public class LargestRectangularAreaOfHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
	
	private static int getMaxArea(int[] hist, int length){
		Stack<Integer> s=new Stack<>();
		int i=0;
		int maxArea=0;
		int top=0;
		int areaWithTop=0;
		while(i<length){
			if(s.isEmpty() || hist[s.peek()]<hist[i]){
				s.push(i++);
			}
			else{
				top=s.peek();
				s.pop();
				if(s.isEmpty()){
					areaWithTop=hist[top]*i;
				}
				else{
					areaWithTop=(i-s.peek()-1)*hist[top];
				}
			}
			if(maxArea<areaWithTop){
				maxArea=areaWithTop;
			}
		}
		while(!s.isEmpty()){
			top=s.peek();
			s.pop();
			if(s.isEmpty()){
				areaWithTop=hist[top]*i;
			}
			else{
				areaWithTop=(i-s.peek()-1)*hist[top];
			}
			if(maxArea<areaWithTop){
				maxArea=areaWithTop;
			}
		}
		return maxArea;
	}

}
