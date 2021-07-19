package totalNoOfWaysToMakeADenomination;

public class Application {
	
	public static void main(String[] args) {
		totalNumberOfWaysToMakeADenomination ways=new totalNumberOfWaysToMakeADenomination();
		int[] denomination={2,5,3,6};
		ways.minimumNumberOfWays(denomination, 10);
	}

}
