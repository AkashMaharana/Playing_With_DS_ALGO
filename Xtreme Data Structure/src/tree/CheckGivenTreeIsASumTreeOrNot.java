package tree;

public class CheckGivenTreeIsASumTreeOrNot {
	
	public static void main(String[] args) {
		Node root=new Node(26);
		root.left=new Node(10);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(6);
		root.right.left=new Node(1);
		root.right.right=new Node(2);
		System.out.println(isSumTree(root));
	}
	
	private static boolean isSumTree(Node node) {
		if(node==null) {
			return true;
		}
		if(node.left==null && node.right==null) {
			return true;
		}
		int leftSum=getSum(node.left);
		int rightSum=getSum(node.right);
		if(leftSum+rightSum==node.data) {
			return isSumTree(node.left) && isSumTree(node.right);
		}
		else {
			return false;
		}
	}
	
	private static int getSum(Node node) {
		if(node==null) {
			return 0;
		}
		return node.data+getSum(node.left)+getSum(node.right);
	}

}
