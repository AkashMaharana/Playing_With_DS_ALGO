package binaryTree;

import java.util.Stack;

public class PrintRootToLeafPathOfABinaryTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(8));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(9));
		rootNode.getLeftChild().getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		Stack<Integer> s=new Stack<>();
		printRootToLeaf(rootNode,s);
	}
	
	private static void printRootToLeaf(Node node,Stack<Integer> s){
		if(node==null){
			return;
		}
		s.push(node.getData());
		printRootToLeaf(node.getLeftChild(),s);
		if(node.getLeftChild()==null && node.getRightChild()==null){
			Stack<Integer> tempStack=new Stack<>();
			tempStack.addAll(s);
			printStack(tempStack);
		}
		printRootToLeaf(node.getRightChild(),s);
		s.pop();
	}
	
	private static void printStack(Stack<Integer> s){
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
		System.out.println();
	}

}
