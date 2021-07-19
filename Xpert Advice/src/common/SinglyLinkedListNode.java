package common;

public class SinglyLinkedListNode {

	private int data;
	private SinglyLinkedListNode nextNode;

	public SinglyLinkedListNode(int data) {
		this.data = data;
		this.nextNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SinglyLinkedListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(SinglyLinkedListNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public static void traverse(SinglyLinkedListNode node) {
		while(node!=null) {
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
		System.out.println();
	}

}
