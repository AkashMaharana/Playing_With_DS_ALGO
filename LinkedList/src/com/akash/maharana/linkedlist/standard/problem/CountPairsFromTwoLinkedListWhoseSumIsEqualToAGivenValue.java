package com.akash.maharana.linkedlist.standard.problem;

public class CountPairsFromTwoLinkedListWhoseSumIsEqualToAGivenValue {
	
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.insert(3);
		l1.insert(1);
		l1.insert(5);
		l1.insert(7);
		LinkedList l2=new LinkedList();
		l2.insert(8);
		l2.insert(2);
		l2.insert(5);
		l2.insert(3);
		countPairs(l1.getRootNode(),l2.getRootNode(),10);
	}
	
	private static void traverseList(Node head){
		while(head!=null){
			System.out.print(head.getData()+"->");
			head=head.getNextNode();
		}
		System.out.println();
	}
	
	private static void countPairs(Node head1,Node head2,int pairSum){
		Node newHead1=sortAscending(head1);
		Node newHead2=sortDescending(head2);
		traverseList(newHead1);
		traverseList(newHead2);
		int count=0;
		while(newHead1!=null && newHead2!=null){
			if(newHead1.getData()+newHead2.getData()==pairSum){
				count=count+1;
				System.out.println("("+newHead1.getData()+","+newHead2.getData()+")");
				newHead1=newHead1.getNextNode();
				newHead2=newHead2.getNextNode();
			}
			else if(newHead1.getData()+newHead2.getData()<pairSum){
				newHead1=newHead1.getNextNode();
			}
			else{
				newHead2=newHead2.getNextNode();
			}
		}
		if(count==0){
			System.out.println("No records found");
		}
		else{
			System.out.println("No of pairs : "+count);
		}
	}
	
	private static Node sortAscending(Node head1){
		if(head1==null || head1.getNextNode()==null){
			return head1;
		}
		Node middleNode=getMiddle(head1);
		Node nextToMiddle=middleNode.getNextNode();
		middleNode.setNextNode(null);
		Node left=sortAscending(head1);
		Node right=sortAscending(nextToMiddle);
		Node finalNode=mergeAscending(left,right);
		return finalNode;
	}
	
	private static Node sortDescending(Node head2){
		if(head2==null || head2.getNextNode()==null){
			return head2;
		}
		Node middleNode=getMiddle(head2);
		Node nextToMiddle=middleNode.getNextNode();
		middleNode.setNextNode(null);
		Node left=sortDescending(head2);
		Node right=sortDescending(nextToMiddle);
		Node finalNode=mergeDescending(left,right);
		return finalNode;
	}
	
	private static Node mergeAscending(Node head1,Node head2){
		if(head1==null && head2==null){
			return null;
		}
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		if(head1.getData()<head2.getData()){
			head1.setNextNode(mergeAscending(head1.getNextNode(), head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(mergeAscending(head1.getNextNode(),head2));
		}
		return head1;
	}
	
	private static Node mergeDescending(Node head1,Node head2){
		if(head1==null && head2==null){
			return head1;
		}
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		if(head1.getData()>head2.getData()){
			head1.setNextNode(mergeDescending(head1.getNextNode(),head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(mergeDescending(head1.getNextNode(), head2));
		}
		return head1;
	}
	
	private static Node getMiddle(Node head){
		if(head==null){
			return head;
		}
		Node slowPointer=head;
		Node fastPointer=head;
		while(fastPointer.getNextNode()!=null && fastPointer.getNextNode().getNextNode()!=null){
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
		return slowPointer;
	}

}
