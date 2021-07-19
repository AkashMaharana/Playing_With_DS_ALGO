package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class LinkedListIsPallindromeOrNot {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(5);
		list.addNode(5);
		list.addNode(2);
		list.addNode(1);
		System.out.println(isPallindrome(list.getRoootNode()));
	}
	
	private static boolean isPallindrome(Node node){
		Node fastPointer=node;
		Node slowPointer=node;
		Node previousPointer=null;
		Node midNode=null;
		Node secondHalfhead=null;
		if(node!=null && node.getNextNode()!=null){
			while(fastPointer!=null && fastPointer.getNextNode()!=null){
				fastPointer=fastPointer.getNextNode().getNextNode();
				previousPointer=slowPointer;
				slowPointer=slowPointer.getNextNode();
			}
		}
		if(fastPointer!=null){
			midNode=slowPointer;
			slowPointer=slowPointer.getNextNode();
		}
		previousPointer.setNextNode(null);
		secondHalfhead=slowPointer;
		Node reverseHead=reverse(secondHalfhead);
		boolean result=compareList(node,reverseHead);
		reverse(reverseHead);
		if(midNode!=null){
			previousPointer.setNextNode(midNode);
			midNode.setNextNode(secondHalfhead);
		}
		else{
			previousPointer.setNextNode(slowPointer);
		}
		return result;
	}
	
	private static boolean compareList(Node head1,Node head2){
		boolean isValid=false;
		while(head1!=null && head2!=null){
			if(head1.getData()==head2.getData()){
				head1=head1.getNextNode();
				head2=head2.getNextNode();
			}
			else{
				return isValid;
			}
		}
		return true;
	}
	
	private static Node reverse(Node node){
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		while(currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

}
