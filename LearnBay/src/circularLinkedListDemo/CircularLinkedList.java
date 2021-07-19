package circularLinkedListDemo;

public class CircularLinkedList {
	
	private int size;
	private Node lastNode;
	
	public void insert(int data){
		size=size+1;
		if(this.lastNode==null){
			Node newNode=new Node(data);
			this.lastNode=newNode;
			this.lastNode.setNext(this.lastNode);
		}
		else{
			insertAtBeginning(this.lastNode,data);
			//insertAtEnd(this.lastNode,data);
		}
	}
	
	private void insertAtBeginning(Node lastNode,int data){
		Node newNode=new Node(data);
		newNode.setNext(this.lastNode.getNext());
		this.lastNode.setNext(newNode);
	}
	
	private void insertAtEnd(Node lastNode,int data){
		Node newNode=new Node(data);
		newNode.setNext(this.lastNode.getNext());
		this.lastNode.setNext(newNode);
		this.lastNode=newNode;
	}
	
	public void traverseList(){
		Node tempNode=this.lastNode.getNext();
		do{
			System.out.print(tempNode.getData()+"->");
			tempNode=tempNode.getNext();
		}
		while(tempNode!=this.lastNode.getNext());
	}
	
	public int size(){
		return this.size;
	}
	
	public void insertAfter(int after,int data){
		if(this.lastNode==null){
			insert(data);
		}
		else{
			Node lastToNext=this.lastNode.getNext();
			do{
				if(lastToNext.getData()==after){
					Node newNode=new Node(data);
					newNode.setNext(lastToNext.getNext());
					lastToNext.setNext(newNode);
					if(lastToNext==this.lastNode){
						this.lastNode=newNode;
					}
				}
				lastToNext=lastToNext.getNext();
			}
			while(lastToNext!=this.lastNode);
		}
	}
	
	public void delete(int data){
		if(this.lastNode==null){
			System.out.println("List is Empty");
		}
		else{
			Node previousNode=this.lastNode;
			Node latestNode=this.lastNode.getNext();
			do{
				if(latestNode.getData()==data){
					previousNode.setNext(latestNode.getNext());
					break;
				}
				previousNode=previousNode.getNext();
				latestNode=latestNode.getNext();
			}
			while(true);
		}
	}
}
