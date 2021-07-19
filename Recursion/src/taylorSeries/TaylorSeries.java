package taylorSeries;

public class TaylorSeries {
	
	public static double power=1;
	public static double factorial=1;
	public double result=0.0;
	
	public double taylorSeries(int x,int n){
		if(n==0){
			return 1;
		}
		result=taylorSeries(x,n-1);
		power=power*x;
		factorial=factorial*n;
		return result+(power/factorial);
	}

}
