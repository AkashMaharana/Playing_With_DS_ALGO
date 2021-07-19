package common;

public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;

	public BinaryTreeNode(int data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public static void inorderTraversal(BinaryTreeNode node) {
		if(node.getLeftNode()!=null) {
			BinaryTreeNode.inorderTraversal(node.getLeftNode());
		}
		System.out.print(node.getData()+" ");
		if(node.getRightNode()!=null) {
			BinaryTreeNode.inorderTraversal(node.getRightNode());
		}
	}

}
