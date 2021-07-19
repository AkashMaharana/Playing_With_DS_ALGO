package com.akash.maharana.linkedList;

public class LengthOfLongestPallindromeInALinkedList {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(2);
		l.insert(3);
		l.insert(7);
		l.insert(3);
		l.insert(2);
		l.insert(12);
		l.insert(24);
		System.out.println(lengthOfLongestPallindrome(l.getRootNode()));
	}

	private static int lengthOfLongestPallindrome(Node node) {
		int result = 0;
		Node prev = null;
		Node current = node;
		while (current != null) {
			Node next = current.getNextNode();
			current.setNextNode(prev);
			result = Math.max(result, 2 * countCommon(prev, next) + 1);
			result = Math.max(result, 2 * countCommon(current, next));
			prev = current;
			current = next;
		}
		return result;
	}

	private static int countCommon(Node node1, Node node2) {
		int count = 0;
		for (; node1 != null && node2 != null; node1 = node1.getNextNode(), node2 = node2.getNextNode())
			if (node1.getData() == node2.getData()) {
				++count;
			} else {
				break;
			}
		return count;
	}

}
