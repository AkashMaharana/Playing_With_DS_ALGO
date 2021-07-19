package minimumNumberOfInsertionAndDeletionToConvertOneStringToOther;

public class MinimumNumberOfInsertionAndDeletionToConvertOneStringToOther {

	public static void main(String[] args) {
		String s1 = "heap";
		String s2 = "pea";
		System.out.println("Minimum number of insertion required : "
				+ minimumNumber(s1, s2).substring(1, minimumNumber(s1, s2).length()));
		System.out.println("Minimum number of deletion required : " + minimumNumber(s1, s2).substring(0, 1));
	}

	private static String minimumNumber(String s1, String s2) {
		int[][] temp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				} else {
					temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
				}
			}
		}
		int lcs = temp[s1.length()][s2.length()];
		StringBuffer sb = new StringBuffer();
		sb.append(s1.length() - lcs);
		sb.append(s2.length() - lcs);
		return sb.toString();
	}

}
