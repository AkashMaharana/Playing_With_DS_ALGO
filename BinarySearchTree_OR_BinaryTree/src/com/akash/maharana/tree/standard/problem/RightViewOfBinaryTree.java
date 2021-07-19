package com.akash.maharana.tree.standard.problem;

public class RightViewOfBinaryTree {
	
	static int maxLevel=0;
	
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
		rootNode.getLeftChild().getLeftChild().getLeftChild().getLeftChild().setRightChild(new Node(90));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		rightViewOfBinaryTree(rootNode);
	}
	
	private static void rightViewOfBinaryTree(Node node){
		if(node==null){
			return;
		}
		rightView(node,1);
	}
	
	private static void rightView(Node node,int level){
		if(node==null){
			return;
		}
		if(maxLevel<level){
			System.out.println(node.getData());
			maxLevel=level;
		}
		rightView(node.getRightChild(), level+1);
		rightView(node.getLeftChild(), level+1);
	}

}
