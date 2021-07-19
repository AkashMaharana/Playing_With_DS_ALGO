package longestCommonSubstring;

public class Application {
	
	public static void main(String[] args) {
		LongestCommonSubstring lcs=new LongestCommonSubstring();
		System.out.println("Length of Common Substring DP : "+lcs.longestCommonSubstring("GeeksforGeeks", "GeeksQuiz"));
		System.out.println("Length of Common Substring recursive : "+lcs.printLongestCommonSubstringRecursive
				(5, 5, 0, "Akash", "Light"));
	}

}	
