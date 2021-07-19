package problems;

public class PrintNBitBinaryNumbershavingMoreOneThanZeroInAllPrefixes {
	
	public static void main(String[] args) {
		int length=4;
		printNBitBinaryNumbers(length,0,0,"");
	} 
	
	private static void printNBitBinaryNumbers(int length,int oneCount,int zeroCount,String output) {
		if(output.length()==length) {
			System.out.println(output);
			return;
		}
		if(oneCount>zeroCount) {
			printNBitBinaryNumbers(length, oneCount, zeroCount+1, output+"0");
		}
		printNBitBinaryNumbers(length, oneCount+1, zeroCount, output+"1");
	}

}
