package com.akash.maharana.stackWithArray;

public class Stack<T> {
	
	private T[] stack;
	private int noOfitems;
	
	public Stack(){
		this.stack=(T[]) new Object[1];
	}
	
	public void push(T data){
		if(noOfitems==stack.length){
			resize(2*this.stack.length);
		}
		this.stack[noOfitems++]=data;
	}
	
	public void resize(int capacity){
		T[] stackCopy=(T[])new Object[capacity];
		for(int i=0;i<noOfitems;++i){
			stackCopy[i]=this.stack[i];
		}
		this.stack=stackCopy;
	}
	
	public boolean isEmpty(){
		if(noOfitems==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return this.noOfitems;
	}
	
	public T pop(){
		T itemsToPop=this.stack[--noOfitems];
		if(noOfitems>0 && noOfitems==this.stack.length/4){
			resize(this.stack.length/2);
		}
		return itemsToPop;
	}
}
