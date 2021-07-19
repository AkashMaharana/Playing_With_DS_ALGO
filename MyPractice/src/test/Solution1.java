package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    public int countLargestGroup(int n) {
        int end=n;
        int length=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int start=1;start<=n;start++){
            if(!map.containsKey(sumOfDigits(start))) {
            	while(end>=1){
                    if(sumOfDigits(start)==sumOfDigits(end)){
                        if(map.containsKey(start)){
                            map.get(start).add(end);
                            if(map.get(start).size()>length){
                                length=map.get(start).size();
                            }
                            end--;
                        }
                        else{
                            List<Integer> tempList=new ArrayList<>();
                            tempList.add(start);
                            tempList.add(end);
                            map.put(start,tempList);
                            if(map.get(start).size()>length){
                                length=map.get(start).size();
                            }
                            end--;
                        }
                    }
                    else{
                        end--;
                    }
                }
            	end=n;
            }
            else {
            	continue;
            }
        }
        map.forEach((key,value)->System.out.println(key+" : "+value));
        
        Set<Map.Entry<Integer,List<Integer>>> entrySet=map.entrySet();
        int count=0;
        int finalLength=0;
        for(Map.Entry<Integer, List<Integer>> entry : entrySet) {
        	if(finalLength<entry.getValue().size()) {
        		finalLength=entry.getValue().size();
        		count=1;
        		continue;
        	}
        	if(finalLength==entry.getValue().size()) {
        		count++;
        	}
        }
        
        return count;
    }
    
    public int sumOfDigits(int n){
        String input=n+"";
        int sum=0;
        for(int i=0;i<input.length();i++){
            sum=sum+Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return sum;
    }
}
