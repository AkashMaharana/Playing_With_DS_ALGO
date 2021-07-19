package byteByByte;

public class _41_SplitTheLinkedListIntoTwoEqualhalves {

	public static void main(String[] args) {
		SplitNode root = new SplitNode(1);
		root.nextNode = new SplitNode(2);
		root.nextNode.nextNode = new SplitNode(3);
		root.nextNode.nextNode.nextNode = new SplitNode(4);
		root.nextNode.nextNode.nextNode.nextNode=new SplitNode(5);
		splitList(root);
	}

	private static void splitList(SplitNode node) {
		SplitNode slowPointer = node;
		SplitNode firstPointer = node;
		SplitNode previousNode=null;
		while (slowPointer != null && firstPointer != null && firstPointer.nextNode != null) {
			previousNode=slowPointer;
			slowPointer = slowPointer.nextNode;
			firstPointer = firstPointer.nextNode.nextNode;
		}
		if (firstPointer != null) {
			if (firstPointer.nextNode == null) {
				SplitNode temp = slowPointer.nextNode;
				slowPointer.nextNode = null;
				firstPointer = temp;
			}
		} else {
			previousNode.nextNode=null;
			firstPointer = slowPointer;
		}

		while (node != null) {
			System.out.print(node.data + "->");
			node = node.nextNode;
		}
		System.out.println();
		while (firstPointer != null) {
			System.out.print(firstPointer.data + "->");
			firstPointer = firstPointer.nextNode;
		}
		System.out.println();

	}

}

class SplitNode {
	int data;
	SplitNode nextNode;

	public SplitNode(int data) {
		this.data = data;
		this.nextNode = null;
	}
}
