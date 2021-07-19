package tree;

public class BinaryTreeToDLL {
	
	private static Node head=null;
	private static Node previous=null;
	private static Node currentHead=null;
	
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		binaryTreeToDLL(root);
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.right;
		}
	}
	
	private static void binaryTreeToDLL(Node node) {
		if(node==null) {
			return;
		}
		binaryTreeToDLL(node.left);
		if(head==null) {
			head=node;
			currentHead=node;
		}
		else {
			previous=currentHead;
			Node newNode=new Node(node.data);
			currentHead=newNode;
			previous.right=newNode;
			newNode.left=previous;
		}
		binaryTreeToDLL(node.right);
	}

}