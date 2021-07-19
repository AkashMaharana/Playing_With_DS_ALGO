package byteByByte;

public class _39_CloneALinkedList {

	public static void main(String[] args) {
		CloneNode root = new CloneNode(1);
		root.nextNode = new CloneNode(2);
		root.nextNode.nextNode = new CloneNode(3);
		root.nextNode.nextNode.nextNode = new CloneNode(4);
		root.nextNode.nextNode.nextNode.nextNode = new CloneNode(5);
		root.randomPointer = root.nextNode.nextNode;
		root.nextNode.randomPointer = root;
		root.nextNode.nextNode.randomPointer = root.nextNode.nextNode.nextNode.nextNode;
		root.nextNode.nextNode.nextNode.randomPointer = root.nextNode.nextNode;
		root.nextNode.nextNode.nextNode.nextNode.randomPointer = root.nextNode;
		System.out.println("OriginalList : ");
		print(root);
		CloneNode node=cloneList(root);
		System.out.println("Clone List : ");
		print(node);
		System.out.println("OriginalList : ");
		print(root);
	}

	private static void print(CloneNode temp1) {
		CloneNode node=temp1;
		while(node!=null){
			System.out.println("Data : "+node.data+" | Random : "+node.randomPointer.data);
			node=node.nextNode;
		}
		System.out.println();
	}

	private static CloneNode cloneList(CloneNode node) {
		CloneNode originalNode=node;
		CloneNode temp=null;
		while(originalNode!=null){
			temp=originalNode.nextNode;
			originalNode.nextNode=new CloneNode(originalNode.data);
			originalNode.nextNode.nextNode=temp;
			originalNode=temp;
		}
		originalNode=node;
		while(originalNode!=null){
			originalNode.nextNode.randomPointer=originalNode.randomPointer.nextNode;
			if(originalNode.nextNode!=null){
				originalNode=originalNode.nextNode.nextNode;
			}
			else{
				originalNode=originalNode.nextNode;
			}
		}
		originalNode=node;
		CloneNode actualNode=node;
		CloneNode copyNode=node.nextNode;
		CloneNode finalNode=copyNode;
		while(actualNode!=null && copyNode!=null){
			if(actualNode.nextNode!=null && copyNode.nextNode!=null){
				actualNode.nextNode=actualNode.nextNode.nextNode;
				copyNode.nextNode=copyNode.nextNode.nextNode;
				actualNode=actualNode.nextNode;
				copyNode=copyNode.nextNode;
			}
			else{
				actualNode=actualNode.nextNode;
				copyNode=copyNode.nextNode;
			}
		}
		return finalNode;
	}

}

class CloneNode {
	int data;
	CloneNode nextNode;
	CloneNode randomPointer;

	public CloneNode(int data) {
		this.data = data;
		this.nextNode = null;
		this.randomPointer = null;
	}
}
