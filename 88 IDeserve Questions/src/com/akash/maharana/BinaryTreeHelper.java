package com.akash.maharana; 

public class BinaryTreeHelper {
	
	public static void traverseTree(BinaryTreeNode node) {
		if(node.getLeft()!=null) {
			traverseTree(node.getLeft());
		}
		System.out.print(node.getData()+" ");
		if(node.getRight()!=null) {
			traverseTree(node.getRight());
		}
	}

}
