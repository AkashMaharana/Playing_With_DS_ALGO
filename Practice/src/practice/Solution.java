package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	
	public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<croakOfFrogs.length();i++){
            if(map.containsKey(croakOfFrogs.charAt(i))){
                map.put(croakOfFrogs.charAt(i),map.get(croakOfFrogs.charAt(i))+1);
            }
            else {
            	map.put(croakOfFrogs.charAt(i),1);
            }
        }
        String sound="croak";
        int total=0;
        while(true){
            for(int i=0;i<sound.length();i++){
                if(map.get(sound.charAt(i))==0){
                    return total;
                }
                else{
                    map.put(sound.charAt(i),map.get(sound.charAt(i))-1);
                }   
            }
            total=total+1;
        }
      
    }

}
