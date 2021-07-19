package recursion;

public class JosephusProblem {
	
	public static void main(String[] args) {
		int numberOfPerson=40;
		int position=7;
		System.out.println("Safe Position : "+josephus(numberOfPerson,position));
	}
	
	private static int josephus(int numberOfPersons,int position) {
		if(numberOfPersons==1) {
			return 1;
		}
		return (josephus(numberOfPersons-1, position)+(position-1))%numberOfPersons+1;
	}

}
