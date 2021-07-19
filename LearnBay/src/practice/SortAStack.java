package practice;

import java.util.ListIterator;
import java.util.Stack;

public class SortAStack {
	
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(10);
		s.push(670);
		s.push(20);
		s.push(90);
		s.push(30);
		s.push(40);
		s.push(60);
		printStack(s);
		//sortStackRecursively(s);
		Stack<Integer> s1=sortStackIterativeWay(s);
		printStack(s1);
	}
	
	private static void printStack(Stack<Integer> s){
		ListIterator<Integer> i=s.listIterator();
		while(i.hasNext()){
			i.next();
		}
		while(i.hasPrevious()){
			System.out.print(i.previous()+" ");
		}
		System.out.println();
	}

	private static void sortStackRecursively(Stack<Integer> s) {
		if(!s.isEmpty()){
			int temp=s.pop();
			sortStackRecursively(s);
			sortedInsert(s,temp);
		}
	}
	
	private static void sortedInsert(Stack<Integer> s,int temp){
		if(s.isEmpty() || s.peek()<temp){
			s.push(temp);
		}
		else{
			int tempvalue=s.pop();
			sortedInsert(s,temp);
			s.push(tempvalue);
		}
	}
	
	private static Stack<Integer> sortStackIterativeWay(Stack<Integer> s){
		Stack<Integer> s1=new Stack<>();
		while(!s.isEmpty()){
			int temp=s.pop();
			if(s1.isEmpty() || s1.peek()<temp){
				s1.push(temp);
			}
			else{
				while(!s1.isEmpty() && s1.peek()>temp){
					s.push(s1.pop());
				}
				s1.push(temp);
			}
		}
		return s1;
	}

}
