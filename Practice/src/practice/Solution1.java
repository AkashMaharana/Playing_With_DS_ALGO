package practice;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String reformat(String s) {
        List<Character> charList=new ArrayList<>();
        List<Character> integerList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                integerList.add(s.charAt(i));
            }
            else{
                charList.add(s.charAt(i));
            }
        }
        if(charList.size()==0 && integerList.size()==0){
            return "";
        }
        else if(charList.size()==1 && integerList.size()==0){
            return s;
        }
        else if(integerList.size()==1 && charList.size()==0){
            return s;
        }
        else if(charList.size()==integerList.size()+1){
            StringBuffer sb=new StringBuffer();
            int t=0;
            while(t<integerList.size()){
                sb.append(charList.get(t)+"");
                sb.append(integerList.get(t)+"");
                t++;
            }
            sb.append(charList.get(t));
            return sb.toString();
        }
        else if(integerList.size()==charList.size()+1){
            StringBuffer sb=new StringBuffer();
            int t=0;
            while(t<charList.size()){
                sb.append(charList.get(t)+"");
                sb.append(integerList.get(t)+"");
                t++;
            }
            sb.append(integerList.get(t));
            return sb.toString();
        }
        else{
            return "";
        }
    }
}