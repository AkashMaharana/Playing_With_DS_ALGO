package tree;

public class CheckIfATreeIsASubTreeOfAnotherTree {
	
	public static void main(String[] args) {
		Node root=new Node(26);
		root.left=new Node(10);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(6);
		root.left.right.left=new Node(30);
		root.right.right=new Node(3);
		
		Node root1=new Node(10);
		root1.left=new Node(4);
		root1.right=new Node(6);
		root1.right.left=new Node(30);
		
		System.out.println("Check for sub tree : "+checkForSubTree(root,root1));
	}
	
	private static boolean checkForSubTree(Node node,Node node1) {
		if(node==null) {
			return false;
		}
		if(node1==null) {
			return true;
		}
		if(isIdentical(node, node1)) {
			return true;
		}
		return isIdentical(node.left, node1) || isIdentical(node.right, node1);
	}
	
	private static boolean isIdentical(Node node1,Node node2) {
		if(node1==null && node2==null) {
			return true;
		}
		if(node1==null || node2==null) {
			return false;
		}
		return (node1.data==node2.data) && isIdentical(node1.left, node2.left) &&
				isIdentical(node1.right, node2.right);
	}

}
