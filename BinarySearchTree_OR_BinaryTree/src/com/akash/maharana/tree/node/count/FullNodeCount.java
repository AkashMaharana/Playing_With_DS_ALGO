package com.akash.maharana.tree.node.count;

public class FullNodeCount {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		System.out.println(fullNodeCount(rootNode));
	}
	
	private static int fullNodeCount(Node node){
		if(node==null){
			return 0;
		}
		int result=0;
		if(node.getLeftChild()!=null && node.getRightChild()!=null){
			result=result+1;
		}
		result=result+fullNodeCount(node.getLeftChild())+fullNodeCount(node.getRightChild());
		return result;
	}

}
