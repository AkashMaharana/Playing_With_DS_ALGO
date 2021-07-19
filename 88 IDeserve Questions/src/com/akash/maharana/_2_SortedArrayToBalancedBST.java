package com.akash.maharana;

public class _2_SortedArrayToBalancedBST {
	
	public static void main(String[] args) {
		int[] input= {1,2,3,4,5,6,7,8,9};
		BinaryTreeNode node=sortedArrayToBST(input,0,input.length-1);
		BinaryTreeHelper.traverseTree(node);
		System.out.println();
	}
	
	private static BinaryTreeNode sortedArrayToBST(int[] input,int start,int end) {
		if(start>end) {
			return null;
		}
		int mid=(start+end)/2;
		BinaryTreeNode newNode=new BinaryTreeNode(input[mid]);
		newNode.setLeft(sortedArrayToBST(input, start, mid-1));
		newNode.setRight(sortedArrayToBST(input, mid+1, end));
		return newNode;
	}

}
