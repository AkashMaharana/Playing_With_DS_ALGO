package cuttingRod;

public class CuttingRod {

	public int maximumPrice(int desiredLength, int[] price) {
		int[][] totalMatrix = new int[price.length + 1][desiredLength + 1];
		for (int i = 1; i < totalMatrix.length; i++) {
			for (int j = 1; j < totalMatrix[i].length; j++) {
				if (j >= i) {
					totalMatrix[i][j] = Math.max(totalMatrix[i - 1][j], price[i - 1] + totalMatrix[i][j - i]);
				} else {
					totalMatrix[i][j] = totalMatrix[i - 1][j];
				}
			}
		}
		System.out.print("Length of Rods : ");
		showLengthOfRods(totalMatrix, totalMatrix[price.length][desiredLength]);
		return totalMatrix[price.length][desiredLength];
	}

	private void showLengthOfRods(int[][] totalMatrix, int totalPrice) {
		int i;
		int j;
		for (i = totalMatrix.length - 1; i > 0; i--) {
			if(i!=1){
				for (j = totalMatrix[0].length - 1; j > 0; j--) {
					if (totalMatrix[i][j] == totalMatrix[i - 1][j]) {
						i = i - 1;
						break;
					} else {
						System.out.print(i + " ");
						j = j - i;
					}
				}
			}
			else{
				System.out.print(i+" ");
				break;
			}
		}
		System.out.println();
	}

}
