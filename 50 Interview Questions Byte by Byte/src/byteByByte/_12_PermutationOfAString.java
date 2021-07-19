package byteByByte;

public class _12_PermutationOfAString {
	
	public static void main(String[] args) {
		String input="ABCDEFGHIJKL";
		printAllPermutaion(input,0,input.length()-1);
	}
	
	private static void printAllPermutaion(String input,int low,int high) {
		if(low==high) {
			System.out.println(input);
		}
		else {
			for(int i=low;i<=high;i++) {
				input=swap(input,low,i);
				printAllPermutaion(input, low+1, high);
				input=swap(input,low,i);
			}
		}
	}
	
	private static String swap(String input,int firstIndex,int secondIndex) {
		char[] inputChar=input.toCharArray();
		char temp=inputChar[firstIndex];
		inputChar[firstIndex]=inputChar[secondIndex];
		inputChar[secondIndex]=temp;
		return String.valueOf(inputChar);
	}

}
