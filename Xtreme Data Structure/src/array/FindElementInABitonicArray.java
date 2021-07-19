package array;

//A bitonic array is an array where the elements are first strongly increasing and then decreasing
public class FindElementInABitonicArray {

	public static void main(String[] args) {
		int[] arr = {1,2,7,4,3 };
		int bitonicIndex = findBitonicPoint(arr, 0, arr.length - 1);
		System.out.println("Element found at index : " + findElement(arr, 4, 0, arr.length - 1, bitonicIndex));
	}

	private static int findElement(int[] arr, int target, int low, int high, int bitonicIndex) {
		if (target > arr[bitonicIndex]) {
			return -1;
		} else if (target == arr[bitonicIndex]) {
			return bitonicIndex;
		} else {
			int temp=ascendingBinarySearch(arr,0,bitonicIndex-1,target);
			if(temp!=-1) {
				return temp;
			}
			return descendingBinarySearch(arr,bitonicIndex+1,arr.length-1,target);
		}

	}

	private static int findBitonicPoint(int[] arr, int low, int high) {
		if (low == high) {
			return low;
		}
		if (low + 1 == high && arr[low] >= arr[high]) {
			return low;
		}
		if (low + 1 == high && arr[high] > arr[low]) {
			return high;
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
			return findBitonicPoint(arr, low, mid - 1);
		} else {
			return findBitonicPoint(arr, mid + 1, high);
		}
	}
	
	private static int ascendingBinarySearch(int[] arr,int low,int high,int target) {
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[mid]>target) {
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
		return -1;
	}
	
	private static int descendingBinarySearch(int[] arr,int low,int high,int target) {
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[mid]<target) {
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
		return -1;
	}

}
