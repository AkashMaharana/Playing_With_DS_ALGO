package com.akash.maharana.array;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSellToMaximizeProfit {
	
	public static void main(String[] args) {
		int[] arr={100, 180, 260, 310, 40, 535, 695};
		List<Interval> intervals=new ArrayList<>();
		getTheProfitIntervals(arr,intervals);
		if(intervals.size()==0) {
			System.out.println("No profit exists in the given period.");
		} else {
			for(Interval i : intervals) {
				System.out.println("Buy on "+i.buy+" and "+"Sell on "+i.sell+".");
			}
		}
	}
	
	private static void getTheProfitIntervals(int[] arr,List<Interval> intervals){
		if(arr.length==1) {
			return;
		}
		int i=0;
		while(i<arr.length-1) {
			while(i<arr.length-1 && arr[i+1]<=arr[i]) {
				i++;
			}
			if(i==arr.length-1) {
				break;
			}
			Interval interval=new Interval();
			interval.buy=i++;
			while(i<arr.length && arr[i]>arr[i-1]) {
				i++;
			}
			interval.sell=i-1;
			intervals.add(interval);
		}
	}

}

class Interval{
	int buy;
	int sell;
}
