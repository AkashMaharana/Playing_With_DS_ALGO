package recursion;

public class PermutationWithSpaces {

	public static void main(String[] args) {
		String input = "ABC";
		printPermutationWithSpaces(input.substring(1, input.length()), input.substring(0, 1), 0);
	}

	private static void printPermutationWithSpaces(String input, String output, int index) {
		if(input.length()==index) {
			System.out.println(output);
			return;
		}
		printPermutationWithSpaces(input, output+input.charAt(index), index+1);
		printPermutationWithSpaces(input, output+"_"+input.charAt(index), index+1);
	}

}
