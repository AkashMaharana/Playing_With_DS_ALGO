package weightedJobScheduling;

public class Job {

	private char jobName;
	private int startTime;
	private int endTime;
	private int profit;

	public Job(int startTime, int endTime, int profit, char jobName) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
		this.jobName = jobName;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getProfit() {
		return profit;
	}

	public char getJobName() {
		return jobName;
	}

}
