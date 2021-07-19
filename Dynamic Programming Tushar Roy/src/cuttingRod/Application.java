package cuttingRod;

public class Application {
	
	public static void main(String[] args) {
		int desiredLength=5;
		int[] price={2,5,7,8};
		CuttingRod cr=new CuttingRod();
		System.out.println("Total Cost : "+cr.maximumPrice(desiredLength, price));
	}

}
