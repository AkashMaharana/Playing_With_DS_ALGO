package com.akash.maharana.linkedList;

public class DetectLoopInLinkedList {
	
	public static void main(String[] args) {
		LoopNodeImpl ln=new LoopNodeImpl();
		ln.insert(10);
		LoopNode secondNode=ln.insert(20);
		ln.insert(30);
		ln.insert(40);
		ln.insert(50);
		ln.insert(60);
		LoopNode seventhNode=ln.insert(70);
		seventhNode.next=secondNode;
		boolean isLoopPresent=ln.detectLoop();
		System.out.println(isLoopPresent);
	}

}

class LoopNodeImpl{
	LoopNode rootNode=null;
	
	public LoopNode insert(int data){
		if(rootNode==null){
			LoopNode newNode=new LoopNode(data);
			rootNode=newNode;
			return rootNode;
		}
		else{
			LoopNode root=this.rootNode;
			while(root.next!=null){
				root=root.next;
			}
			LoopNode newNode=new LoopNode(data);
			root.next=newNode;
			return newNode;
		}
	}
	
	public boolean detectLoop(){
		LoopNode slowPointer=this.rootNode;
		LoopNode fastPointer=this.rootNode;
		while(slowPointer!=null && fastPointer!=null && fastPointer.next!=null){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
			if(slowPointer==fastPointer){
				return true;
			}
		}
		return false;
	}
}

class LoopNode{
	int data;
	LoopNode next;
	
	public LoopNode(int data){
		this.data=data;
		this.next=null;
	}
}
