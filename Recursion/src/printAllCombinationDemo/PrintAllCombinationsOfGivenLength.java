package printAllCombinationDemo;

public class PrintAllCombinationsOfGivenLength {
	
	public void printAllCombination(char[] set,int desiredLength){
		printAllStrings(set,"",desiredLength);
	}
	
	private void printAllStrings(char[] set,String prefix,int desiredLength){
		if(desiredLength==0){
			System.out.println(prefix);
			return;
		}
		for(int i=0;i<set.length;i++){
			String newPrefix=prefix+set[i];
			printAllStrings(set, newPrefix, desiredLength-1);
		}
	}

}
