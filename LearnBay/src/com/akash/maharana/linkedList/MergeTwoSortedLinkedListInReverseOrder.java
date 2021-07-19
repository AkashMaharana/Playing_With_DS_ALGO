package com.akash.maharana.linkedList;

public class MergeTwoSortedLinkedListInReverseOrder {
	
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		l1.insert(5);
		l1.insert(10);
		l1.insert(15);
		l1.insert(40);
		l2.insert(2);
		l2.insert(3);
		l2.insert(20);
		Node newHead=mergeTwoList(l1.getRootNode(),l2.getRootNode());
		while(newHead!=null){
			System.out.print(newHead.getData()+"->");
			newHead=newHead.getNextNode();
		}
	}
	
	private static Node mergeTwoList(Node head1,Node head2){
		if(head1==null && head2==null){
			return null;
		}
		Node resultantNode=null;
		while(head1!=null && head2!=null){
			if(head1.getData()<head2.getData()){
				Node tempNode=head1.getNextNode();
				head1.setNextNode(resultantNode);
				resultantNode=head1;
				head1=tempNode;
			}
			else{
				Node tempNode=head2.getNextNode();
				head2.setNextNode(resultantNode);
				resultantNode=head2;
				head2=tempNode;
			}
		}
		while(head1!=null){
			Node tempNode=head1.getNextNode();
			head1.setNextNode(resultantNode);
			resultantNode=head1;
			head1=tempNode;
		}
		while(head2!=null){
			Node tempNode=head2.getNextNode();
			head2.setNextNode(resultantNode);
			resultantNode=head2;
			head2=tempNode;
		}
		return resultantNode;
	}

}
