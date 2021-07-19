package com.akash.maharana.linkedlist.doubly.impl;

public class DoublyLinkedList {
	
	public Node rootNode=null;
	public int size=0;
	
	public void insert(int data){
		if(this.rootNode==null){
			this.rootNode=new Node(data);
		}
		else{
			insertAtEnd(data,this.rootNode);
			//insertAtBeginning(data,this.rootNode);
		}
	}
	
	private void insertAtEnd(int data,Node node){
		if(node.getNext()!=null){
			insertAtEnd(data, node.getNext());
		}
		else{
			Node newNode=new Node(data);
			node.setNext(newNode);
			newNode.setPrev(node);
		}
	}
	
	private void insertAtBeginning(int data,Node node){
		Node newNode=new Node(data);
		newNode.setNext(node);
		node.setPrev(newNode);
		this.rootNode=newNode;
	}
	
	public void insertAtPosition(int data,int position){
		insertAtParticularPosition(data,position,this.rootNode);
	}
	
	private void insertAtParticularPosition(int data,int position,Node node){
		if(node.getData()!=position){
			insertAtParticularPosition(data,position,node.getNext());
		}
		else{
			Node newNode=new Node(data);
			newNode.setNext(node.getNext());
			node.getNext().setPrev(newNode);
			newNode.setPrev(node);
			node.setNext(newNode);
		}
	}
	
	public void delete(){
		//deleteFromBeginning(this.rootNode);
		deleteFromEnd(this.rootNode);
	}
	
	private  void deleteFromBeginning(Node node){
		this.rootNode=node.getNext();
		rootNode.setPrev(null);
	}
	
	private void deleteFromEnd(Node node){
		if(node.getNext()!=null){
			deleteFromEnd(node.getNext());
		}
		else{
			node.getPrev().setNext(null);
			node.setPrev(null);
		}
	}
	
	public void traverseForward(){
		Node node=this.rootNode;
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNext();
		}
	}

}
