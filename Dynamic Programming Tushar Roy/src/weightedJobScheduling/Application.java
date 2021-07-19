package weightedJobScheduling;

public class Application {
	
	public static void main(String[] args) {
		Job jobList[] = {new Job(1, 4, 3 ,'A'), 
						 new Job(2, 6, 5, 'B'), 
						 new Job(4, 7, 2, 'C'), 
						 new Job(5, 9, 4, 'D'),
						 new Job(6, 8, 6, 'E'),
						 new Job(7, 10, 8, 'F')};
		WeightedJobScheduling wjs=new WeightedJobScheduling();
		wjs.maximumProfit(jobList);
	}

}
