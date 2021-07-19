package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class LengthOfLongestPalindrome {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(2);
		list.addNode(1);
		list.addNode(3);
		list.addNode(3);
		System.out.println(lengthOfLongestPalindrome(list.getRoootNode()));
	}
	
	private static int lengthOfLongestPalindrome(Node node){
		Node tempNode=node;
		Node previousNode=null;
		Node currentNode=node;
		int maxLength=0;
		while(currentNode!=null && currentNode.getNextNode()!=null){
			if(previousNode==null){
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
				maxLength=1;
			}
			else{
				previousNode.setNextNode(null);
				Node reverseHead1=reverse(tempNode);
				int count1=compareList(reverseHead1,currentNode.getNextNode());
				if((2*count1)+1>maxLength){
					maxLength=(2*count1+1);
				}
				previousNode.setNextNode(currentNode);
				Node next=currentNode.getNextNode();
				currentNode.setNextNode(null);
				Node reverseHead2=reverse(tempNode);
				int count2=compareList(reverseHead2,next);
				if(2*count2>maxLength){
					maxLength=2*count2;
				}
				currentNode.setNextNode(next);
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
			}
		}
		return maxLength;
	}
	
	private static int compareList(Node head1,Node head2){
		int count=0;
		while(head1!=null && head2!=null){
			if(head1.getData()==head2.getData()){
				count++;
				head1=head1.getNextNode();
				head2=head2.getNextNode();
			}
			else{
				return count;
			}
		}
		return count;
	}
	
	private static Node reverse(Node node){
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		while(currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

}
