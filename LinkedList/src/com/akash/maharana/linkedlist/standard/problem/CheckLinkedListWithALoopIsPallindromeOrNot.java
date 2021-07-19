package com.akash.maharana.linkedlist.standard.problem;

public class CheckLinkedListWithALoopIsPallindromeOrNot {
	
	public static void main(String[] args) {
		
		LoopNodePallindromeImpl ln=new LoopNodePallindromeImpl();
		ln.insert(50);
		LoopNodePallindrome secondNode=ln.insert(20);
		ln.insert(15);
		ln.insert(30);
		ln.insert(15);
		ln.insert(20);
		LoopNodePallindrome seventhNode=ln.insert(50);
		seventhNode.next=secondNode;
		System.out.println(ln.checkForPallindrome(ln.rootNode));
	}

}

class LoopNodePallindrome{
	int data;
	LoopNodePallindrome next;
	
	public LoopNodePallindrome(int data){
		this.data=data;
		this.next=null;
	}
}

class LoopNodePallindromeImpl{
	LoopNodePallindrome rootNode=null;
	
	public LoopNodePallindrome insert(int data){
		if(rootNode==null){
			LoopNodePallindrome newNode=new LoopNodePallindrome(data);
			rootNode=newNode;
			return rootNode;
		}
		else{
			LoopNodePallindrome root=this.rootNode;
			while(root.next!=null){
				root=root.next;
			}
			LoopNodePallindrome newNode=new LoopNodePallindrome(data);
			root.next=newNode;
			return newNode;
		}
	}
	
	public boolean checkForPallindrome(LoopNodePallindrome node){
		LoopNodePallindrome loopStartingNode=checkForLoopStartingNode(node);
		LoopNodePallindromeImpl l=new LoopNodePallindromeImpl();
		int count=0;
		while(node!=null){
			if(node!=loopStartingNode){
				l.insert(node.data);
				node=node.next;
			}
			else{
				if(count==0){
					l.insert(node.data);
					node=node.next;
					count=count+1;
				}
				else{
					break;
				}
			}
		}
		return checkPallindrome(l.rootNode);
	}
	
	public boolean checkPallindrome(LoopNodePallindrome node){
		boolean isPallindrome=false;
		LoopNodePallindrome slowPointer=node;
		LoopNodePallindrome fastPointer=node;
		LoopNodePallindrome previousToSlowPointer=node;
		LoopNodePallindrome secondhalfHead=null;
		if(node!=null){
			while(fastPointer!=null && fastPointer.next!=null){
				previousToSlowPointer=slowPointer;
				slowPointer=slowPointer.next;
				fastPointer=fastPointer.next.next;
			}
			if(fastPointer!=null){
				slowPointer=slowPointer.next;
			}
			secondhalfHead=slowPointer;
			previousToSlowPointer.next=null;
			LoopNodePallindrome secondHead=reverse(secondhalfHead);
			isPallindrome=compareList(node,secondHead);
		}
		return isPallindrome;
	}
	
	public boolean compareList(LoopNodePallindrome head1,LoopNodePallindrome head2){
		while(head1!=null && head2!=null){
			if(head1.data==head2.data){
				head1=head1.next;
				head2=head2.next;
				continue;
			}
			else{
				return false;
			}
		}
		if(head1==null && head2==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public LoopNodePallindrome reverse(LoopNodePallindrome node){
		LoopNodePallindrome currentNode=node;
		LoopNodePallindrome nextToCurrent=node.next;
		if(currentNode==null || nextToCurrent==null){
			return node;
		}
		LoopNodePallindrome tempNode=reverse(nextToCurrent);
		currentNode.next.next=currentNode;
		currentNode.next=null;
		return tempNode;
	}
	
	public LoopNodePallindrome checkForLoopStartingNode(LoopNodePallindrome node){
		LoopNodePallindrome slowPointer=node;
		LoopNodePallindrome fastPointer=node;
		LoopNodePallindrome commonNode=null;
		LoopNodePallindrome loopNode=null;
		while(slowPointer!=null && fastPointer!=null && fastPointer.next!=null){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
			if(slowPointer==fastPointer){
				commonNode=slowPointer;
				break;
			}
		}
		if(commonNode!=null){
			LoopNodePallindrome sNode=commonNode;
			LoopNodePallindrome fNode=commonNode;
			while(sNode!=null && fNode!=null){
				sNode=sNode.next;
				fNode=fNode.next;
				if(sNode==fNode){
					loopNode=sNode;
					break;
				}
			}
		}
		return loopNode;
	}
}
