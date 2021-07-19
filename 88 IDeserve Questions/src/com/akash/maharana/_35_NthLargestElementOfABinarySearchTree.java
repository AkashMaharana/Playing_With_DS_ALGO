package com.akash.maharana;

public class _35_NthLargestElementOfABinarySearchTree {
	
	private static int occurence=0;
	private static BinaryTreeNode nthLargestNode=null;
	
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(20);
		root.setLeft(new BinaryTreeNode(8));
		root.setRight(new BinaryTreeNode(22));
		root.getLeft().setLeft(new BinaryTreeNode(4));
		root.getLeft().setRight(new BinaryTreeNode(12));
		root.getLeft().getRight().setLeft(new BinaryTreeNode(10));
		root.getLeft().getRight().setRight(new BinaryTreeNode(14));
		System.out.println("Nth Largest Node of BST : "+nthLargestNode(root,4).getData());
	}
	
	private static BinaryTreeNode nthLargestNode(BinaryTreeNode node,int inputNumber) {
		if(node==null) {
			return null;
		}
		nthLargestNode=nthLargestNode(node.getRight(),inputNumber);
		if(nthLargestNode==null) {
			occurence=occurence+1;
			if(occurence==inputNumber) {
				nthLargestNode=node;
			}
		}
		if(nthLargestNode==null) {
			nthLargestNode(node.getLeft(), inputNumber);
		}
		return nthLargestNode;
	}

}
