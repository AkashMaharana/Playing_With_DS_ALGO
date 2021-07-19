package byteByByte;

public class _21_BinaryTreeToDoublyLinkedListInOrder {

	static NodeInOrder previous = null;
	static NodeInOrder head = null;
	NodeInOrder root = null;

	public static void main(String[] args) {
		_21_BinaryTreeToDoublyLinkedListInOrder tree = new _21_BinaryTreeToDoublyLinkedListInOrder();
		tree.root = new NodeInOrder(10);
		tree.root.left = new NodeInOrder(12);
		tree.root.right = new NodeInOrder(15);
		tree.root.left.left = new NodeInOrder(25);
		tree.root.left.right = new NodeInOrder(30);
		tree.root.right.left = new NodeInOrder(36);
		convertBinaryToDoubly(tree.root);
		printList(_21_BinaryTreeToDoublyLinkedListInOrder.head);
	}

	private static void convertBinaryToDoubly(NodeInOrder root) {
		if (root == null) {
			return;
		}
		convertBinaryToDoubly(root.left);
		if (previous == null) {
			head = root;
		} else {
			previous.right = root;
			root.left = previous;
		}
		previous = root;
		convertBinaryToDoubly(root.right);
	}
	
	private static void printList(NodeInOrder node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

}

class NodeInOrder {
	int data;
	NodeInOrder left;
	NodeInOrder right;

	NodeInOrder(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
