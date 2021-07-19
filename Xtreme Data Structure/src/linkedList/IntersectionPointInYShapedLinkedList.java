package linkedList;

public class IntersectionPointInYShapedLinkedList {
	
	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		list1.add(3);
		list1.add(6);
		list1.add(9);
		Node node=new Node(15);
		list1.root.next.next.next=node;
		list1.root.next.next.next.next=new Node(30);
		
		LinkedList list2=new LinkedList();
		list2.add(10);
		list2.root.next=node;
		list2.root.next.next=new Node(30);
		
		
		
	}

}
