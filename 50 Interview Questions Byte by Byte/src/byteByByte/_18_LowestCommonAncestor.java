package byteByByte;

public class _18_LowestCommonAncestor {

	public static void main(String[] args) {
		LCANode root = new LCANode(1);
		root.left = new LCANode(2);
		root.right = new LCANode(3);
		root.left.left = new LCANode(4);
		root.left.right = new LCANode(5);
		root.left.left.left = new LCANode(13);
		root.left.right.right = new LCANode(6);
		root.left.right.right.left = new LCANode(9);
		root.right.right = new LCANode(7);
		root.right.right.left = new LCANode(8);
		root.right.right.right = new LCANode(10);

		System.out.println("Common Ancestor : "+lowestCommonAncestor(root, new LCANode(9), new LCANode(8)).data);
	}

	private static LCANode lowestCommonAncestor(LCANode root, LCANode node1, LCANode node2) {
		if (root == null) {
			return null;
		}
		if (root.data == node1.data || root.data == node2.data) {
			return root;
		}
		LCANode left = lowestCommonAncestor(root.left, node1, node2);
		LCANode right = lowestCommonAncestor(root.right, node1, node2);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

}

class LCANode {
	int data;
	LCANode left;
	LCANode right;

	public LCANode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
