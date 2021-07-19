
public class DutchNationalFlagAlgo {
	
	public static void main(String[] args) {
		int[] arr= {1,0,2,0,1,2,2};
		sortArray(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void sortArray(int[] arr) {
		int index0=0;
		int index1=0;
		int index2=arr.length-1;
		while(index1<=index2) {
			switch(arr[index1]) {
				case 0 :
					int temp=arr[index0];
					arr[index0]=arr[index1];
					arr[index1]=temp;
					index0++;
					index1++;
					break;
				case 1:
					index1++;
					break;
				case 2 :
					int temp1=arr[index2];
					arr[index2]=arr[index1];
					arr[index1]=temp1;
					index2--;
					break;
			}
		}
	}

}
