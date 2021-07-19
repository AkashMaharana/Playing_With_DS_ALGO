package recursion;

public class GenerateAllBalancedParanthesis {

	public static void main(String[] args) {
		int lengthOfParantesis = 6;
		generateAllParanthesis(lengthOfParantesis/2, 0, 0, "");
	}

	private static void generateAllParanthesis(int length,int openCount, int closeCount, String output) {
		if(closeCount==length) {
			System.out.println(output);
			return;
		}
		else {
			if(openCount>closeCount) {
				generateAllParanthesis(length, openCount, closeCount+1, output+"}");
			}
			if(openCount<length) {
				generateAllParanthesis(length, openCount+1, closeCount, output+"{");
			}
		}
	}

}
