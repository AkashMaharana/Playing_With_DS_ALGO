package linkedList;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.traverse(list.root);
		Node node=reverseIterative(list.root);
		list.traverse(node);
		Node node1=reverseRecursive(node);
		list.traverse(node1);
	}
	
	private static Node reverseIterative(Node node) {
		Node currentNode=node;
		Node previousNode=null;
		Node nextNode=null;
		while(currentNode!=null) {
			nextNode=currentNode.next;
			currentNode.next=previousNode;
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}
	
	private static Node reverseRecursive(Node node) {
		if(node==null) {
			return node;
			
		}
		if(node.next==null) {
			return node;
		}
		Node temp=reverseRecursive(node.next);
		node.next.next=node;
		node.next=null;
		return temp;
	}

}
