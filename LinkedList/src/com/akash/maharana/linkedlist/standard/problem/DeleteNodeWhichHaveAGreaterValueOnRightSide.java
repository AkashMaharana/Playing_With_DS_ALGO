package com.akash.maharana.linkedlist.standard.problem;

public class DeleteNodeWhichHaveAGreaterValueOnRightSide {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(12);
		l.insert(15);
		l.insert(10);
		l.insert(11);
		l.insert(5);
		l.insert(6);
		l.insert(2);
		l.insert(3);
		Node headNode=deleteNodeWhichHaveAGreaterValueOnRightSide(l.getRootNode());
		traverseListWithHead(headNode);
	}
	
	private static Node deleteNodeWhichHaveAGreaterValueOnRightSide(Node node){
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		while(currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
		}
		Node currentHead=previousNode;
		int currentMax=currentHead.getData();
		while(currentHead.getNextNode()!=null){
			if(currentHead.getNextNode().getData()<currentMax){
				currentHead.setNextNode(currentHead.getNextNode().getNextNode());
			}
			else{
				currentMax=currentHead.getNextNode().getData();
				currentHead=currentHead.getNextNode();
			}
		}
		Node finalNode=reverseList(previousNode);
		return finalNode;
	}

	private static Node reverseList(Node node) {
		Node head=node;
		Node nextToHead=head.getNextNode();
		if(head==null || nextToHead==null){
			return head;
		}
		Node tempNode=reverseList(nextToHead);
		head.getNextNode().setNextNode(head);
		head.setNextNode(null);
		return tempNode;
	}
	
	private static void traverseListWithHead(Node node){
		if(node==null){
			System.out.println("List is empty");
		}
		else{
			while(node!=null){
				System.out.print(node.getData()+"->");
				node=node.getNextNode();
			}
			System.out.println();
		}
	}

}
