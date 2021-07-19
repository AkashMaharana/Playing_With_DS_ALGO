package bst;

public class BSTImpl {

	private Node rootNode;

	public Node getRootNode() {
		return rootNode;
	}

	public void insert(int data) {
		if (rootNode == null) {
			rootNode = new Node(data);
		} else {
			insertNode(this.rootNode, data);
		}
	}

	private void insertNode(Node root, int data) {
		if (data < root.getData()) {
			if (root.getLeftChild() != null) {
				insertNode(root.getLeftChild(), data);
			} else {
				root.setLeftChild(new Node(data));
			}
		} else {
			if (root.getRightChild() != null) {
				insertNode(root.getRightChild(), data);
			} else {
				root.setRightChild(new Node(data));
			}
		}
	}

	public void traverse() {
		if (rootNode == null) {
			return;
		} else {
			inOrderTraversal(this.rootNode);
			// preOrderTraversal(this.rootNode);
			// postOrderTraversal(this.rootNode);
		}
	}

	private void postOrderTraversal(Node node) {
		if (node.getLeftChild() != null) {
			postOrderTraversal(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			postOrderTraversal(node.getRightChild());
		}
		System.out.print(node.getData() + "->");
	}

	private void preOrderTraversal(Node node) {
		System.out.print(node.getData() + "->");
		if (node.getLeftChild() != null) {
			preOrderTraversal(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			preOrderTraversal(node.getRightChild());
		}
	}

	private void inOrderTraversal(Node node) {
		if (node.getLeftChild() != null) {
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node.getData() + "->");
		if (node.getRightChild() != null) {
			inOrderTraversal(node.getRightChild());
		}
	}

	public void delete(int data) {
		if (rootNode == null) {
			return;
		} else {
			deleteNode(this.rootNode, data);
		}
	}

	private Node deleteNode(Node node, int data) {
		if (data < node.getData()) {
			node.setLeftChild(deleteNode(node.getLeftChild(), data));
		} else if (data > node.getData()) {
			node.setRightChild(deleteNode(node.getRightChild(), data));
		} else {
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing leaf node");
				return null;
			} else if (node.getLeftChild() == null) {
				System.out.println("Removing right child");
				Node tempNode = node.getRightChild();
				node = null;
				return tempNode;
			} else if (node.getRightChild() == null) {
				System.out.println("Removing left child");
				Node tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			} else {
				System.out.println("Removing node having two children");
				Node tempNode = getPredecessor(node.getLeftChild());
				node.setData(tempNode.getData());
				node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));
			}
		}
		return node;
	}

	public Node getPredecessor(Node node) {
		while (node.getRightChild() != null) {
			node = node.getRightChild();
		}
		return node;
	}

}
