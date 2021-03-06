package byteByByte;

public class _6_ZeroMatrix {
	
	/*Given a boolean matrix, update it so that if any cell is true,all the cells in that row and column are true.*/ 
	
	public static void main(String[] args) {
		boolean[][] input= {{false,true,false}};
		
		//Apporach1 - Brute Force
		convertRowsAndColumns(input);
		
		System.out.println();
		
		//Apporach2 - Using Row and Column method
		convertRowAndColumnsMethod2(input);
		
		System.out.println();
		
		//approach3 - Space Optimized
		convertRowAndColumnSpaceOptimized(input);
	}

	private static void convertRowAndColumnSpaceOptimized(boolean[][] input) {
		boolean rowFlag=false;
		boolean columnFlag=false;
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(input[i][j]==true && i==0) {
					rowFlag=true;
				}
				if(input[i][j]==true && j==0) {
					columnFlag=true;
				}
				if(input[i][j]==true) {
					input[0][j]=true;
					input[i][0]=true;
				}
			}
		}
		for(int i=1;i<input.length;i++) {
			for(int j=1;j<input[i].length;j++) {
				if(input[0][j]==true || input[i][0]==true) {
					input[i][j]=true;
				}
			}
		}
		if(rowFlag) {
			for(int i=0;i<input[0].length;i++) {
				input[0][i]=true;
			}
		}
		if(columnFlag) {
			for(int i=0;i<input.length;i++) {
				input[i][0]=true;
			}
		}
		printMatrix(input);
	}

	private static void convertRowAndColumnsMethod2(boolean[][] input) {
		boolean[] row=new boolean[input.length];
		boolean[] column=new boolean[input[0].length];
		for(int i=0;i<input.length;i++) {
			row[i]=false;
		}
		for(int i=0;i<input[0].length;i++) {
			column[i]=false;
		}
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(input[i][j]==true) {
					row[i]=true;
					column[j]=true;
				}
			}
		}
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(row[i]==true || column[j]==true) {
					input[i][j]=true;
				}
			}
		}
		printMatrix(input);
	}

	private static void convertRowsAndColumns(boolean[][] input) {
		boolean temp[][]=new boolean[input.length][input[0].length];
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(input[i][j]==true) {
					transform(temp,i,j);
				}
			}
		}
		printMatrix(temp);
	}
	
	private static void transform(boolean[][] output,int rowIndex,int columnInex) {
		for(int i=0;i<output[0].length;i++) {
			output[rowIndex][i]=true;
		}
		for(int i=0;i<output.length;i++) {
			output[i][columnInex]=true;
		}
	}
	
	private static void printMatrix(boolean[][] output) {
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[i].length;j++) {
				System.out.print(output[i][j]+" ");
			}
			System.out.println();
		}
	}

}
