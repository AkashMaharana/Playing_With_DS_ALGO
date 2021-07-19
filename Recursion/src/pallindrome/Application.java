package pallindrome;

public class Application {
	
	public static void main(String[] args) {
		Pallindrome p=new Pallindrome();
		try{
			p.isPallindrome(1211211);
			System.out.println("Pallindrome");
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		System.out.println(p.isPallindromeReverse(121));
	}

}
