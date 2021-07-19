package circularLinkedList;

public class CircularLinkedList {

	private Node lastNode;
	private int size;

	public void addNode(int data) {
		this.size++;
		if (this.lastNode == null) {
			this.lastNode = new Node(data);
			this.lastNode.setNextNode(this.lastNode);
		} else {
			Node newNode = new Node(data);
			newNode.setNextNode(this.lastNode.getNextNode());
			this.lastNode.setNextNode(newNode);
		}
	}

	public int size() {
		return this.size;
	}

	public void traverse() {
		Node tempNode = this.lastNode.getNextNode();
		do {
			System.out.println(tempNode);
			tempNode = tempNode.getNextNode();
		} while (tempNode != this.lastNode.getNextNode());
	}
	
	public void deleteNode(int data){
		Node previousNode=this.lastNode;
		Node currentNode=previousNode.getNextNode();
		do{
			if(currentNode.getData()==data){
				previousNode.setNextNode(currentNode.getNextNode());
				currentNode.setNextNode(null);
				break;
			}
			else{
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
			}
		}
		while(true);
	}

}
