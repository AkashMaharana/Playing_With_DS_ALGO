package linkedList;

public class RemoveLoopFromLinkedList {
	
	public static void main(String[] args) {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		node1.next=node2;
		node1.next.next=node3;
		node1.next.next.next=node4;
		node1.next.next.next.next=node5;
		node1.next.next.next.next.next=node1.next;
		LinkedList list=new LinkedList();
		removeLoopFromList(node1);
		list.traverse(node1);
	}
	
	private static void removeLoopFromList(Node node) {
		Node slowPointer=node;
		Node firstPointer=node;
		while(slowPointer!=null && firstPointer!=null && firstPointer.next!=null) {
			slowPointer=slowPointer.next;
			firstPointer=firstPointer.next.next;
			if(slowPointer==firstPointer) {
				break;
			}
		}
		slowPointer=node;
		while(slowPointer!=null && firstPointer!=null) {
			slowPointer=slowPointer.next;
			firstPointer=firstPointer.next;
			if(slowPointer==firstPointer) {
				break;
			}
		}
		while(slowPointer.next!=firstPointer) {
			slowPointer=slowPointer.next;
		}
		slowPointer.next=null;
	}

}
