package substringWithSameFirstAndLastCharacter;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithSameFirstAndLastCharacter {
	
	public void substringWithSameFirstAndLastCharacter(String inputString){
		List<String> indexList=new ArrayList<>();
		int count=0;
		for(int i=0;i<inputString.length();i++){
			for(int j=inputString.length()-1;j>=i;j--){
				if(inputString.charAt(i)==inputString.charAt(j)){
					count++;
					indexList.add(inputString.substring(i, j+1));
				}
			}
		}
		System.out.println("Total number of substring : "+count);
		for(String s :indexList){
			System.out.print(s+", ");
		}
	}

}
