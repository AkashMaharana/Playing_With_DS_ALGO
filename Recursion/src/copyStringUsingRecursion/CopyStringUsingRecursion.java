package copyStringUsingRecursion;

public class CopyStringUsingRecursion {
	
	public void copyStringUsingRecursion(char[] s1,char[] s2,int length){
		if(length<0){
			return;
		}
		else{
			s2[length]=s1[length];
			length=length-1;
			copyStringUsingRecursion(s1, s2, length);
		}
	}

}
