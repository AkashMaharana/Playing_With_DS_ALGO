package problems;

public class KthSymbolinGrammar {
	
	public static void main(String[] args) {
		int n=5;
		int k=6;
		System.out.println(generateKthSymbol(n,k));
	}
	
	private static int generateKthSymbol(int n,int k) {
		if(n==1) {
			return 0;
		}
		int mid=(int) (Math.pow(2, n-1)/2);
		if(k<=mid) {
			return generateKthSymbol(n-1, k);
		}
		else {
			return generateKthSymbol(n-1, k-mid)==1?0:1;
		}
	}

}
