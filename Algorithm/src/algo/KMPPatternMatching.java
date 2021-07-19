package algo;

public class KMPPatternMatching {
	
	public static void main(String[] args) {
		String input="abxabcabcaby";
		String pattern="abcaby";
		System.out.println(patternMatch(input,pattern));
	}
	
	private static boolean patternMatch(String input,String pattern) {
		int[] patternNumber=new int[pattern.length()];
		int i=0;
		int j=1;
		patternNumber[0]=0;
		while(j<pattern.length()) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				patternNumber[j]=i+1;
				i++;
				j++;
			}
			else {
				if(i!=0) {
					i=patternNumber[i-1];
				}
				else {
					patternNumber[j]=0;
					j++;
				}
			}
		}
		
		int index1=0;
		int index2=0;
		int index3=0;
		while(index1<input.length() && index2<pattern.length()) {
			if(input.charAt(index1)==pattern.charAt(index2)) {
				index1++;
				index2++;
			}
			else {
				index2=0;
				index3++;
				index1=index3;
			}
		}
		return index2==pattern.length();
	}

}
