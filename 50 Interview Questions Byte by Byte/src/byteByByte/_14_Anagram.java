package byteByByte;

public class _14_Anagram {
	
	public static void main(String[] args) {
		String s1="abcdn";
		String s2="bcadn";
		System.out.println(isAnagram(s1,s2));
	}
	
	private static boolean isAnagram(String s1,String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int[] countArray=new int[256];
		for(int i=0;i<s1.length();i++) {
			countArray[s1.charAt(i)]=countArray[s1.charAt(i)]+1;
		}
		for(int i=0;i<s2.length();i++) {
			countArray[s2.charAt(i)]=countArray[s2.charAt(i)]-1;
		}
		for(int i=0;i<countArray.length;i++) {
			if(countArray[i]>0) {
				return false;
			}
		}
		return true;
	}

}
