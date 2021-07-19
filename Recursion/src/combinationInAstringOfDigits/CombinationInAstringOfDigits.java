package combinationInAstringOfDigits;

public class CombinationInAstringOfDigits {
	
	public void combinationInAstringOfDigits(String inputNumber){
		for(int i=0;i<inputNumber.length();i++){
			printAllCombinations(inputNumber,i,inputNumber.length()-1,inputNumber.substring(0,i+1)+" ",i+1);
		}
	}
	
	private void printAllCombinations(String inputNumber,int startIndex,int endIndex,String tempString,int currentIndex){
		if(currentIndex>endIndex){
			System.out.println(tempString);
			return;
		}
		tempString=tempString+inputNumber.substring(currentIndex,currentIndex+1)+" ";
		printAllCombinations(inputNumber, startIndex, endIndex, tempString,currentIndex+1);
	}

}
