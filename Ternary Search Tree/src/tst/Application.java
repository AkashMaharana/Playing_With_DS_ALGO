package tst;

public class Application {
	
	public static void main(String[] args) {
		TernarySearchTree tst=new TernarySearchTree();
		tst.put("apple", 1);
		tst.put("orange", 2);
		tst.put("angur", 23);
		System.out.println(tst.get("angur"));
	}

}
