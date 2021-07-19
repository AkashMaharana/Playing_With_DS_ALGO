package date_27_03_2020;

import common.BinaryTreeNode;

public class CreateABalancedBSTFromASortedArray {
	
	public static void main(String[] args) {
		int[] inputArray= {1,4,5,6,9,16,23,56,75,89,91};
		BinaryTreeNode node=createBSTFromSortedArray(inputArray,0,inputArray.length-1);
		BinaryTreeNode.inorderTraversal(node);
	}
	
	private static BinaryTreeNode createBSTFromSortedArray(int[] inputArray,int startIndex,int endIndex) {
		if(startIndex>endIndex) {
			return null;
		}
		int midIndex=startIndex+(endIndex-startIndex)/2;
		BinaryTreeNode node=new BinaryTreeNode(inputArray[midIndex]);
		node.setLeftNode(createBSTFromSortedArray(inputArray, startIndex, midIndex-1));
		node.setRightNode(createBSTFromSortedArray(inputArray, midIndex+1, endIndex));
		return node;
	}

}
