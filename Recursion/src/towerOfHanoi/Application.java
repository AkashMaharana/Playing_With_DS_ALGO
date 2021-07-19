package towerOfHanoi;

public class Application {
	
	public static void main(String[] args) {
		TowerOfHanoi tow=new TowerOfHanoi();
		tow.towerOfHanoi(7, 1, 2, 3);
		System.out.println("Count : "+tow.getCount());
	}

}
