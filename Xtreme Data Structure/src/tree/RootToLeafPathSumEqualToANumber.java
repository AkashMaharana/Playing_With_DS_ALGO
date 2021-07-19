package tree;

public class RootToLeafPathSumEqualToANumber {
	
	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(8);
		root.right=new Node(2);
		root.left.left=new Node(3);
		root.left.right=new Node(5);
		root.right.left=new Node(2);
		System.out.println(checkRootToLeafSum(root,25));
	}
	
	private static boolean checkRootToLeafSum(Node node,int sum) {
		if(node==null) {
			return sum==0;
		}
		return checkRootToLeafSum(node.left,sum-node.data) ||
				checkRootToLeafSum(node.right,sum-node.data);
	}

}
