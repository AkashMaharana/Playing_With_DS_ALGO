package com.akash.maharana.linkedList;

public class PairWiseSwap {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		l.insert(60);
		l.insert(70);
		l.insert(80);
		l.insert(90);
		l.insert(100);
		l.insert(110);
		Node finalNode=pairwiseSwap(l.getRootNode());
		while(finalNode!=null){
			System.out.print(finalNode.getData()+"->");
			finalNode=finalNode.getNextNode();
		}
	}
	
	private static Node pairwiseSwap(Node node){
		Node currentNode=node;
		Node currentToNext=currentNode.getNextNode();
		Node finalHead=null;
		Node previousNode=null;
		while(currentNode!=null && currentToNext!=null){
			Node temp1=currentNode;
			Node temp2=currentToNext;
			if(finalHead==null){
				temp1.setNextNode(temp2.getNextNode());
				temp2.setNextNode(temp1);
				finalHead=temp2;
				currentNode=temp1.getNextNode();
				currentToNext=currentNode.getNextNode();
				previousNode=temp1;
			}
			else{
				temp1.setNextNode(temp2.getNextNode());
				temp2.setNextNode(temp1);
				previousNode.setNextNode(temp2);
				previousNode=temp1;
				if(temp1.getNextNode()!=null && temp1.getNextNode().getNextNode()!=null){
					currentNode=temp1.getNextNode();
					currentToNext=currentNode.getNextNode();
					previousNode=temp1;
				}
				else{
					break;
				}
			}
			
		}
		return finalHead;
	}

}
