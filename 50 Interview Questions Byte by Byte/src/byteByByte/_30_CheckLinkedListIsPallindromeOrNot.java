package byteByByte;

public class _30_CheckLinkedListIsPallindromeOrNot {
	
	public static void main(String[] args) {
		LinkedListHelper helper=new LinkedListHelper();
		helper.addNode(1);
		helper.addNode(1);
		helper.addNode(2);
		helper.addNode(3);
		helper.addNode(2);
		helper.addNode(1);
		helper.addNode(1);
		System.out.println(checkIsPallindrome(helper.rootNode));
	}
	
	private static boolean checkIsPallindrome(LinkedNode node) {
		LinkedNode slowPointer=node;
		LinkedNode fastPointer=node;
		LinkedNode previousPointer=null;
		LinkedNode midNode=null;
		LinkedNode secondHalfHead=null;
		while(fastPointer!=null && fastPointer.nextNode!=null) {
			previousPointer=slowPointer;
			slowPointer=slowPointer.nextNode;
			fastPointer=fastPointer.nextNode.nextNode;
		}
		if(fastPointer!=null) {
			midNode=slowPointer;
			slowPointer=slowPointer.nextNode;
		}
		previousPointer.nextNode=null;
		secondHalfHead=slowPointer;
		LinkedNode reverseHead=reverse(secondHalfHead);
		boolean isPallindrome= checkPallindrome(node,reverseHead);
		reverse(reverseHead);
		if(midNode!=null) {
			midNode.nextNode=secondHalfHead;
		}
		else {
			previousPointer.nextNode=slowPointer;
		}
		return isPallindrome;
	}
	
	private static boolean checkPallindrome(LinkedNode node1, LinkedNode node2) {
		while(node1!=null && node2!=null) {
			if(node1.data==node2.data) {
				node1=node1.nextNode;
				node2=node2.nextNode;
			}
			else {
				return false;
			}
			
		}
		return true;
	}
	
	private static LinkedNode reverse(LinkedNode node) {
		LinkedNode previousPointer=null;
		LinkedNode currentPointer=node;
		LinkedNode nextPointer=null;
		while(currentPointer!=null) {
			nextPointer=currentPointer.nextNode;
			currentPointer.nextNode=previousPointer;
			previousPointer=currentPointer;
			currentPointer=nextPointer;
		}
		return previousPointer;
	}

}

class LinkedNode{
	int data;
	LinkedNode nextNode;
	
	public LinkedNode(int data) {
		this.data=data;
		this.nextNode=null;
	}
}

class LinkedListHelper{
	LinkedNode rootNode;
	
	public void addNode(int data) {
		if(rootNode==null) {
			rootNode=new LinkedNode(data);
		}
		else {
			insertAtTheEnd(rootNode,data);
		}
	}
	
	private void insertAtTheEnd(LinkedNode node,int data) {
		while(node.nextNode!=null) {
			node=node.nextNode;
		}
		node.nextNode=new LinkedNode(data);
	}
	
	public void traverse() {
		LinkedNode temp=rootNode;
		while(temp!=null) {
			System.out.println(temp.data+"->");
			temp=temp.nextNode;
		}
	}
	
	
}
