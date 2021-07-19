package byteByByte;

public class _23_ReverseOfALinkedList {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.traverse(list.root);
		list.traverse(reverse(list.root));
	}
	
	private static LinkedListNode reverse(LinkedListNode node) {
		LinkedListNode previousNode=null;
		LinkedListNode currentNode=node;
		LinkedListNode nextNode=null;
		while(currentNode!=null) {
			nextNode=currentNode.nextNode;
			currentNode.nextNode=previousNode;
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

}

class LinkedListNode{
	int data;
	LinkedListNode nextNode;
	
	public LinkedListNode(int data) {
		this.data=data;
		this.nextNode=null;
	}
}

class LinkedList{
	LinkedListNode root;
	
	public void addNode(int data) {
		if(root==null) {
			this.root=new LinkedListNode(data);
		}
		else {
			LinkedListNode temp=root;
			while(temp.nextNode!=null) {
				temp=temp.nextNode;
			}
			temp.nextNode=new LinkedListNode(data);
		}
	}
	
	public void traverse(LinkedListNode node) {
		LinkedListNode temp=node;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.nextNode;
		}
		System.out.println();
	}
}
