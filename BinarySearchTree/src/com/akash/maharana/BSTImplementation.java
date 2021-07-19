package com.akash.maharana;

public class BSTImplementation {

	private int size;
	private Node rootNode;

	public int getSize() {
		return size;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void insert(int data) {
		size = size + 1;
		if (rootNode == null) {
			this.rootNode = new Node(data);
		} else {
			insertNode(rootNode, data);
		}
	}
	
	private void postOrderTraversal(Node node){
		if(node.getLeftChild()!=null){
			postOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			postOrderTraversal(node.getRightChild());
		}
		System.out.print(node.getData()+"->");
	}
	
	private void preOrderTraversal(Node node){
		System.out.print(node.getData()+"->");
		if(node.getLeftChild()!=null){
			preOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			preOrderTraversal(node.getRightChild());
		}
	}

	private void insertNode(Node root, int data) {
		if (data < root.getData()) {
			if (root.getLeftChild() != null) {
				insertNode(root.getLeftChild(), data);
			} else {
				Node newNode = new Node(data);
				root.setLeftChild(newNode);
			}
		} else {
			if (root.getRightChild() != null) {
				insertNode(root.getRightChild(), data);
			} else {
				Node newNode = new Node(data);
				root.setRightChild(newNode);
			}
		}
	}

	public void traverse() {
		if(this.rootNode==null){
			return;
		}
		else{
			inOrderTraversal(this.rootNode);
			//postOrderTraversal(this.rootNode);
			//preOrderTraversal(this.rootNode);
		}

	}
	
	private void inOrderTraversal(Node root){
		if(root.getLeftChild()!=null){
			inOrderTraversal(root.getLeftChild());
		}
		System.out.print(root.getData()+"->");
		if(root.getRightChild()!=null){
			inOrderTraversal(root.getRightChild());
		}
	}

	public void delete(int data) {
		if(this.rootNode==null){
			return;
		}
		else{
			deleteNode(this.rootNode,data);
		}
	}
	
	private Node deleteNode(Node node,int data){
		if(node==null){
			return node;
		}
		if(data<node.getData()){
			node.setLeftChild(deleteNode(node.getLeftChild(), data));
		}
		else if(data>node.getData()){
			node.setRightChild(deleteNode(node.getRightChild(), data));
		}
		else{
			if(node.getLeftChild()==null && node.getRightChild()==null){
				System.out.println("Removing the leaf Node");
				return null;
			}
			else if(node.getLeftChild()==null){
				System.out.println("Removing the right child");
				Node tempNode=node.getRightChild();
				node=null;
				return tempNode;
			}
			else if(node.getRightChild()==null){
				System.out.println("Removing the left child");
				Node tempNode=node.getLeftChild();
				node=null;
				return tempNode;
			}
			System.out.println("Removing node with two children");
			Node tempNode=getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(),tempNode.getData()));
		}
		return node ;
	}
	
	private Node getPredecessor(Node node){
		while(node.getRightChild()!=null){
			node=node.getRightChild();
		}
		return node;
	}

	public int getMax() {
		if(this.rootNode==null){
			return -1;
		}
		else{
			return getMaximumValue(this.rootNode);
		}
	}
	
	private int getMaximumValue(Node node){
		if(node.getRightChild()!=null){
			return getMaximumValue(node.getRightChild());
		}
		else{
			return node.getData();
		}
	}

	public int getMin() {
		if(this.rootNode==null){
			return -1;
		}
		else{
			return getMinimumValue(this.rootNode);
		}
	}
	
	private int getMinimumValue(Node node){
		if(node.getLeftChild()!=null){
			return getMinimumValue(node.getLeftChild());
		}
		else{
			return node.getData();
		}
	}

}
