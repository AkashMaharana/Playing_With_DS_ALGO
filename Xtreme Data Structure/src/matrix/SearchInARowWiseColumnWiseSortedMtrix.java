package matrix;

public class SearchInARowWiseColumnWiseSortedMtrix {

	public static void main(String[] args) {
		int[][] input = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };
		System.out.println(search(input,49));
	}
	
	private static boolean search(int[][] input,int target) {
		int i=0;
		int j=input[0].length-1;
		boolean isValid=false;
		while(i>=0 && i<input.length && j>=0 && j<input[0].length) {
			if(input[i][j]==target) {
				isValid=true;
				break;
			}
			if(target<input[i][j]) {
				j--;
			}
			else if(target>input[i][j]) {
				i++;
			}
		}
		return isValid;
	}

}
