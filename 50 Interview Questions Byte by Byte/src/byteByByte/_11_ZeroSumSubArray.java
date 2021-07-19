package byteByByte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _11_ZeroSumSubArray {
	
	public static void main(String[] args) {
		int[] input = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		printAllSubArraysHavingSumZero(input);
	}
	
	private static void printAllSubArraysHavingSumZero(int[] input) {
		Map<Integer,List<Integer>> zeroMap=new HashMap<>();
		int sum=0;
		Set<Integer> finalList=new LinkedHashSet<>();
		for(int i=0;i<input.length;i++) {
			sum=sum+input[i];
			if(zeroMap.containsKey(sum)) {
				zeroMap.get(sum).add(i);
				finalList.add(sum);
			}
			else {
				List<Integer> list=new ArrayList<>();
				list.add(i);
				zeroMap.put(sum, list);
			}
		}
		//zeroMap.entrySet().stream().forEach((key)->System.out.println(key.getKey()+":"+key.getValue()));
		printResult(finalList,zeroMap);
		if(zeroMap.containsKey(0)) {
			System.out.println(0+","+zeroMap.get(0).get(0));
		}
	}
	
	private static void printResult(Set<Integer> finalList,Map<Integer,List<Integer>> zeroMap) {
		finalList.stream().forEach(number->{
			List<Integer> numberList=zeroMap.get(number);
			for(int i=0;i<=numberList.size()-2;i++) {
				System.out.println(numberList.get(i)+1+","+numberList.get(i+1));
			}
		});
	}

}
