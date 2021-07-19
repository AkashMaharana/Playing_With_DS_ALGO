package lengthOfAStringUsingRecursion;

public class LengthOfAStringUsingRecursion {
	
	public int lengthOfAString(String input){
		if(input.length()==0){
			return 0;
		}
		else{
			return 1+lengthOfAString(input.substring(1));
		}
	}

}
