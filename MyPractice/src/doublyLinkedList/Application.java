package doublyLinkedList;

public class Application {
	
	public static void main(String[] args) {
		DoublyLinkedList dbl=new DoublyLinkedList();
		dbl.addNode(10);
		dbl.addNode(20);
		dbl.addNode(30);
		dbl.addNode(40);
		dbl.addNode(50);
		dbl.traverseList();
		System.out.println("Size : "+dbl.size());
		System.out.println();
		dbl.deleteNode(50);
		dbl.traverseList();
		System.out.println("Size : "+dbl.size());
	}

}
