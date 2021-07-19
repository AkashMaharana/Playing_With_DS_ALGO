package longestBitonicSubsequence;

public class LongestBitonicSubsequence {
	
	public void longestBitonicSubsequence(int[] inputArray){
		int[] tempArray1=new int[inputArray.length];
		int[] tempArray2=new int[inputArray.length];
		for(int i=0;i<inputArray.length;i++){
			tempArray1[i]=1;
			tempArray2[i]=1;
		}
		for(int i=1;i<inputArray.length;i++){
			int j=0;
			while(j<i){
				if(inputArray[j]<inputArray[i]){
					tempArray1[i]=Math.max(tempArray1[i], tempArray1[j]+1);
				}
				j++;
			}
		}
		for(int i=0,j=inputArray.length-1;i<j;i++,j--){
			int temp=inputArray[i];
			inputArray[i]=inputArray[j];
			inputArray[j]=temp;
		}
		for(int i=1;i<inputArray.length;i++){
			int j=0;
			while(j<i){
				if(inputArray[j]<inputArray[i]){
					tempArray2[i]=Math.max(tempArray2[i], tempArray2[j]+1);
				}
				j++;
			}
		}
		for(int i=0,j=tempArray2.length-1;i<j;i++,j--){
			int temp=tempArray2[i];
			tempArray2[i]=tempArray2[j];
			tempArray2[j]=temp;
		}
		int l1=0;
		int l2=0;
		int maxLength=0;
		while(l1<tempArray1.length && l2<tempArray2.length){
			if((tempArray1[l1]+tempArray1[l2])-1>maxLength){
				maxLength=(tempArray1[l1]+tempArray2[l2])-1;
			}
			l1++;
			l2++;
		}
		System.out.println("Longest Bitonic Subsequence : "+maxLength);
	}

}
