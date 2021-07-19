package tree;

public class ConvertABinaryTreeToItsMirror {

	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(3);
		root.right=new Node(2);
		root.right.left=new Node(5);
		root.right.right=new Node(4);
		BinaryTree tree=new BinaryTree();
		tree.traverse(root);
		convertToMirrorTree(root);
		System.out.println();
		tree.traverse(root);
	}
	
	private static Node convertToMirrorTree(Node node) {
		if(node==null) {
			return null;
		}
		Node tempLeft=convertToMirrorTree(node.left);
		Node tempRight=convertToMirrorTree(node.right);
		node.left=tempRight;
		node.right=tempLeft;
		return node;
	}
}
