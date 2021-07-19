package binaryTree;

public class BinaryTreeToDoublyLinkedListInOrder {

	NodeInOrder root;
	NodeInOrder head;
	static NodeInOrder prev = null;

	void binaryTree2DoubleLinkedList(NodeInOrder root) {
		if (root == null)
			return;

		binaryTree2DoubleLinkedList(root.left);

		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		binaryTree2DoubleLinkedList(root.right);
	}

	void printList(NodeInOrder node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeToDoublyLinkedListInOrder tree = new BinaryTreeToDoublyLinkedListInOrder();
		tree.root = new NodeInOrder(10);
		tree.root.left = new NodeInOrder(12);
		tree.root.right = new NodeInOrder(15);
		tree.root.left.left = new NodeInOrder(25);
		tree.root.left.right = new NodeInOrder(30);
		tree.root.right.left = new NodeInOrder(36);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
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