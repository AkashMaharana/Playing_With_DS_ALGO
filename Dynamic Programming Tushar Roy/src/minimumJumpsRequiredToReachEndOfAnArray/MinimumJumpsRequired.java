package minimumJumpsRequiredToReachEndOfAnArray;

public class MinimumJumpsRequired {
	
	public void minimumJumpRequired(int[] inputArray){
		int[] minimumJumpArray=new int[inputArray.length];
		int[] jumpPathArray=new int[inputArray.length];
		minimumJumpArray[0]=0;
		for(int i=1;i<minimumJumpArray.length;i++){
			minimumJumpArray[i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<minimumJumpArray.length;i++){
			for(int j=0;j<i;j++){
				if(i<=j+inputArray[j]){
					minimumJumpArray[i]=Math.min(minimumJumpArray[i], minimumJumpArray[j]+1);
				}
			}
		}
		for(int i=0;i<jumpPathArray.length;i++){
			System.out.print(jumpPathArray[i]+" ");
		}
	}

}
