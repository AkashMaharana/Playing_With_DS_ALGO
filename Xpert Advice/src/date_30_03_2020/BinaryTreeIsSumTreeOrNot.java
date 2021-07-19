package date_30_03_2020;

import common.BinaryTreeNode;

public class BinaryTreeIsSumTreeOrNot {
	
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(26);
		root.setLeftNode(new BinaryTreeNode(10));
		root.setRightNode(new BinaryTreeNode(3));
		root.getLeftNode().setLeftNode(new BinaryTreeNode(4));
		root.getLeftNode().setRightNode(new BinaryTreeNode(6));
		root.getRightNode().setRightNode(new BinaryTreeNode(3));
		System.out.println(checkSumTreeOrNot(root));
	}
	
	private static boolean checkSumTreeOrNot(BinaryTreeNode node) {
		if(node==null) {
			return true;
		}
		if(node.getLeftNode()==null && node.getRightNode()==null) {
			return true;
		}
		int leftSum=addValueToNodes(node.getLeftNode());
		int rightSum=addValueToNodes(node.getRightNode());
		if(leftSum+rightSum==node.getData()) {
			if(checkSumTreeOrNot(node.getLeftNode()) && checkSumTreeOrNot(node.getRightNode())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private static int addValueToNodes(BinaryTreeNode node){
		if(node==null) {
			return 0;
		}
		return addValueToNodes(node.getLeftNode())+node.getData()+addValueToNodes(node.getRightNode());
		
	}

}
