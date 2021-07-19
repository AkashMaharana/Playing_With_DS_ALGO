package byteByByte;

public class _25_BinarySearchTreeVerification {

	static BSTNode previous;

	static class BSTNode {
		int data;
		BSTNode left;
		BSTNode right;

		public BSTNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static boolean isBST(BSTNode node) {
		return bstUtil(node);
	}

	static boolean bstUtil(BSTNode node) {
		if (node != null) {
			if (!bstUtil(node.left)) {
				return false;
			}
			if (previous != null && node.data <= previous.data) {
				return false;
			}
			previous = node;
			return bstUtil(node.right);
		}
		return true;
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(3);
		root.left = new BSTNode(2);
		root.right = new BSTNode(5);
		root.left.left = new BSTNode(1);
		root.left.right = new BSTNode(4);
		System.out.println("Check BST : "+isBST(root));
	}

}
