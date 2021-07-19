package com.akash.maharana;

public class _1_LowestCommonAncestor {
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.setLeft(new BinaryTreeNode(2));
		root.setRight(new BinaryTreeNode(3));
		root.getLeft().setLeft(new BinaryTreeNode(4));
		root.getLeft().setRight(new BinaryTreeNode(5));
		root.getRight().setLeft(new BinaryTreeNode(6));
		root.getRight().setRight(new BinaryTreeNode(7));
		System.out.println("Lowest Common Ancestor : "+lowestCommonAncestor(root,new BinaryTreeNode(5),new BinaryTreeNode(4)).getData());
	}
	
	private static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		if(root==null) {
			return null;
		}
		if(root.getData()==node1.getData() || root.getData()==node2.getData()) {
			return root;
		}
		BinaryTreeNode temp1=lowestCommonAncestor(root.getLeft(), node1, node2);
		BinaryTreeNode temp2=lowestCommonAncestor(root.getRight(), node1, node2);
		if(temp1!=null && temp2!=null) {
			return root;
		}
		if(temp1!=null) {
			return temp1;
		}
		if(temp2!=null) {
			return temp2;
		}
		return null;
	}
	

}