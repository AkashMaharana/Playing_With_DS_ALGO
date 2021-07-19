package byteByByte;

public class _9_SearchInARowWiseColumnWiseSortedMatrix {

	public static void main(String[] args) {
		int input[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		search(input,99);
	}
	
	private static void search(int[][] input,int number) {
		int i=0;
		int j=input[0].length-1;
		while(i<input.length && j>=0) {
			if(input[i][j]==number) {
				System.out.println("Index of number is : ("+i+","+j+")");
				return;
			}
			else {
				if(input[i][j]<number) {
					i++;
				}
				else if(input[i][j]>number) {
					j--;
				}
			}
		}
		System.out.println("Element not found");
	}

}
