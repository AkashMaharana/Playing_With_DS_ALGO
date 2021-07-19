package byteByByte;

public class _42_NthElementFromLastOfLinkedList {
	
	public static void main(String[] args) {
		NNode root=new NNode(1);
		root.nextNode=new NNode(2);
		root.nextNode.nextNode=new NNode(3);
		root.nextNode.nextNode.nextNode=new NNode(4);
		root.nextNode.nextNode.nextNode.nextNode=new NNode(5);
		root.nextNode.nextNode.nextNode.nextNode.nextNode=new NNode(6);
		System.out.println(nthNodeFromLast(root,3));
	}
	
	private static int nthNodeFromLast(NNode node,int number) {
		NNode slowPointer=node;
		while(number>0 && node!=null) {
			node=node.nextNode;
			number--;
		}
		while(node!=null) {
			slowPointer=slowPointer.nextNode;
			node=node.nextNode;
		}
		return slowPointer.data;
	}

}

class NNode{
	int data;
	NNode nextNode;
	
	public NNode(int data) {
		this.data=data;
		this.nextNode=null;
	}
}
