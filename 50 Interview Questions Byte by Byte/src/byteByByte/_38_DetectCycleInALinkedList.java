package byteByByte;

public class _38_DetectCycleInALinkedList {

	public static void main(String[] args) {
		DetectLinkedNode root = new DetectLinkedNode(1);
		root.nextNode = new DetectLinkedNode(2);
		root.nextNode.nextNode = new DetectLinkedNode(3);
		root.nextNode.nextNode.nextNode = new DetectLinkedNode(4);
		root.nextNode.nextNode.nextNode.nextNode = root.nextNode;
		System.out.println("Loop Detected : "+detectLoop(root));
	}

	private static boolean detectLoop(DetectLinkedNode node) {
		DetectLinkedNode slowPointer = node;
		DetectLinkedNode fastPointer = node;
		while (slowPointer != null && fastPointer != null && fastPointer.nextNode != null) {
			slowPointer = slowPointer.nextNode;
			fastPointer = fastPointer.nextNode.nextNode;
			if (slowPointer == fastPointer) {
				loopStartingPoint(node,fastPointer);
				return true;
			}
		}
		return false;
	}
	
	private static void loopStartingPoint(DetectLinkedNode slowPointer,DetectLinkedNode fastPointer) {
		while(slowPointer!=null && fastPointer!=null) {
			if(slowPointer==fastPointer) {
				System.out.println("Loop Starting Point : "+slowPointer.data);
				lengthOfLoop(slowPointer);
				return;
			}
			else {
				slowPointer=slowPointer.nextNode;
				fastPointer=fastPointer.nextNode;
			}
		}
	}
	
	private static void lengthOfLoop(DetectLinkedNode node) {
		DetectLinkedNode temp=node;
		int count=1;
		while(node.nextNode!=null) {
			if(node.nextNode!=temp) {
				node=node.nextNode;
				count++;
			}
			else {
				break;
			}
		}
		System.out.println("Length of Loop : "+count);
	}

}

class DetectLinkedNode {
	int data;
	DetectLinkedNode nextNode;

	public DetectLinkedNode(int data) {
		this.data = data;
		this.nextNode = null;
	}
}
