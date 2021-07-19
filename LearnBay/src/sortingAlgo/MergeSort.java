package sortingAlgo;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr={12, 11, 13, 5, 6, 7};
		printArray(arr);
		mergeSort(arr,0,arr.length-1);
		printArray(arr);
	}
	
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	private static void mergeSort(int[] arr,int startIndex,int endIndex){
		if(startIndex<endIndex){
			int midIndex=(endIndex+startIndex)/2;
			
			mergeSort(arr,startIndex,midIndex);
			mergeSort(arr,midIndex+1,endIndex);
			
			merge(arr,startIndex,midIndex,endIndex);
		}
	}
	
	private static void merge(int[] arr,int startIndex,int midIndex,int endIndex){
		int n1=midIndex-startIndex+1;
		int n2=endIndex-midIndex;
		int[] arr1=new int[n1];
		int[] arr2=new int[n2];
		for(int i=0;i<n1;i++){
			arr1[i]=arr[startIndex+i];
		}
		for(int i=0;i<n2;i++){
			arr2[i]=arr[midIndex+1+i];
		}
		int i=0;
		int j=0;
		int resultantIndex=startIndex;
		while(i<n1 && j<n2){
			if(arr1[i]<=arr2[j]){
				arr[resultantIndex]=arr1[i];
				i++;
			}
			else{
				arr[resultantIndex]=arr2[j];
				j++;
			}
			resultantIndex++;
		}
		while(i<n1){
			arr[resultantIndex]=arr1[i];
			i++;
			resultantIndex++;
		}
		while(j<n2){
			arr[resultantIndex]=arr2[j];
			j++;
			resultantIndex++;
		}
	}

}
