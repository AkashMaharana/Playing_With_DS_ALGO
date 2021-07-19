package algorithm;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {1,4,2,-5,8,-3,6,-4,9,10};
		sort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void sort(int[] arr,int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	private static void merge(int[] arr,int low,int mid,int high) {
		int n1=mid-low+1;
		int n2=high-mid;
		int[] temp1=new int[n1];
		int[] temp2=new int[n2];
		for(int i=0;i<n1;i++) {
			temp1[i]=arr[low+i];
		}
		for(int i=0;i<n2;i++) {
			temp2[i]=arr[mid+1+i];
		}
		int finalIndex=low;
		int i=0;
		int j=0;
		while(i<n1 && j<n2) {
			if(temp1[i]<temp2[j]) {
				arr[finalIndex]=temp1[i];
				i++;
			}
			else {
				arr[finalIndex]=temp2[j];
				j++;
			}
			finalIndex++;
		}
		while(i<n1) {
			arr[finalIndex]=temp1[i];
			i++;
			finalIndex++;
		}
		while(j<n2) {
			arr[finalIndex]=temp2[j];
			j++;
			finalIndex++;
		}
	}

}
