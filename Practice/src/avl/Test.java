package avl;

public class Test {
	
	public static void main(String[] args) {
		AVLImpl avl=new AVLImpl();
		avl.insert(3);
		avl.insert(5);
		avl.insert(7);
		avl.insert(6);
		avl.traverse();
		System.out.println();
		System.out.println();
		avl.delete(3);
		avl.traverse();
	}

}
