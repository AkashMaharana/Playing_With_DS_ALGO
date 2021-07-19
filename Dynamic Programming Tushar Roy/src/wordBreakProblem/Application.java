package wordBreakProblem;

import java.util.HashSet;
import java.util.Set;

public class Application {
	
	public static void main(String[] args) {
		Set<String> dictonary = new HashSet<String>();
        dictonary.add("I");
        dictonary.add("am");
        dictonary.add("ace");
        dictonary.add("pace");
        String inputString = "Iamace";
        WordBreakingProblem wbp=new WordBreakingProblem();
        wbp.wordBreakProblem(dictonary, inputString);
	}

}
