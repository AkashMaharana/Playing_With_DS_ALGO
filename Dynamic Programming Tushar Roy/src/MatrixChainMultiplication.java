
public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		int[] input= {3,4,5,6,2,5};
		System.out.println(totalMinimumCost(input));
	}
	
	private static int totalMinimumCost(int[] input) {
		int[][] temp=new int[input.length-1][input.length-1];
		int[][] partitionIndex=new int[input.length-1][input.length-1];
		int startColumn=1;
		String costAndPartition="";
		while(startColumn<temp[0].length) {
			int tempColumn=startColumn;
			int tempRow=0;
			while(tempColumn<temp[0].length) {
				costAndPartition=calculateCost(input,temp,tempRow,tempColumn);
				String[] result=costAndPartition.split(":");
				temp[tempRow][tempColumn]=Integer.parseInt(result[0]);
				partitionIndex[tempRow][tempColumn]=Integer.parseInt(result[1]);
				tempRow++;
				tempColumn++;
			}
			startColumn++;
		}
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<partitionIndex.length;i++) {
			for(int j=0;j<partitionIndex[0].length;j++) {
				System.out.print(partitionIndex[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		return temp[0][temp[0].length-1];
	}
	
	
	private static String calculateCost(int[] input,int[][] temp,int tempRow,int tempColumn) {
		int start=tempRow;
		int totalCost=Integer.MAX_VALUE;
		int partitionValue=0;
		while(start<tempColumn) {
			int total=temp[tempRow][start]+temp[start+1][tempColumn]+input[tempRow]*input[start+1]*input[tempColumn+1];
			if(total<totalCost) {
				totalCost=total;
				partitionValue=start;
			}
			start++;
		}
		return totalCost+":"+partitionValue;
	}

}
