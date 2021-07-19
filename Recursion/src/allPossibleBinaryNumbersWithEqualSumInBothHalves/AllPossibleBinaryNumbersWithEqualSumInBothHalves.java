package allPossibleBinaryNumbersWithEqualSumInBothHalves;

public class AllPossibleBinaryNumbersWithEqualSumInBothHalves {
	
	public void allPossibleBinaryNumbersWithEqualSumInBothHalves(int length){
		int[] binaryArray=new int[length];
		printAllPossibleBinaryNumbers(binaryArray,0,binaryArray.length-1,0);
	}
	
	private void printAllPossibleBinaryNumbers(int[] binaryArray, int startIndex,int endIndex,int difference){
		if(startIndex>endIndex){
			if(difference==0){
				String s="";
				for(Integer i : binaryArray){
					s=s+i;
				}
				System.out.println(s);
			}
			return;
		}
		
		if(startIndex==endIndex){
			if(difference==0){
				binaryArray[startIndex]=0;
				String s="";
				for(Integer i : binaryArray){
					s=s+i;
				}
				System.out.println(s);
				binaryArray[startIndex]=1;
				String ss="";
				for(Integer i : binaryArray){
					ss=ss+i;
				}
				System.out.println(ss);
			}
			return;
		}
		
		binaryArray[startIndex]=1;
		binaryArray[endIndex]=1;
		printAllPossibleBinaryNumbers(binaryArray, startIndex+1, endIndex-1, difference);
		
		binaryArray[startIndex]=1;
		binaryArray[endIndex]=0;
		printAllPossibleBinaryNumbers(binaryArray, startIndex+1, endIndex-1, difference+1);
		
		if(startIndex>0){
			binaryArray[startIndex]=0;
			binaryArray[endIndex]=1;
			printAllPossibleBinaryNumbers(binaryArray, startIndex+1, endIndex-1, difference-1);
			
			binaryArray[startIndex]=0;
			binaryArray[endIndex]=0;
			printAllPossibleBinaryNumbers(binaryArray, startIndex+1, endIndex-1, difference);
		}
	}

}
