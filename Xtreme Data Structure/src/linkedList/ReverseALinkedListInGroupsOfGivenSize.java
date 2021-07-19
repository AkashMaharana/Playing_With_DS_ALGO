package linkedList;

public class ReverseALinkedListInGroupsOfGivenSize {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.traverse(list.root);
		Node node=reverseInGroups(list.root,4);
		list.traverse(node);
	}
	
	private static Node reverseInGroups(Node node,int size) {
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		int count=0;
		while(count<size && currentNode!=null) {
			nextNode=currentNode.next;
			currentNode.next=previousNode;
			previousNode=currentNode;
			currentNode=nextNode;
			count++;
		}
		if(nextNode!=null) {
			node.next=reverseInGroups(nextNode, size);
		}
		return previousNode;
	}

}
