package pallindrome;

public class Pallindrome {
	
	public int isPallindrome(int inputNumber){
		return pallindromeUtil(inputNumber,inputNumber);
	}
	
	private int pallindromeUtil(int inputNumber, int duplicateNumber){
		if(inputNumber==0){
			return duplicateNumber;
		}
		else{
			duplicateNumber=pallindromeUtil(inputNumber/10, duplicateNumber);
		}
		if(inputNumber%10==duplicateNumber%10){
			return duplicateNumber/10;
		}
		else{
			throw new ArithmeticException("Not a pallindrome");
		}
	}
	
	//without extra space (without creating a new copy for check)
	
	//reverse the digit of the input number and check with the originalNumber
	
	public boolean isPallindromeReverse(int inputNumber){
		int temp=inputNumber;
		int reverseNumber=0;
		while(temp>0){
			reverseNumber=reverseNumber*10+temp%10;
			temp=temp/10;
		}
		if(inputNumber==reverseNumber){
			return true;
		}
		else{
			return false;
		}
	}

}
