package findAllEvenLengthBinarySequence;

public class FindAllEvenLengthBinarySequenceWithSameSumOfFirstAndSecondHalf {
	
	public void findAllEvenLengthBinarySequence(int sequenceLength){
		char[] output=new char[sequenceLength];
		printAllBinaryLengthStrings(0, output, 0, output.length-1);
	}
	
	private void printAllBinaryLengthStrings(int difference,char[] output,int startIndex,int endIndex){  
		if(startIndex>endIndex){
			if(difference==0){
				String tempString="";
				for(char c : output){
					tempString=tempString+c;
				}
				System.out.print(tempString);
				System.out.println();
			}
			return;
		}
		
		output[startIndex]='0';
		output[endIndex]='1';
		printAllBinaryLengthStrings(difference-1, output, startIndex+1, endIndex-1);
		
		output[startIndex]='1';
		output[endIndex]='1';
		printAllBinaryLengthStrings(difference, output, startIndex+1, endIndex-1);
		
		output[startIndex]='0';
		output[endIndex]='0';
		printAllBinaryLengthStrings(difference, output, startIndex+1, endIndex-1);
		
		output[startIndex]='1';
		output[endIndex]='0';
		printAllBinaryLengthStrings(difference+1, output, startIndex+1, endIndex-1);
	}

}
