package date_30_03_2020;

public class StringDeletion {

	private static String[] dictonary = { "pintu", "geeksfor", "geeksgeeks", " forgeek" };
	private static int finalLength = 0;
	private static String finalString = "";

	public static void main(String[] args) {
		String inputString = "geeksforgeeks";
		getTheLargestWord(inputString);
		System.out.println("Largest word from dictonary : " + StringDeletion.finalString);
	}

	private static void getTheLargestWord(String inputString) {
		for (String tempString : dictonary) {
			if (tempString.length() <= inputString.length()) {
				getDifferenceFromSubsequence(tempString, inputString);
			}
		}
	}

	private static void getDifferenceFromSubsequence(String tempString, String inputString) {
		int temp1 = 0;
		int temp2 = 0;
		int count = 0;
		while (temp2 < inputString.length() && temp1 < tempString.length()) {
			if (tempString.charAt(temp1) == inputString.charAt(temp2)) {
				temp1++;
				temp2++;
				count++;
			} else {
				temp2++;
			}
		}
		if (count == tempString.length() && tempString.length() > finalLength) {
			finalLength = tempString.length();
			finalString = tempString;
		}
	}

}
