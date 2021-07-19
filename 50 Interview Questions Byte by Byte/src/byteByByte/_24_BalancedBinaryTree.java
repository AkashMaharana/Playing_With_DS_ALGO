package byteByByte;

public class _24_BalancedBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1);
		root.left = new BinaryNode(2);
		root.left.left = new BinaryNode(4);
		root.left.left.right = new BinaryNode(5);
		root.right = new BinaryNode(3);
		BinaryNodeImpl binary=new BinaryNodeImpl();
		System.out.println("First Test Case : "+binary.isBalanced(root));
		
		BinaryNode root1=new BinaryNode(1);
		root1.left=new BinaryNode(2);
		root1.left.left=new BinaryNode(4);
		root1.right=new BinaryNode(3);
		System.out.println("Second Test Case : "+binary.isBalanced(root1));
	}

}

class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

class BinaryNodeImpl {
	
	public int getHeight(BinaryNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public boolean isBalanced(BinaryNode node) {
		if (node == null) {
			return true;
		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		return (leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
	}
}
