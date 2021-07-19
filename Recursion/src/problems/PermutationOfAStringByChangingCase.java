package problems;

public class PermutationOfAStringByChangingCase {
	
	public static void main(String[] args) {
		String input="a1b2C3";
		printAllPermutationOfStringByChangingCase(input,"",0);
	}
	
	private static void printAllPermutationOfStringByChangingCase(String input,String output,int index) {
		if(input.length()==index) {
			System.out.println(output);
			return;
		}
		if(Character.isDigit(input.charAt(index))) {
			printAllPermutationOfStringByChangingCase(input, output+input.charAt(index), index+1);
		}
		else {
			printAllPermutationOfStringByChangingCase(input, output+(input.charAt(index)+"").toLowerCase(), index+1);
			printAllPermutationOfStringByChangingCase(input, output+(input.charAt(index)+"").toUpperCase(), index+1);
		}
	}

}
