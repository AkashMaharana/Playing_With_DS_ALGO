
public class BSTImpl {
	
	public TreeNode root=null;
	
	public void insert(int data) {
		if(root==null) {
			root=new TreeNode(data);
		}
		else {
			insertData(root,data);
		}
	}
	
	private static void insertData(TreeNode node,int data) {
		if(data<node.data) {
			if(node.left!=null) {
				insertData(node.left,data);
			}
			else {
				node.left=new TreeNode(data);
			}
		}
		else {
			if(node.right!=null) {
				insertData(node.right,data);
			}
			else {
				node.right=new TreeNode(data);
			}
		}
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node.left!=null) {
			inOrderTraversal(node.left);
		}
		System.out.print(node.data+" ");
		if(node.right!=null) {
			inOrderTraversal(node.right);
		}
	}
	
	public TreeNode deleteNode(TreeNode node,int data) {
		if(node==null) {
			return null;
		}
		if(data<node.data) {
			node.left=deleteNode(node.left,data);;
		}
		else if(data>node.data) {
			node.right=deleteNode(node.right,data);
		}
		else {
			if(node.left==null && node.right==null) {
				System.out.println("Removing child node");
				return null;
			}
			else if(node.left==null) {
				System.out.println("Removing the right child");
				TreeNode temp=node.right;
				node=null;
				return temp;
			}
			else if(node.right==null) {
				System.out.println("Removing the left child");
				TreeNode temp=node.left;
				node=null;
				return temp;
			}
			System.out.println("Removing the root node");
			TreeNode tempNode=getLeftPredecessor(node.left);
			node.data=tempNode.data;
			node.left=deleteNode(node.left, tempNode.data);
		}
		return node;
	}
	
	private static TreeNode getLeftPredecessor(TreeNode node) {
		while(node.right!=null) {
			node=node.right;
		}
		return node;
	}

}
