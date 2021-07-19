package practice;

import java.util.Stack;

public class AreaOfHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is : " + getMaxArea(hist, hist.length));
	}

	private static int getMaxArea(int[] hist, int length) {
		Stack<Integer> s = new Stack<>();
		int maxArea = 0;
		int top;
		int areaWithTop = 0;
		int i = 0;
		while (i < length) {
			if (s.empty() || hist[s.peek()] <= hist[i]) {
				s.push(i++);
			} else {
				top = s.peek();
				s.pop();
				if (s.isEmpty()) {
					areaWithTop = hist[top] * i;
				} else {
					areaWithTop = hist[top] * (i - s.peek() - 1);
				}
			}
			if (maxArea < areaWithTop) {
				maxArea = areaWithTop;
			}
		}
		while(!s.isEmpty()){
			top = s.peek();
			s.pop();
			if (s.isEmpty()) {
				areaWithTop = hist[top] * i;
			} else {
				areaWithTop = hist[top] * (i - s.peek() - 1);
			}
			if (maxArea < areaWithTop) {
				maxArea = areaWithTop;
			}
		}
		return maxArea;
	}

}
