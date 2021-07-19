package coinChanging;

public class Application {
	
	public static void main(String[] args) {
		int total = 12;
        int coins[] = {7, 3, 2, 6};
        MinimumNumberOfCoinsToMakeASum minimumNumber=new MinimumNumberOfCoinsToMakeASum();
        minimumNumber.minimumNumberOfwaysDP(coins, total);
	}

}
