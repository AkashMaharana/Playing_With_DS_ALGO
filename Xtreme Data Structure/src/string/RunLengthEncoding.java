package string;

public class RunLengthEncoding {
	
	public static void main(String[] args) {
		String input="wwwwaaadexxxxxxywww";
		encode(input);
	}
	
	private static void encode(String input) {
		for(int i=0;i<input.length();i++) {
			int count=1;
			while(i<input.length()-1 && input.charAt(i)==input.charAt(i+1)) {
				count++;
				i++;
			}
			System.out.print(input.charAt(i));
			System.out.print(count);
		}
	}

}
