package bst;

public class BSTTest {
	
	public static void main(String[] args) {
		BSTImpl bst=new BSTImpl();
		bst.insert(10);
		bst.insert(6);
		bst.insert(4);
		bst.insert(11);
		bst.insert(5);
		bst.insert(-1);
		bst.insert(15);
		bst.insert(14);
		bst.insert(2);
		bst.insert(19);
		bst.traverse();
		bst.delete(10);
		bst.traverse();
	}

}
