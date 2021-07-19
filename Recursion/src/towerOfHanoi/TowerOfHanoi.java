package towerOfHanoi;

public class TowerOfHanoi {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void towerOfHanoi(int noOfTower, int tower1, int tower2, int tower3) {
		if (noOfTower > 0) {
			towerOfHanoi(noOfTower - 1, tower1, tower3, tower2);
			System.out.println("Move from (" + tower1 + "," + tower3 + ")");
			count=count+1;
			towerOfHanoi(noOfTower - 1, tower2, tower1, tower3);
		}
	}

}
