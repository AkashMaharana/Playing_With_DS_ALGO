package com.akash.maharana.linkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DoublyLinkedListInsert {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode headNode=head;
        if(headNode==null){
            DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
            headNode=newNode;
            return headNode;
        }
        if(headNode.data>data){
            DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
            newNode.next=headNode;
            headNode.prev=newNode;
            newNode.prev=null;
            headNode=newNode;
            return headNode;
        }
        else{
        	DoublyLinkedListNode currentNode=head;
        	DoublyLinkedListNode nextNode=head.next;
        	boolean isValid=true;
        	while(isValid){
        		if(nextNode==null){
            		DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
            		currentNode.next=newNode;
            		newNode.prev=currentNode;
            		newNode.next=null;
            		return head;
            	}
            	else{
            		if(nextNode.data>data){
            			DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
            			currentNode.next=newNode;
            			newNode.prev=currentNode;
            			newNode.next=nextNode;
            			nextNode.prev=newNode;
            			isValid=false;
            		}
            		else{
            			currentNode=currentNode.next;
            			nextNode=nextNode.next;
            		}
            	}
        	}
        }
        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/
    	DoublyLinkedList list = new DoublyLinkedList();
    	list.insertNode(1);
    	list.insertNode(2);
    	list.insertNode(3);
    	list.insertNode(5);
    	DoublyLinkedListNode node=sortedInsert(list.head, 7);
    	while(node!=null){
    		System.out.print(node.data+"->");
    		node=node.next;
    	}
    }
}
