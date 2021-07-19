package byteByByte;

public class _27_InorderTraversalWithoutRecursion {
	
	public static void main(String[] args) {
		InorderNode root=new InorderNode(5);
		root.left=new InorderNode(2);
		root.left.left=new InorderNode(1);
		root.left.right=new InorderNode(3);
		root.right=new InorderNode(7);
		root.right.left=new InorderNode(6);
		root.right.right=new InorderNode(8);
		inOrderTraversal(root);
	}
	
	private static void inOrderTraversal(InorderNode node) {
		if(node==null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
	}

}

class InorderNode{
	int data;
	InorderNode left;
	InorderNode right;
	
	public InorderNode(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
