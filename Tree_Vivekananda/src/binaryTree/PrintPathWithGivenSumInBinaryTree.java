package binaryTree;

import java.util.Stack;

public class PrintPathWithGivenSumInBinaryTree {
	
	public static void main(String[] args) {
		
		Node rootNode1=new Node(1);
		rootNode1.setLeftChild(new Node(2));
		rootNode1.setRightChild(new Node(3));
		rootNode1.getLeftChild().setLeftChild(new Node(4));
		rootNode1.getLeftChild().setRightChild(new Node(5));
		rootNode1.getRightChild().setLeftChild(new Node(6));
		rootNode1.getRightChild().setRightChild(new Node(7));
		rootNode1.getRightChild().getLeftChild().setLeftChild(new Node(10));
		rootNode1.getRightChild().getLeftChild().setRightChild(new Node(11));
		rootNode1.getLeftChild().getLeftChild().setLeftChild(new Node(8));
		rootNode1.getLeftChild().getLeftChild().setRightChild(new Node(9));
		rootNode1.getRightChild().getRightChild().setRightChild(new Node(9));
		printPathWithGivenSum(rootNode1,20);
	}

	private static void printPathWithGivenSum(Node rootNode1,int sum) {
		Stack<Integer> s=new Stack<>();
		int tempSum=0;
		printAllPath(rootNode1,s,sum,tempSum);
	}
	
	private static Stack<Integer> printAllPath(Node node,Stack<Integer> s,int sum,int tempSum){
		if(node==null){
			return null;
		}
		if(tempSum!=sum){
			s.push(node.getData());
			tempSum=tempSum+node.getData();
		}
		printAllPath(node.getLeftChild(), s, sum, tempSum);
		printAllPath(node.getRightChild(), s, sum, tempSum);
		if(tempSum!=sum){
			tempSum=tempSum-s.pop();
		}
		else{
			int tempData=s.peek();
			if(!s.isEmpty()){
				s=printStack(s);
				s.pop();
				tempSum=tempSum-tempData;
			}
		}
		return s;
	}
	
	private static Stack<Integer> printStack(Stack<Integer> s){
		Stack<Integer> tempStack=new Stack<>();
		while(!s.isEmpty()){
			System.out.print(s.peek()+" ");
			tempStack.push(s.pop());
		}
		System.out.println();
		while(!tempStack.isEmpty()){
			s.push(tempStack.pop());
		}
		return s;
	}

}
