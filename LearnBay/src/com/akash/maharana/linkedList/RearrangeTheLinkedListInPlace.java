package com.akash.maharana.linkedList;

public class RearrangeTheLinkedListInPlace {
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		l.insert(60);
		l.insert(70);
		l.insert(80);
		l.insert(90);
		l.insert(100);
		rearrange(l.getRootNode());
	}
	
	private static void rearrange(Node node){
		Node slowPointer=node;
		Node fastPointer=node;
		Node previousOfSlowPointer=null;
		Node midNode=null;
		if(node!=null && node.getNextNode()!=null){
			while(fastPointer!=null && fastPointer.getNextNode()!=null){
				previousOfSlowPointer=slowPointer;
				slowPointer=slowPointer.getNextNode();
				fastPointer=fastPointer.getNextNode().getNextNode();
			}
		}
		if(fastPointer!=null){
			midNode=slowPointer;
			slowPointer=slowPointer.getNextNode();
		}
		previousOfSlowPointer.setNextNode(null);
		Node reverseHead=reverse(slowPointer);
		Node finalHead=merge(node,reverseHead,midNode);
		while(finalHead!=null){
			System.out.print(finalHead.getData()+"->");
			finalHead=finalHead.getNextNode();
		}
	}
	
	private static Node merge(Node head1,Node head2,Node midNode){
		LinkedList l=new LinkedList();
		while(head1!=null || head2!=null){
			if(head1!=null){
				l.insert(head1.getData());
				head1=head1.getNextNode();
			}
			if(head2!=null){
				l.insert(head2.getData());
				head2=head2.getNextNode();
			}
			if(head1==null && head2==null && midNode!=null){
				l.insert(midNode.getData());
			}
		}
		return l.getRootNode();
	}
	
	private static Node reverse(Node node){
		Node currentNode=node;
		Node nextToCurrent=node.getNextNode();
		if(currentNode==null || nextToCurrent==null){
			return node;
		}
		Node tempNode=reverse(nextToCurrent);
		currentNode.getNextNode().setNextNode(currentNode);
		currentNode.setNextNode(null);
		return tempNode;
	}

}
