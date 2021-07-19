package byteByByte;

public class StockBuySell {
	
	public static void main(String[] args) {
		int[] input= {100,80,120,130,70,60,100,125};
		System.out.println(maximumProfit(input));
	}
	
	private static int maximumProfit(int[] input) {
		int profit=0;
		int minIndex=0;
		for(int i=1;i<input.length;i++) {
			if(input[minIndex]>input[i]) {
				minIndex=i;
			}
			else {
				if(input[i]-input[minIndex]>profit) {
					profit=input[i]-input[minIndex];
				}
			}
		}
		return profit;
	}

}
