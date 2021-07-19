package weightedJobScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedJobScheduling {

	public void maximumProfit(Job[] jobsArray) {
		List<Job> jobList = Arrays.asList(jobsArray);
		Collections.sort(jobList, new Comparator<Job>() {
			public int compare(Job job1, Job job2) {
				return Integer.valueOf(job1.getEndTime()).compareTo(Integer.valueOf(job2.getEndTime()));
			}
		});

		int[] profitArray = new int[jobList.size()];
		int[] finalProfitArray = new int[jobList.size()];
		for (int i = 0; i < jobList.size(); i++) {
			profitArray[i] = jobList.get(i).getProfit();
			finalProfitArray[i] = jobList.get(i).getProfit();
		}
		int maximumProfit = profitArray[0];
		int finalProfitIndex = 0;
		for (int i = 1; i < profitArray.length; i++) {
			for (int j = 0; j < i; j++) {
				if (jobList.get(j).getEndTime() <= jobList.get(i).getStartTime()) {
					int netProfit = profitArray[i] + profitArray[j];
					if (netProfit > finalProfitArray[i]) {
						finalProfitArray[i] = netProfit;
					}
				}
				if (maximumProfit < finalProfitArray[i]) {
					maximumProfit = finalProfitArray[i];
					finalProfitIndex = i;
				}
			}
		}
		System.out.println("Maximum Profit : " + maximumProfit);
		showSequence(jobList, finalProfitIndex);
	}

	public void showSequence(List<Job> jobsList, int finalProfitIndex) {
		List<Job> sequenceList=new ArrayList<>();
		int startIndex=0;
		while(startIndex<finalProfitIndex){
			if(jobsList.get(startIndex).getEndTime()<=jobsList.get(finalProfitIndex).getStartTime()){
				sequenceList.add(jobsList.get(startIndex));
			}
			startIndex++;
		}
		sequenceList.add(jobsList.get(finalProfitIndex));
		int beginIndex=0;
		int endIndex=1;
		while(beginIndex<endIndex && endIndex<sequenceList.size()){
			if(sequenceList.get(beginIndex).getEndTime()>sequenceList.get(endIndex).getStartTime()){
				if(sequenceList.get(beginIndex).getProfit()>sequenceList.get(endIndex).getProfit()){
					sequenceList.remove(endIndex);
				}
				else{
					sequenceList.remove(beginIndex);
				}
			}
			else{
				startIndex++;
				endIndex++;
			}
		}
		System.out.print("Job sequence is : ");
		for(Job job : sequenceList){
			System.out.print(job.getJobName()+" ");
		}
		System.out.println();
	}

}
