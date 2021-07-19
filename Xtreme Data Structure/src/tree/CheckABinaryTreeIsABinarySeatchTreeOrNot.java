package tree;

public class CheckABinaryTreeIsABinarySeatchTreeOrNot {
	
	private static Node previous=null;
	
	public static void main(String[] args) {
		Node root=new Node(4);
		root.left=new Node(2);
		root.right=new Node(5);
		root.left.left=new Node(1);
		root.left.right=new Node(3);
		System.out.println(checkForBST(root));
		System.out.println(checkForBSTModified(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	private static boolean checkForBST(Node node) {
		if(node!=null) {
			if(!checkForBST(node.left)) {
				return false;
			}
			if(previous!=null && node.data<previous.data) {
				return false;
			}
			previous=node;
			return checkForBST(node.right);
		}
		return true;
	}
	
	private static boolean checkForBSTModified(Node node,int min,int max) {
		if(node==null) {
			return true;
		}
		if(node.data<min || node.data>max) {
			return false;
		}
		return checkForBSTModified(node.left, min, node.data-1) ||
				checkForBSTModified(node.right, node.data+1, max);
	}

}
