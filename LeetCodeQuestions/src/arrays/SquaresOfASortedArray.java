package arrays;

public class SquaresOfASortedArray {
	
	public static void main(String[] args) {
		//{-12,-3,2,3,11}
		int[] A= {-3,-3,-2,1};
		squaresOfSortedArray(A);
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
	}
	
	private static void squaresOfSortedArray(int[] A) {
		int tempIndex=0;
        while(A[tempIndex]<0){
            tempIndex++;
        }
        int start1=tempIndex;
        int start2=tempIndex-1;
        int[] temp=new int[A.length];
        int start=0;
        while(start2>=0 && start1<A.length){
            if(A[start1]*A[start1]>A[start2]*A[start2]){
                temp[start]=A[start2]*A[start2];
                start2--;
            }
            else{
                temp[start]=A[start1]*A[start1];
                start1++;
            }
            start++;
        }
        while(start2>=0){
            temp[start]=A[start2]*A[start2];
            start++;
            start2--;
        }
        while(start1<A.length){
            temp[start]=A[start1]*A[start1];
            start++;
            start1++;
        }
        for(int i=0;i<temp.length;i++){
            A[i]=temp[i];
        }
	}

}
