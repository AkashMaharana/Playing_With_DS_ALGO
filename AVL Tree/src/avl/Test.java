package avl;

public class Test {
	
	public static void main(String[] args) {
		AVLTreeImpl avl=new AVLTreeImpl();
		avl.insert(3);
		avl.insert(5);
		avl.insert(4);
		avl.travere();
	}

}
