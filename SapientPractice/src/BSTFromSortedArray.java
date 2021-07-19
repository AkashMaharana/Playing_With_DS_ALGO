
public class BSTFromSortedArray {
	
	public static void main(String[] args) {
		int[] input= {1,2,3,4,5,6,7,8};
		TreeNode root=sortedArrayToBalancedBST(input);
		BSTImpl bst=new BSTImpl();
		bst.inOrderTraversal(root);
	}
	
	private static TreeNode sortedArrayToBalancedBST(int[] input) {
		return balancedBST(input,null,0,input.length-1);
	}
	
	private static TreeNode balancedBST(int[] input,TreeNode root,int low,int high) {
		if(low>high) {
			return root;
		}
		int mid=low+(high-low)/2;
		if(root==null) {
			root=new TreeNode(input[mid]);
		}
		root.left=balancedBST(input,null,low,mid-1);
		root.right=balancedBST(input, null, mid+1, high);
		return root;
	}

}
