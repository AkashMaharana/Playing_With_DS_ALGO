package maximumSumNonAdjacentElement;

public class MaximumSumNonAdjacentElements {
	
	public void maximumSumNonAdjacentElement(int[] inputArray){
		int inclusive=inputArray[0];
		int exclusive=0;
		for(int i=1;i<inputArray.length;i++){
			int temp=inclusive;
			inclusive=Math.max(exclusive+inputArray[i], inclusive);
			exclusive=temp;
		}
		System.out.println("Inclusive : "+inclusive);
		System.out.println("Exclusive : "+exclusive);
	}

}
