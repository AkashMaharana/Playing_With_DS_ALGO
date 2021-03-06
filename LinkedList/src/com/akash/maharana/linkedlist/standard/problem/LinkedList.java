package com.akash.maharana.linkedlist.standard.problem;

public class LinkedList {
	
	private Node rootNode;
	private int size;
	
	public Node getRootNode() {
		return rootNode;
	}

	public int getSize() {
		return size;
	}

	public void insert(int data){
		size=size+1;
		if(rootNode==null){
			this.rootNode=new Node(data);
		}
		else{
			insertAtEnd(data,rootNode);
			//insertAtBeginning(data,rootNode);
		}
	}
	
	/*private void insertAtBeginning(int data,Node rootNode){
		Node newNode=new Node(data);
		newNode.setNextNode(rootNode);
		this.rootNode=newNode;
	}*/
	
	private void insertAtEnd(int data,Node rootNode){
		if(rootNode.getNextNode()!=null){
			insertAtEnd(data,rootNode.getNextNode());
		}
		else{
			rootNode.setNextNode(new Node(data));
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public void traverseList(){
		Node rootNode=this.rootNode;
		if(rootNode==null){
			System.out.println("Linkedlist is empty");
			return;
		}
		while(rootNode!=null){
			System.out.print(rootNode.getData()+"->");
			rootNode=rootNode.getNextNode();
		}
	}
	
	public void traverseListWithHead(Node node){
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
	
	public void traverseList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
	}
	
	public void insertAfter(int data,int after){
		Node afterNode=this.rootNode;
		while(afterNode.getData()!=after){
			afterNode=afterNode.getNextNode();
		}
		Node newNode=new Node(data);
		newNode.setNextNode(afterNode.getNextNode());
		afterNode.setNextNode(newNode);
	}
	
	public void insertBefore(int data,int before){
		Node beforeNode=this.rootNode;
		Node previousNode=null;
		while(beforeNode.getData()!=before){
			previousNode=beforeNode;
			beforeNode=beforeNode.getNextNode();
		}
		Node newNode=new Node(data);
		if(beforeNode==this.rootNode){
			newNode.setNextNode(beforeNode);
			this.rootNode=newNode;
		}
		else{
			previousNode.setNextNode(newNode);
			newNode.setNextNode(beforeNode);
		}
	}
	
	public void deleteFromLast(){
		Node tempNode=this.rootNode;
		if(tempNode.getNextNode()==null){
			tempNode=null;
		}
		else{
			Node previousNode=null;
			while(tempNode.getNextNode()!=null){
				previousNode=tempNode;
				tempNode=tempNode.getNextNode();
			}
			previousNode.setNextNode(null);
		}
		
	}
	
	public void deleteAfterNode(int data){
		Node tempNode=this.rootNode;
		while(tempNode.getData()!=data){
			tempNode=tempNode.getNextNode();
		}
		if(tempNode.getNextNode().getNextNode()==null){
			tempNode.setNextNode(null);
		}
		else{
			tempNode.setNextNode(tempNode.getNextNode().getNextNode());
		}
	}
	
	public void deleteSpecificNode(int data){
		Node tempNode=this.rootNode;
		Node previousNode=null;
		while(tempNode.getData()!=data){
			previousNode=tempNode;
			tempNode=tempNode.getNextNode();
		}
		if(tempNode==this.rootNode){
			this.rootNode=this.rootNode.getNextNode();
			tempNode=null;
		}
		else{
			previousNode.setNextNode(tempNode.getNextNode());
			tempNode=null;
		}
	}
	
	/*public void detectLoop(LinkedList l){
		Node firstPointer=this.rootNode;
		Node secondPointer=this.rootNode;
		while(firstPointer.getData()!=secondPointer.getData()){
			firstPointer=firstPointer.getNextNode();
			secondPointer=secondPointer.getNextNode().getNextNode();
		}
		System.out.println(firstPointer.getData());
	}*/
	
	public Node reverse(){
		return reverseList(this.rootNode);
	}
	
	private Node reverseList(Node node){
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
	
	public void traverseReverseList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
	}
	
}
