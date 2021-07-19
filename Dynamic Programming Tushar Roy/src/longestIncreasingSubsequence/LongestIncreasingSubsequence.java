package longestIncreasingSubsequence;

public class LongestIncreasingSubsequence {
	
	public void longestIncreasingSubsequence(int[] inputArray){
		int[] tempArray=new int[inputArray.length];
		for(int i=0;i<tempArray.length;i++){
			tempArray[i]=1;
		}
		int maxLength=0;
		for(int i=1;i<inputArray.length;i++){
			int j=0;
			while(j<i){
				if(inputArray[j]<inputArray[i]){
					tempArray[i]=Math.max(tempArray[i], tempArray[j]+1);
				}
				if(maxLength<tempArray[i]){
					maxLength=tempArray[i];
				}
				j++;
			}
		}
		System.out.println("Length of Longest Increasing Subsequence : "+maxLength);
		for(int i=0;i<tempArray.length;i++){
			System.out.print(tempArray[i]+" ");
		}
	}

}
