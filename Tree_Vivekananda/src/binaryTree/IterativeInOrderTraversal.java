package binaryTree;

import java.util.Stack;

public class IterativeInOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(8));
		rootNode.setRightChild(new Node(5));
		rootNode.getLeftChild().setLeftChild(new Node(90));
		rootNode.getLeftChild().setRightChild(new Node(56));
		rootNode.getRightChild().setLeftChild(new Node(23));
		rootNode.getRightChild().setRightChild(new Node(19));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(89));
		inOrderTraversalIterative(rootNode);
		System.out.println();
		inOrderTraversalRecursive(rootNode);
	}
	
	private static void inOrderTraversalIterative(Node node){
		if(node==null){
			return;
		}
		Stack<Node> s=new Stack<>();
		while(true){
			while(node!=null){
				s.push(node);
				node=node.getLeftChild();
			}
			if(s.isEmpty()){
				break;
			}
			Node tempNode=s.pop();
			System.out.print(tempNode.getData()+" ");
			node=tempNode.getRightChild();
		}
	}
	
	private static void inOrderTraversalRecursive(Node node){
		if(node.getLeftChild()!=null){
			inOrderTraversalRecursive(node.getLeftChild());
		}
		System.out.print(node.getData()+" ");
		if(node.getRightChild()!=null){
			inOrderTraversalRecursive(node.getRightChild());
		}
	}

}
