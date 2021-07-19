package tree;

public class BoundaryTraversalOfABinaryTree {
	
	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.right=new Node(22);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		root.right.right=new Node(25);
		printBoundaryTraversal(root);
	}
	
	private static void printBoundaryTraversal(Node node) {
		System.out.print(node.data+" ");
		printLeftBoundary(node.left);
		printLeafNodes(node);
		printRightBoundary(node.right);
	}
	
	private static void printLeftBoundary(Node node) {
		if(node.left==null) {
			return;
		}
		System.out.print(node.data+" ");
		printLeftBoundary(node.left);
	}
	
	private static void printLeafNodes(Node node) {
		if(node==null) {
			return;
		}
		if(node.left==null && node.right==null) {
			System.out.print(node.data+" ");
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}
	
	private static void printRightBoundary(Node node) {
		if(node.right==null) {
			return;
		}
		printRightBoundary(node.right);
		System.out.print(node.data+" ");
	}

}
