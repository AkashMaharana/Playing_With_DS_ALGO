package com.akash.maharana.stackWithArray;

public class Test {
	
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(9);
		s.push(2);
		s.push(8);
		s.push(7);
		s.push(5);
		s.push(3);
		s.push(5);
		System.out.println(s.size());
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.size());
	}

}
