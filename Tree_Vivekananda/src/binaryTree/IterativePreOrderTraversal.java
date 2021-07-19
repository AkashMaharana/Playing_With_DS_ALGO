package binaryTree;

import java.util.Stack;

public class IterativePreOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(8));
		rootNode.setRightChild(new Node(5));
		rootNode.getLeftChild().setLeftChild(new Node(90));
		rootNode.getLeftChild().setRightChild(new Node(56));
		rootNode.getRightChild().setLeftChild(new Node(23));
		rootNode.getRightChild().setRightChild(new Node(19));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(89));
		preOrderTraversalIterative(rootNode);
		System.out.println();
		preOrderTraversalRecursive(rootNode);
	}
	
	private static void preOrderTraversalIterative(Node node){
		if(node==null){
			return;
		}
		Stack<Node> s=new Stack<>();
		while(true){
			while(node!=null){
				System.out.print(node.getData()+" ");
				s.push(node);
				node=node.getLeftChild();
			}
			if(s.isEmpty()){
				break;
			}
			node=s.pop();
			node=node.getRightChild();
		}
		
	}
	
	private static void preOrderTraversalRecursive(Node node){
		if(node==null){
			return;
		}
		System.out.print(node.getData()+" ");
		if(node.getLeftChild()!=null){
			preOrderTraversalRecursive(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			preOrderTraversalRecursive(node.getRightChild());
		}
	}

}
