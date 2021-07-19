package com.akash.maharana.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEqualNumberofZeroAndOne {

	public static void main(String[] args) {
		int[] input = {0, 0, 1, 1, 0};
		System.out.println("Length of largest sub array : "+lengthOfLargestSubArray(input));
	}
	
	private static int lengthOfLargestSubArray(int[] input) {
		Map<Integer,Integer> map=new HashMap<>();
		int maxLength=0;
		int[] temp=new int[input.length];
		for(int i=0;i<temp.length;i++) {
			if(input[i]==0) {
				temp[i]=-1;
			}
			else {
				temp[i]=input[i];
			}
		}
		int sum=0;
		int length=0;
		for(int i=0;i<temp.length;i++) {
			sum=sum+temp[i];
			if(map.containsKey(sum)) {
				length=i-map.get(sum);
				if(length>maxLength) {
					maxLength=length;
				}
			}
			else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}

}
