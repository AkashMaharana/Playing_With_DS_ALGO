
public class TreeTest {
	
	public static void main(String[] args) {
		BSTImpl bst=new BSTImpl();
		bst.insert(2);
		bst.insert(-8);
		bst.insert(23);
		bst.insert(19);
		bst.insert(9);
		bst.insert(-7);
		bst.inOrderTraversal(bst.root);
		System.out.println();
		bst.deleteNode(bst.root, 2);
		bst.inOrderTraversal(bst.root);
	}

}
