package com.akash.maharana.linkedlist.standard.problem;

public class RemoveDuplicatesFromLinkedList {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(1);
		l.insert(2);
		l.insert(2);
		l.insert(1);
		l.insert(1);
		l.traverseList(removeDuplicates(l.getRootNode()));
	}
	
	private static Node removeDuplicates(Node head){
		if(head==null){
            return null;
        }
		if(head.getNextNode()==null){
			return head;
		}
        Node previousNode=head;
        while(previousNode!=null && previousNode.getNextNode()!=null){
            if(previousNode.getData()==previousNode.getNextNode().getData()){
                Node tempNode=previousNode.getNextNode();
                previousNode.setNextNode(previousNode.getNextNode().getNextNode());
                tempNode=null;
            }
            else{
                previousNode=previousNode.getNextNode();
            }
        }
        return head;
	}

}
