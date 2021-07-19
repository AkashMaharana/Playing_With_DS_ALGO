package com.akash.maharana.linkedlist.standard.problem;

import com.akash.maharana.linkedlist.singly.impl.LinkedList;
import com.akash.maharana.linkedlist.singly.impl.Node;

public class SortAListThatIsSortedInAscendingDescending {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(10);
		list.addNode(40);
		list.addNode(53);
		list.addNode(30);
		list.addNode(67);
		list.addNode(12);
		list.addNode(89);
		sortList(list.getRoootNode());
	}
	
	private static void sortList(Node node){
		Node tempasc=node;
		Node tempdsc=node.getNextNode();
		Node ascNode=node;
		Node dscNode=node.getNextNode();
		while(ascNode.getNextNode()!=null && ascNode.getNextNode().getNextNode()!=null){
			ascNode.setNextNode(ascNode.getNextNode().getNextNode());
			dscNode.setNextNode(dscNode.getNextNode().getNextNode());
			ascNode=ascNode.getNextNode();
			dscNode=dscNode.getNextNode();
		}
		printList(tempasc);
		printList(tempdsc);
		Node reverseHead=reverse(tempdsc);
		Node finalHead=merge(tempasc,reverseHead);
		printList(finalHead);
	}
	
	private static Node merge(Node head1,Node head2){
		if(head1==null && head2==null){
			return null;
		}
		else if(head1==null){
			return head2;
		}
		else if(head2==null){
			return head1;
		}
		if(head1.getData()<head2.getData()){
			head1.setNextNode(merge(head1.getNextNode(),head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(merge(head1.getNextNode(),head2));
		}
		return head1;
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
	
	private static void printList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
		System.out.println();
	}

}
