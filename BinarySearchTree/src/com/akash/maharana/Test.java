package com.akash.maharana;

public class Test {
	
	public static void main(String[] args) {
		BSTImplementation bst=new BSTImplementation();
		bst.insert(2);
		bst.insert(8);
		bst.insert(4);
		bst.insert(6);
		bst.insert(32);
		bst.insert(19);
		bst.insert(10);
		bst.insert(9);
		bst.insert(-1);
		bst.traverse();
		System.out.println();
		bst.delete(2);
		bst.traverse();
	}

}
