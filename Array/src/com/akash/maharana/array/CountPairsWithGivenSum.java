package com.akash.maharana.array;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
	
	public static void main(String[] args) {
		int[] arr= {1, 1, 1, 1};
		System.out.println(countPairs(arr,2));
	}
	
	private static int countPairs(int[] arr,int target) {
		int count=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(map.get(target-arr[i])!=null) {
				count=count+map.get(target-arr[i]);
			}
			if(arr[i]==(target-arr[i])) {
				count--;
			}
		}
		return count/2;
	}

}
