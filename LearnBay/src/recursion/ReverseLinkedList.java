package recursion;

import com.akash.maharana.linkedList.LinkedList;
import com.akash.maharana.linkedList.Node;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		Node head=reverseList(list.getRootNode());
		while(head!=null){
			System.out.print(head.getData()+"->");
			head=head.getNextNode();
		}
	}
	
	private static Node reverseList(Node node){
		Node currentNode=node;
		Node nextNode=currentNode.getNextNode();
		if(currentNode==null || nextNode==null){
			return node;
		}
		Node tempNode=reverseList(nextNode);
		currentNode.getNextNode().setNextNode(currentNode);
		currentNode.setNextNode(null);
		return tempNode;
	}

}
