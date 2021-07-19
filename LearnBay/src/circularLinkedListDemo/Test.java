package circularLinkedListDemo;

public class Test {
	
	public static void main(String[] args) {
		CircularLinkedList cl=new CircularLinkedList();
		cl.insert(10);
		cl.insert(20);
		cl.insert(30);
		cl.traverseList();
		cl.insertAfter(20,40);
		System.out.println();
		cl.traverseList();
		cl.delete(30);
		System.out.println();
		cl.traverseList();
	}

}
