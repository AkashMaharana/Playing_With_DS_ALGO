package problems;

public class PrintAllSubsetsOfAString {
	
	public static void main(String[] args) {
		String input="abc";
		printPowerSet(input,0,"");
	}
	
	private static void printPowerSet(String input,int index,String output) {
		if(input.length()==index) {
			System.out.println(output);
			return;
		}
		printPowerSet(input,index+1,output);
		printPowerSet(input, index+1, output+input.charAt(index));
	}

}
