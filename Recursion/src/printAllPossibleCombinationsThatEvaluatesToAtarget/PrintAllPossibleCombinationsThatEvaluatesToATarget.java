package printAllPossibleCombinationsThatEvaluatesToAtarget;

public class PrintAllPossibleCombinationsThatEvaluatesToATarget {
	
	public void printAllPossibleCombinations(String inputString,int target){
		printCombinations(-1,inputString,target,"",0,"");
	}
	
	private void printCombinations(int currentIndex,String inputString,int target,String operator,int tempValue,String expression){
		if(currentIndex>inputString.length()-1){
			if(tempValue==target){
				System.out.println("Expression : "+expression.substring(1));
			}
			return;
		}
		switch (operator){
		
			case "add":
				if(currentIndex==0){
					tempValue=Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"+"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				else{
					tempValue=tempValue+Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"+"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				break;
				
			case "sub":
				if(currentIndex==0){
					tempValue=Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"-"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				else{
					tempValue=tempValue-Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"-"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				break;
							
			case "mul":
				if(currentIndex==0){
					tempValue=Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"*"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				else{
					tempValue=tempValue*Integer.parseInt(inputString.charAt(currentIndex)+"");
					expression=expression+"*"+Integer.parseInt(inputString.charAt(currentIndex)+"");
				}
				break;
		}
		
		printCombinations(currentIndex+1, inputString, target, "add", tempValue, expression);
		if(target==tempValue) return;
		if(expression!=""){
			printCombinations(currentIndex+1, inputString, target, "sub", tempValue, expression);
			if(target==tempValue) return;
			printCombinations(currentIndex+1, inputString, target, "mul", tempValue, expression);
			if(target==tempValue) return;
		}
		
	}

}
