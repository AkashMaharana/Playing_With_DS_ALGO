import java.util.Stack;

public class PoisonousPlants {
	
	public static void main(String[] args) {
		int[] arr={6,5,8,4,7,10,9};
		System.out.println(poisonousPlants(arr));;
	}
	
	static int poisonousPlants(int[] p){
		Stack<Integer> s=new Stack<>();
		int minimumdays=minimumDaysForPoison(p,0,s);
		return minimumdays;
	}

	private static int minimumDaysForPoison(int[] p,int minimumDays,Stack<Integer> s) {
		for(int i=1;i<p.length;i++){
			if(p[i]!=0 && p[i-1]!=0){
				if(p[i-1]<p[i]){
					s.push(i);
				}
			}
			else{
				int firstTemp=0;
				while(p[i-1]<0){
					i--;
				}
				firstTemp=p[i-1];
				while((i+1)<p.length && p[i+1]>0){
					if(firstTemp<p[i+1]){
						s.push(i+1);
					}
					i++;
				}
			}
		}
		System.out.println();
		if(s.isEmpty()){
			return minimumDays;
		}
		else{
			while(!s.isEmpty()){
				p[s.peek()]=0;
				s.pop();
			}
			minimumDays=minimumDays+1;
			return minimumDaysForPoison(p,minimumDays,s);
		}
	}

}
