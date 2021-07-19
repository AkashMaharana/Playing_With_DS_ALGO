package printAllCombinationDemo;

public class Application {
	
	public static void main(String[] args) {
		PrintAllCombinationsOfGivenLength p=new PrintAllCombinationsOfGivenLength();
		char[] charSet = {'0','1'}; 
	    int desiredLength = 4; 
		p.printAllCombination(charSet, desiredLength);
	}

}
