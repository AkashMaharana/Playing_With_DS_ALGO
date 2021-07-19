package byteByByte;

import java.util.HashSet;
import java.util.Set;

public class _40_RemoveDuplicatesFromLinkedList {
	
	public static void main(String[] args) {
		DuplicateNode root=new DuplicateNode(1);
		root.nextNode=new DuplicateNode(2);
		root.nextNode.nextNode=new DuplicateNode(3);
		root.nextNode.nextNode.nextNode=new DuplicateNode(2);
		root.nextNode.nextNode.nextNode.nextNode=new DuplicateNode(1);
		printList(root);
		removeDuplicate(root);
		printList(root);
	}
	
	private static void printList(DuplicateNode head) { 
        while (head != null){ 
            System.out.print(head.data + "->"); 
            head = head.nextNode; 
        } 
        System.out.println();
    }
	
	private static void removeDuplicate(DuplicateNode node) {
		Set<Integer> set=new HashSet<>();
		DuplicateNode previousNode=null;
		while(node!=null) {
			if(set.contains(node.data)) {
				previousNode.nextNode=node.nextNode;
			}
			else {
				set.add(node.data);
				previousNode=node;
			}
			node=node.nextNode;
		}
	}

}

class DuplicateNode{
	int data;
	DuplicateNode nextNode;
	
	public DuplicateNode(int data) {
		this.data=data;
		this.nextNode=null;
	}
}
