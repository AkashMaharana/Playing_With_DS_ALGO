package tree;

public class BinaryTree {
	
	public void traverse(Node node) {
		if(node.left!=null) {
			traverse(node.left);
		}
		System.out.print(node.data+" ");
		if(node.right!=null) {
			traverse(node.right);
		}
	}

}

class Node {

	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
