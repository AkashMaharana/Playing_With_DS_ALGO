package byteByByte;

public class _7_SquareSubMatrix {
	
	public static void main(String[] args) {
		
		/*Given a 2D array of 1s and 0s, find the largest square sub array of all 1s.*/
		
		int[][] input= {{1,1,1,0},{1,1,1,1},{1,1,0,0}};
		System.out.println(findTheLargestSubMatrix(input));
		
	}
	
	private static int findTheLargestSubMatrix(int[][] input) {
		int[][] temp=new int[input.length][input[0].length];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<input[0].length;j++) {
				if(input[i-1][j-1]==1) {
					temp[i][j]=Math.min(temp[i-1][j-1], Math.min(temp[i-1][j], temp[i][j-1]))+1;
				}
				else {
					temp[i][j]=0;
				}
			}
		}
		return temp[temp.length-1][temp[0].length-1];
	}

}
