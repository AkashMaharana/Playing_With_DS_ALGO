package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class AddTwoNumbersPresentedInLinkedList {
	
	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		LinkedList list2=new LinkedList();
		list1.addNode(5);
		list1.addNode(6);
		list1.addNode(3);
		list2.addNode(8);
		list2.addNode(4);
		list2.addNode(2);
		Node node=addTwoNumbers(list1.getRoootNode(),list2.getRoootNode());
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
		System.out.println();
	}
	
	private static Node addTwoNumbers(Node node1,Node node2){
		int count1=0;
		int count2=0;
		Node temp1=node1;
		Node temp2=node2;
		while(temp1.getNextNode()!=null){
			count1++;
			temp1=temp1.getNextNode();
		}
		count1++;
		while(temp2.getNextNode()!=null){
			count2++;
			temp2=temp2.getNextNode();
		}
		count2++;
		if(count1>count2){
			int difference=count1-count2;
			Node tempNode=node2;
			while(tempNode.getNextNode()!=null){
				tempNode=tempNode.getNextNode();
			}
			while(difference>0){
				Node newNode=new Node(0);
				tempNode.setNextNode(newNode);
				tempNode=newNode;
				difference--;
			}
		}
		else if(count2>count1){
			int difference=count2-count1;
			Node tempNode=node1;
			while(tempNode.getNextNode()!=null){
				tempNode=tempNode.getNextNode();
			}
			while(difference>0){
				Node newNode=new Node(0);
				tempNode.setNextNode(newNode);
				tempNode=newNode;
				difference--;
			}
		}
		
		Node tempNode=null;
		int sum=0;
		int remainder=0;
		int carry=0;
		while(node1!=null && node2!=null){
			if(carry==1){
				sum=node1.getData()+node2.getData()+carry;
			}
			else{
				sum=node1.getData()+node2.getData();
			}
			if(sum>=10){
				remainder=sum%10;
				if(remainder==0){
					carry=1;
					if(tempNode==null){
						tempNode=new Node(0);
					}
					else{
						Node temp=tempNode;
						while(temp.getNextNode()!=null){
							temp=temp.getNextNode();
						}
						temp.setNextNode(new Node(remainder));
					}
				}
				else{
					carry=1;
					if(tempNode==null){
						tempNode=new Node(remainder);
					}
					else{
						Node temp=tempNode;
						while(temp.getNextNode()!=null){
							temp=temp.getNextNode();
						}
						temp.setNextNode(new Node(remainder));
					}
				}	
			}
			else{
				carry=0;
				if(tempNode==null){
					tempNode=new Node(sum);
				}
				else{
					Node temp=tempNode;
					while(temp.getNextNode()!=null){
						temp=temp.getNextNode();
					}
					temp.setNextNode(new Node(sum));
				}
			}
			node1=node1.getNextNode();
			node2=node2.getNextNode();
		}
		return reverseList(tempNode);
	}
	
	private static Node reverseList(Node node){
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
