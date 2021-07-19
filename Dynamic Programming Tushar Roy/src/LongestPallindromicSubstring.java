
public class LongestPallindromicSubstring {

	public static void main(String[] args) {
		String input="aaaabbaa";
		System.out.println(longestPallindromicSubstring(input,0,input.length()-1,0));
	}
	
	private static int longestPallindromicSubstring(String input,int start,int end,int count) {
		if(start>end) {
			return count;
		}
		if(start==end) {
			return count+1;
		}
		if(input.charAt(start)==input.charAt(end)) {
			count=longestPallindromicSubstring(input, start+1, end-1, count+2);
			return Math.max(count, Math.max(longestPallindromicSubstring(input, start, end-1 , 0),
					longestPallindromicSubstring(input, start+1, end, 0)));
		}
		return Math.max(longestPallindromicSubstring(input, start+1, end, 0),
				longestPallindromicSubstring(input, start, end-1, 0));
	}
}
