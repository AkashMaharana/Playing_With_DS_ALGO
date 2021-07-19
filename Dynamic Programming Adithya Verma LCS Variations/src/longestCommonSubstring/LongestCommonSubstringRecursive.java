package longestCommonSubstring;

public class LongestCommonSubstringRecursive {
	
	public static void main(String[] args) {
		String s1="akash";
		String s2="ka";
		System.out.println("Length of longest common substring : "+longestCommonSubstring(s1,s2,s1.length(),s2.length(),0));
	}

	private static int longestCommonSubstring(String s1, String s2, int length1, int length2,int count) {
		if(length1==0 || length2==0) {
			return count;
		}
		if(s1.charAt(length1-1)==s2.charAt(length2-1)) {
			count=longestCommonSubstring(s1, s2, length1-1, length2-1, count+1);
		}
		count=Math.max(count, Math.max(longestCommonSubstring(s1, s2, length1-1, length2,0), 
				longestCommonSubstring(s1, s2, length1, length2-1,0)));
		return count;
	}

}
