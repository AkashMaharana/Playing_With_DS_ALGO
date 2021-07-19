package com.akash.maharana.standardProblems;

import java.util.ArrayList;
import java.util.List;

public class PoisonousPlants {
	
	public static void main(String[] args) {
		int[] p={6,5,8,4,7,10,9};
		System.out.println(poisonousPlants(p));
	}
	
	private static int poisonousPlants(int[] p){
		return findDays(p,0);
	}
	
	private static int findDays(int[] p,int noOfDays){
		if(isValid(p)){
			return noOfDays;
		}
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<p.length-1;i++){
			if(p[i]<p[i+1]){
				list.add(p[i]);
			}
			else{
				continue;
			}
		}
		list.add(p[p.length-1]);
		int[] tempArray=new int[list.size()];
		for(int i=0;i<list.size();i++){
			tempArray[i]=list.get(i);
		}
		return findDays(tempArray,noOfDays+1);
	}
	
	private static boolean isValid(int[] p){
		for(int i=1;i<p.length;i++){
			if(p[i-1]>p[i]){
				return false;
			}
		}
		return true;
	}

}
