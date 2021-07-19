import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsOneRoom {

	public static void main(String[] args) {
		int[] start = { 1, 0, 5, 8, 5, 3 };
		int[] end = { 4, 6, 7, 9, 9, 4 };
		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			list.add(new Meeting(start[i], end[i]));
		}
		Collections.sort(list,
				Comparator.comparing(Meeting::getEndTime)
				.thenComparing(Comparator.comparing(Meeting::getStatTime)));
		
		list.forEach(meeting->System.out.println(meeting.getStatTime()+" : "+meeting.getEndTime()));
	}

}

class Meeting {

	public int statTime;
	public int endTime;

	public Meeting(int startTime, int endTime) {
		this.statTime = startTime;
		this.endTime = endTime;
	}

	public int getStatTime() {
		return statTime;
	}

	public int getEndTime() {
		return endTime;
	}

}
