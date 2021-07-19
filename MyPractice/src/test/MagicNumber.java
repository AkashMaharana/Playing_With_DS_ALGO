package test;

public class MagicNumber {
	
	private static int sum=0;
	
	public static void main(String[] args) {
		int input=17;
		sum=input;
		while(!checkSum(sum) && sum<Integer.MAX_VALUE) {
			String number=sum+"";
			int count=0;
			for(int i=0;i<number.length();i++) {
				count=count+Integer.parseInt(number.charAt(i)+"")*Integer.parseInt(number.charAt(i)+"");
			}
			if(sum==4) {
				break;
			}
			else {
				sum=count;
			}
		}
		if(checkSum(sum)) {
			System.out.println("Magic Number");
		}
		else {
			System.out.println("Not a magic Number");
		}
	}
	
	public static boolean checkSum(int input) {
		int sum=0;
		String number=input+"";
		for(int i=0;i<number.length();i++) {
			sum=sum+Integer.parseInt(number.charAt(i)+"");
		}
		return sum==1;
	}

}
