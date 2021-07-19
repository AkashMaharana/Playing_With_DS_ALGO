package avl;

public class AVLImpl {
	
	private Node rootNode;
	
	public void traverse(){
		inOrderTraversal(this.rootNode);
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
	
	public void insert(int data){
		this.rootNode=insertNode(this.rootNode,data);
	}
	
	private Node insertNode(Node node,int data){
		if(node==null){
			return new Node(data);
		}
		if(data<node.getData()){
			node.setLeftChild(insertNode(node.getLeftChild(), data));
		}
		else{
			node.setRightChild(insertNode(node.getRightChild(), data));
		}
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		node=settleViolation(node,data);
		return node;
	}
	
	private Node settleViolation(Node node,int data){
		int balance=getBalance(node);
		if(balance>1 && data<node.getLeftChild().getData()){
			return rightRotation(node);
		}
		if(balance<-1 && data>node.getRightChild().getData()){
			return leftRotation(node);
		}
		if(balance>1 && node.getLeftChild().getData()<data){
			node.setLeftChild(leftRotation(node.getLeftChild()));
			return rightRotation(node);
		}
		if(balance<-1 && node.getRightChild().getData()>data){
			node.setRightChild(rightRotation(node.getRightChild()));
			return leftRotation(node);
		}
		return node;
	}
	
	private Node leftRotation(Node node){
		System.out.println("Left Rotation at : "+node.getData());
		Node tempNode=node.getRightChild();
		Node tempLeftNode=tempNode.getLeftChild();
		tempNode.setLeftChild(node);
		node.setRightChild(tempLeftNode);
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		tempNode.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		return tempNode;
	}
	
	private Node rightRotation(Node node){
		System.out.println("Right Rotation at : "+node.getData());
		Node tempNode=node.getLeftChild();
		Node tempRightNode=tempNode.getRightChild();
		tempNode.setRightChild(node);
		node.setLeftChild(tempRightNode);
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		tempNode.setHeight(Math.max(getHeight(tempNode.getLeftChild()), getHeight(node.getRightChild()))+1);
		return tempNode;
	}
	
	private int getBalance(Node node){
		if(node==null){
			return 0;
		}
		return getHeight(node.getLeftChild())-getHeight(node.getRightChild());
	}
	
	private int getHeight(Node node){
		if(node==null){
			return -1;
		}
		return node.getHeight();
	}
	
	public void delete(int data){
		this.rootNode=deleteNode(this.rootNode,data);
	}
	
	private Node deleteNode(Node node,int data){
		if(node==null){
			return node;
		}
		if(data<node.getData()){
			node.setLeftChild(deleteNode(node.getLeftChild(),data));
		}
		else if(data>node.getData()){
			node.setRightChild(deleteNode(node.getRightChild(), data));
		}
		else{
			if(node.getLeftChild()==null && node.getRightChild()==null){
				return null;
			}
			else if(node.getLeftChild()==null){
				Node tempNode=node.getRightChild();
				node=null;
				return tempNode;
			}
			else if(node.getRightChild()==null){
				Node tempNode=node.getLeftChild();
				node=null;
				return tempNode;
			}
			Node tempNode=getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(),tempNode.getData()));
		}
		node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1);
		return settleDeletion(node);
	}
	
	private Node settleDeletion(Node node){
		int balance=getBalance(node);
		if(balance>1){
			if(getBalance(node.getLeftChild())<0){
				node.setLeftChild(leftRotation(node.getLeftChild()));
			}
			return rightRotation(node);
		}
		
		if(balance<-1){
			if(getBalance(node.getRightChild())>0){
				node.setRightChild(rightRotation(node.getRightChild()));
			}
			return leftRotation(node);
		}
		return node;
		
	}
	
	private Node getPredecessor(Node node){
		while(node.getRightChild()!=null){
			node=node.getRightChild();
		}
		return node;
	}

}
