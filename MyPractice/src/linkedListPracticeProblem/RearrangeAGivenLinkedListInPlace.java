package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class RearrangeAGivenLinkedListInPlace {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);
		list.addNode(70);
		list.addNode(80);
		list.addNode(90);
		list.addNode(100);
		list.addNode(110);
		rearrange(list.getRoootNode());
	}

	private static void rearrange(Node node) {
		Node fastPointer = node;
		Node slowPointer = node;
		Node midNode = null;
		Node previousOfSlowPointer = null;
		if (node != null && node.getNextNode() != null) {
			while (fastPointer != null && fastPointer.getNextNode() != null) {
				fastPointer = fastPointer.getNextNode().getNextNode();
				previousOfSlowPointer = slowPointer;
				slowPointer = slowPointer.getNextNode();
			}
		}
		if (fastPointer != null) {
			midNode = slowPointer;
			slowPointer = slowPointer.getNextNode();
		}
		previousOfSlowPointer.setNextNode(null);
		Node reverseHead = reverse(slowPointer);
		Node finalHead = mergeTwoList(node, reverseHead, midNode);
		printList(finalHead);
	}
	
	private static void printList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
	}

	private static Node mergeTwoList(Node head1, Node head2, Node mid) {
		LinkedList list = new LinkedList();
		while (head1 != null || head2 != null) {
			if (head1 != null) {
				list.addNode(head1.getData());
				head1 = head1.getNextNode();
			}if (head2 != null) {
				list.addNode(head2.getData());
				head2 = head2.getNextNode();
			}if (head1 == null && head2 == null && mid != null) {
				list.addNode(mid.getData());
			}
		}
		return list.getRoootNode();
	}

	private static Node reverse(Node node) {
		Node previousNode = null;
		Node currentNode = node;
		Node nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

}
