package recursion;

public class PermutationWithCaseChange {
	
	public static void main(String[] args) {
		String input="abc";
		permutationWithCaseChange(input,"",0);
	}
	
	private static void permutationWithCaseChange(String input,String output,int index) {
		if(input.length()==index) {
			System.out.println(output);;
			return;
		}
		permutationWithCaseChange(input, output+input.charAt(index), index+1);
		permutationWithCaseChange(input, output+((input.charAt(index)+"").toUpperCase()), index+1);
	}

}
