package singlyLinkedList;

public class LinkedList {

	private Node roootNode;
	private int size;

	public void addNode(int data) {
		this.size++;
		if (this.roootNode == null) {
			this.roootNode = new Node(data);
		} else {
			addNodeToTheEnd(data);
		}
	}

	private void addNodeToTheEnd(int data) {
		Node tempNode = this.roootNode;
		while (tempNode.getNextNode() != null) {
			tempNode = tempNode.getNextNode();
		}
		tempNode.setNextNode(new Node(data));
	}

	public void traverseList() {
		Node tempNode = this.roootNode;
		while (tempNode != null) {
			System.out.println(tempNode);
			tempNode = tempNode.getNextNode();
		}
	}

	public void deleteNode(int data) {
		if (this.roootNode.getData() == data) {
			size--;
			Node tempNode = this.roootNode.getNextNode();
			this.roootNode.setNextNode(null);
			this.roootNode = tempNode;
		} else {
			Node previousNode = this.roootNode;
			Node tempNode = previousNode.getNextNode();
			while (previousNode != null && previousNode.getNextNode() != null) {
				if (tempNode.getData() == data) {
					size--;
					Node newNode = tempNode.getNextNode();
					previousNode.setNextNode(tempNode.getNextNode());
					previousNode = newNode;
					if (previousNode != null) {
						tempNode = previousNode.getNextNode();
					}

				} else {
					previousNode = tempNode;
					tempNode = tempNode.getNextNode();
				}
			}
		}
	}

	public int size() {
		return this.size;
	}

	public Node getRoootNode() {
		return roootNode;
	}

}
