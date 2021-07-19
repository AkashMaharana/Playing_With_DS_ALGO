package circularLinkedList;

public class Application {
	
	public static void main(String[] args) {
		CircularLinkedList cl=new CircularLinkedList();
		cl.addNode(10);
		cl.addNode(20);
		cl.addNode(30);
		cl.addNode(40);
		cl.addNode(50);
		cl.traverse();
		System.out.println();
		cl.deleteNode(40);
		cl.traverse();
	}

}
