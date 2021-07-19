package tree;

public class DeepestNodeInABinaryTree {
	
	private static int result=-1;
	private static int maximumLevel=-1;
	
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.right.right.right=new Node(8);
		deepestNode(root, 0);
		System.out.println("Deepest Node is : "+result);
	}
	
	private static void deepestNode(Node node,int level) {
		if(node!=null) {
			deepestNode(node.left, ++level);
			if(level>maximumLevel) {
				maximumLevel=level;
				result=node.data;
			}
			deepestNode(node.right,level);
		}
	}

}
