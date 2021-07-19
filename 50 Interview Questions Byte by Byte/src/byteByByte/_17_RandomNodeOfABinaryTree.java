package byteByByte;

public class _17_RandomNodeOfABinaryTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.leftChild = new Node(20);
		root.rightChild = new Node(30);
		root.leftChild.leftChild = new Node(40);
		root.leftChild.rightChild = new Node(50);
		root.rightChild.leftChild = new Node(60);
		root.rightChild.rightChild = new Node(70);

		insertChildrenCount(root);
		
		int data=getRandomNodeData(root);
		
		System.out.println("Random Node is : "+data);
	}
	
	/*private static void printChildrenCount(Node node) {
		if(node.leftChild!=null) {
			printChildrenCount(node.leftChild);
		}
		System.out.println(node.data+" : "+node.children);
		if(node.rightChild!=null) {
			printChildrenCount(node.rightChild);
		}
	}*/
	
	private static int getRandomNodeData(Node node) {
		int randomNumber=(int) (Math.random()*(node.children+1));
		return randomData(node,randomNumber);
	}
	
	private static int randomData(Node node,int randomNumber) {
		if(node==null) {
			return 0;
		}
		if(randomNumber==getCountOfChildren(node.leftChild)) {
			return node.data;
		}
		if(randomNumber<getCountOfChildren(node.leftChild)) {
			return randomData(node.leftChild, randomNumber);
		}
		return randomData(node.rightChild, randomNumber-getCountOfChildren(node.leftChild)-1);
	}
	
	private static int getCountOfChildren(Node node) {
		if(node==null) {
			return 0;
		}
		return node.children+1;
	}

	private static Node insertChildrenCount(Node root) {
		if (root == null) {
			return null;
		}
		root.children = getElements(root) - 1;
		root.leftChild = insertChildrenCount(root.leftChild);
		root.rightChild = insertChildrenCount(root.rightChild);
		return root;
	}

	private static int getElements(Node root) {
		if (root == null) {
			return 0;
		}
		return getElements(root.leftChild) + getElements(root.rightChild) + 1;
	}

}

class Node {
	int data;
	int children;
	Node leftChild;
	Node rightChild;

	public Node(int data) {
		this.data = data;
		this.children = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
}