
public class LongestConsecutiveBranch {
	
	public static void main(String[] args) {
		TreeNode root1=new TreeNode(0);
		root1.left=new TreeNode(1);
		root1.left.left=new TreeNode(1);
		root1.left.right=new TreeNode(2);
		root1.right=new TreeNode(2);
		root1.right.left=new TreeNode(1);
		root1.right.right=new TreeNode(3);
		System.out.println("Test Case 1 : "+longestConsecutiveBranch(root1));
		
		TreeNode root2=new TreeNode(1);
		root2.left=new TreeNode(2);
		root2.left.left=new TreeNode(3);
		root2.right=new TreeNode(4);
		root2.right.left=new TreeNode(5);
		root2.right.right=new TreeNode(6);
		root2.right.right.left=new TreeNode(7);
		root2.right.right.left.left=new TreeNode(8);
		System.out.println("Test Case 2 : "+longestConsecutiveBranch(root2));
		
		TreeNode root3=new TreeNode(1);
		root3.right=new TreeNode(2);
		root3.right.right=new TreeNode(3);
		root3.right.right.right=new TreeNode(4);
		root3.right.right.right.right=new TreeNode(5);
		System.out.println("Test Case 3 : "+longestConsecutiveBranch(root3));
	}

	private static int longestConsecutiveBranch(TreeNode node) {
		return longestConsecutiveBranch(node,0,node.data,0);
	}

	private static int longestConsecutiveBranch(TreeNode node, int currentLength, int expected, int result) {
		if(node==null) {
			return result;
		}
		if(node.data==expected) {
			currentLength++;
		}
		else {
			currentLength=1;
		}
		result=Math.max(currentLength, result);
		return Math.max(result, Math.max(longestConsecutiveBranch(node.left, currentLength, node.data+1, result), 
				longestConsecutiveBranch(node.right, currentLength, node.data+1, result)));
	}

}
