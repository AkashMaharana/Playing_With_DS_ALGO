package combination;

public class Combination {
	
	public int combination(int inputNumber, int selection){
		if((inputNumber==selection) || selection==0){
			return 1;
		}
		else{
			return combination(inputNumber-1, selection-1)+combination(inputNumber-1, selection);
		}
	}

}
