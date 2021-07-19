package doublyLinkedList;

public class DoublyLinkedList {

	private Node rootNode;
	private int size;

	public void addNode(int data) {
		this.size++;
		if (this.rootNode == null) {
			this.rootNode = new Node(data);
		}
		else{
			addNodeToTheEnd(data);
		}
	}
	
	private void addNodeToTheEnd(int data){
		Node currentNode=this.rootNode;
		while(currentNode.getNextNode()!=null){
			currentNode=currentNode.getNextNode();
		}
		Node newNode=new Node(data);
		currentNode.setNextNode(newNode);
		newNode.setPreviousNode(currentNode);
	}
	
	public void traverseList(){
		Node tempNode=this.rootNode;
		Node previousNode=null;
		while(tempNode!=null){
			System.out.println(tempNode);
			previousNode=tempNode;
			tempNode=tempNode.getNextNode();
		}
		//For printing in reverse order
		System.out.println();
		while(previousNode!=null){
			System.out.println(previousNode);
			previousNode=previousNode.getPreviousNode();
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public void deleteNode(int data){
		if(this.rootNode.getData()==data){
			this.size--;
			Node newNode=this.rootNode.getNextNode();
			this.rootNode=null;
			this.rootNode=newNode;
			this.rootNode.setPreviousNode(null);
		}
		else{
			Node previousNode=this.rootNode;
			Node currentNode=previousNode.getNextNode();
			while(currentNode!=null){
				if(currentNode.getData()==data){
					this.size--;
					Node newNode=currentNode.getNextNode();
					if(newNode!=null){
						previousNode.setNextNode(newNode);
						newNode.setPreviousNode(previousNode);
						currentNode.setNextNode(null);
						currentNode.setPreviousNode(null);
						previousNode=newNode;
						currentNode=newNode.getNextNode();
						break;
					}
					else{
						previousNode.setNextNode(null);
						currentNode.setPreviousNode(null);
						break;
					}
				}
				else{
					previousNode=currentNode;
					currentNode=currentNode.getNextNode();
				}
			}
			
		}
	}

}
