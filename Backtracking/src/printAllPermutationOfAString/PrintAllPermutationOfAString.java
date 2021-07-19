package printAllPermutationOfAString;

public class PrintAllPermutationOfAString {
	
	public void printAllPermutationOfAString(String inputString){
		printPermutation(inputString, 0,inputString.length()-1);
	}
	
	public void printPermutation(String inputString,int startIndex,int endIndex){
		if(startIndex==endIndex){
			System.out.println(inputString);
		}
		else{
			for(int i=startIndex;i<=endIndex;i++){
				inputString=swap(inputString,startIndex,i);
				printPermutation(inputString, startIndex+1, endIndex);
				inputString=swap(inputString, startIndex, i);
			}
		}
	}
	
	
	private String swap(String inputString,int startIndex,int endIndex){
		char temp; 
        char[] charArray = inputString.toCharArray(); 
        temp = charArray[startIndex]; 
        charArray[startIndex] = charArray[endIndex]; 
        charArray[endIndex] = temp; 
        return String.valueOf(charArray);
	}

}
