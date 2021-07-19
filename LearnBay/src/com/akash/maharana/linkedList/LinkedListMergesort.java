package com.akash.maharana.linkedList;

public class LinkedListMergesort {
	
	public static void main(String[] args) {
		MergeSortLinkedList l=new MergeSortLinkedList();
		l.insert(15);
		l.insert(10);
		l.insert(5);
		l.insert(20);
		l.insert(3);
		l.insert(2);
		l.printList();
		MergeNode finalNode=l.sortLinkedList(l.rootNode);
		l.printListWithHead(finalNode);
	}
}

class MergeSortLinkedList{
	MergeNode rootNode;
	
	public void insert(int data){
		if(rootNode==null){
			rootNode=new MergeNode(data);
		}
		else{
			MergeNode root=this.rootNode;
			while(root.next!=null){
				root=root.next;
			}
			MergeNode newNode=new MergeNode(data);
			root.next=newNode;
		}
	}
	
	public MergeNode sortLinkedList(MergeNode node){
		if(node==null || node.next==null){
			return node;
		}
		MergeNode midNode=getMiddleNode(node);
		MergeNode nextToMiddle=midNode.next;
		midNode.next=null;
		MergeNode left=sortLinkedList(node);
		MergeNode right=sortLinkedList(nextToMiddle);
		MergeNode finalNode = sortedMerge(left,right);
		return finalNode;
	}
	
	public MergeNode sortedMerge(MergeNode left,MergeNode right){
		if(left==null && right==null){
			return null;
		}
		if(left==null){
			return right;
		}
		if(right==null){
			return left;
		}
		if(left.data<=right.data){
			left.next=sortedMerge(left.next,right);
		}
		else{
			MergeNode tempNode=right;
			right=right.next;
			tempNode.next=left;
			left=tempNode;
			left.next=sortedMerge(left.next, right);
		}
		return left;
	}
	
	public MergeNode getMiddleNode(MergeNode node){
		if (node == null) 
            return node; 
  
		MergeNode slowPointer = node;
		MergeNode fastPointer = node; 
  
        while (fastPointer.next != null && fastPointer.next.next != null) { 
        	slowPointer = slowPointer.next; 
        	fastPointer = fastPointer.next.next; 
        } 
        return slowPointer; 
	}
	
	public void printList(){
		MergeNode temp=this.rootNode;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public void printListWithHead(MergeNode head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.println();
	}
}

class MergeNode{
	int data;
	MergeNode next;
	
	MergeNode(int data){
		this.data=data;
		this.next=null;
	}
}
