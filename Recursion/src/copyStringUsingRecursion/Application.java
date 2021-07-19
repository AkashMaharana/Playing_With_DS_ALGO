package copyStringUsingRecursion;

public class Application {
	
	public static void main(String[] args) {
		CopyStringUsingRecursion c=new CopyStringUsingRecursion();
		String s1="akash";
		char[] s2=new char[s1.length()];
		c.copyStringUsingRecursion(s1.toCharArray(),s2, s1.length()-1);
		System.out.println(String.valueOf(s2));
	}

}
