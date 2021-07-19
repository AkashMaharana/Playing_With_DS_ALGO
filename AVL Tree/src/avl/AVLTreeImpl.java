package avl;

public class AVLTreeImpl {
	
	private Node rootNode;
	
	public void travere(){
		if(this.rootNode==null){
			return;
		}
		else{
			inOrderTraversal(this.rootNode);
		}
	}
	
	public void insert(int data){
		this.rootNode=insertNode(this.rootNode, data);
	}
	
	private Node insertNode(Node root,int data){
		if(root==null){
			return new Node(data);
		}
		if(data<root.getData()){
			root.setLeftChild(insertNode(root.getLeftChild(),data));
		}
		else{ 
			root.setRightChild(insertNode(root.getRightChild(), data));
		}
		root.setHeight(Math.max(getHeight(root.getLeftChild()), getHeight(root.getRightChild()))+1);
		root=settleViolation(data,root);
		return root;
	}
	
	private Node settleViolation(int data,Node node){
		int balance=getBalance(node);
		if(balance>1 && data<node.getLeftChild().getData()){
			return rightRotation(node);
		}
		if(balance<-1 && data>node.getRightChild().getData()){
			return leftRotation(node);
		}
		if(balance>1 && data>node.getLeftChild().getData()){
			node.setLeftChild(leftRotation(node.getLeftChild()));
			return rightRotation(node);
		}
		if(balance<-1 && data<node.getRightChild().getData()){
			node.setRightChild(rightRotation(node.getRightChild()));
			return leftRotation(node);
		}
		return node;
	}
	
	private void inOrderTraversal(Node node){
		if(node.getLeftChild()!=null){
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node.getData()+"->");
		if(node.getRightChild()!=null){
			inOrderTraversal(node.getRightChild());
		}
	}
	
	private int getHeight(Node node){
		if(node == null){
			return -1;
		}
		return node.getHeight();
	}
	
	private int getBalance(Node node){
		if(node==null){
			return 0;
		}
		return (getHeight(node.getLeftChild())-getHeight(node.getRightChild()));
	}
	
	private Node rightRotation(Node node){
		System.out.println("Right rotatin on : "+node.getData());
		Node tempNode=node.getLeftChild();
		Node tempLeftNode=tempNode.getRightChild();
		tempNode.setRightChild(node);
		node.setLeftChild(tempLeftNode);
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		tempNode.setHeight(Math.max(getHeight(tempNode.getLeftChild()), getHeight(tempNode.getRightChild()))+1);
		return tempNode;
	}
	
	private Node leftRotation(Node node){
		System.out.println("Left rotation on : "+node.getData());
		Node tempNode=node.getRightChild();
		Node tempRightNode=tempNode.getLeftChild();
		tempNode.setLeftChild(node);
		node.setRightChild(tempRightNode);
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		tempNode.setHeight(Math.max(getHeight(tempNode.getLeftChild()), getHeight(tempNode.getRightChild()))+1);
		return tempNode;
	}
	

}
