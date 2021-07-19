package byteByByte;

public class _13_ImplementKStacksInAnArray {
	
	private int[] stackData;
	private int[] topIndex;
	private int nexAvailableIndex;
	private int[] nextIndexArray;
	
	public _13_ImplementKStacksInAnArray(int lengthOfArray,int numberOfStack) {
		this.stackData=new int[lengthOfArray];
		this.topIndex=new int[numberOfStack];
		this.nexAvailableIndex=0;
		this.nextIndexArray=new int[lengthOfArray];
		for(int i=0;i<this.topIndex.length;i++) {
			this.topIndex[i]=-1;
		}
		for(int i=0;i<this.nextIndexArray.length;i++) {
			this.nextIndexArray[i]=i+1;
		}
		this.nextIndexArray[this.nextIndexArray.length-1]=-1;
	}
	
	private void push(int stackNumber,int number) {
		int currentTop=this.topIndex[stackNumber];
		int currentStackDataIndex=nexAvailableIndex;
		int next=this.nextIndexArray[nexAvailableIndex];
		this.stackData[nexAvailableIndex]=number;
		this.topIndex[stackNumber]=currentStackDataIndex;
		this.nextIndexArray[nexAvailableIndex]=currentTop;
		this.nexAvailableIndex=next;
		
		for(int i=0;i<this.topIndex.length;i++) {
			System.out.print(this.topIndex[i]+" ");
		}
		System.out.println();
		for(int i=0;i<this.stackData.length;i++) {
			System.out.print(this.stackData[i]+" ");
		}
		System.out.println();
		for(int i=0;i<this.nextIndexArray.length;i++) {
			System.out.print(this.nextIndexArray[i]+" ");
		}
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	private int pop(int stackNumber) {
		int currentTop=this.topIndex[stackNumber];
		int itemToReturn=this.stackData[this.topIndex[stackNumber]];
		int nextTop=this.nextIndexArray[currentTop];
		this.topIndex[stackNumber]=nextTop;
		this.nextIndexArray[currentTop]=this.nexAvailableIndex;
		this.nexAvailableIndex=currentTop;
	
		for(int i=0;i<this.topIndex.length;i++) {
			System.out.print(this.topIndex[i]+" ");
		}
		System.out.println();
		for(int i=0;i<this.stackData.length;i++) {
			System.out.print(this.stackData[i]+" ");
		}
		System.out.println();
		for(int i=0;i<this.nextIndexArray.length;i++) {
			System.out.print(this.nextIndexArray[i]+" ");
		}
		System.out.println();
		System.out.println("---------------------------------------");
		return itemToReturn;
	}
	
	public static void main(String[] args) {
		_13_ImplementKStacksInAnArray temp=new _13_ImplementKStacksInAnArray(6, 3);
		temp.push(0, 5);
		temp.push(0, 6);
		temp.push(1, 10);
		temp.push(2, 20);
		System.out.println(temp.pop(0));
		System.out.println(temp.pop(0));
	}

}
